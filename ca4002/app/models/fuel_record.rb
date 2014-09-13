class FuelRecord < ActiveRecord::Base
  validates_numericality_of :diesel, :on => :create,
                            :greater_than => 100.0,
                            :less_than => 250.0,
                            :allow_blank => false
  validates_numericality_of :petrol, :on => :create,
                            :greater_than => 100.0,
                            :less_than => 250.0,
                            :allow_blank => true
end
