class AveragePrice < ActiveRecord::Base
  validates_numericality_of :average_petrol, :on => :create,
                            :greater_than => 1.00,
                            :less_than => 2.50,
                            :allow_blank => false
  validates_numericality_of :average_diesel, :on => :create,
                            :greater_than => 1.00,
                            :less_than => 2.50,
                            :allow_blank => false
  validates_numericality_of :average_oil, :on => :create,
                            :greater_than => 0.2,
                            :less_than => 2.0,
                            :allow_blank => false

  class << self
    def correlation_oil_and(fuel)
      #
      # http://www.mathsisfun.com/data/correlation.html
      #

      target = 0
      oil = 0
      count = 0

      models = all

      # Step One - Find the mean of x, and the mean of y
      models.each do |object|
        if fuel == 'diesel'
          target += object.average_diesel
          oil += object.average_oil
        elsif fuel == 'petrol'
          target += object.average_petrol
          oil += object.average_oil
        end

        count += 1
      end

      average_target = target / count
      average_oil = oil / count

      # Step Two - Subtract the mean of x from every x value (call them "a"), do the same for y	(call them "b")
      models.each do |object|
        if fuel == 'diesel'
          object.average_diesel -= average_target
        elsif fuel == 'petrol'
          object.average_petrol -= average_target
        end

        object.average_oil -= average_oil
      end

      # Step Three - Calculate: a × b, a2 and b2 for every value
      step_three = []

      models.each do |object|
        if fuel == 'diesel'
          var = {
              :sum_a_b => object.average_diesel * object.average_oil,
              :square_a => object.average_diesel * object.average_diesel,
              :square_b => object.average_oil * object.average_oil
          }
        elsif fuel == 'petrol'
          var = {
              :sum_a_b => object.average_petrol * object.average_oil,
              :square_a => object.average_petrol * object.average_petrol,
              :square_b => object.average_oil * object.average_oil
          }
        end

        step_three.push var
      end

      # Step Four - Sum up a × b, sum up a2 and sum up b2
      total_sum_a_b = 0
      total_square_a = 0
      total_square_b = 0

      step_three.each do |object|
        total_sum_a_b += object[:sum_a_b]
        total_square_a += object[:square_a]
        total_square_b += object[:square_b]
      end

      # Step Five - Divide the sum of a × b by the square root of [(sum of a2) × (sum of b2)]
      total_sum_a_b / Math.sqrt(total_square_a * total_square_b)
    end
  end
end
