class AddOilPriceToAveragePrice < ActiveRecord::Migration
  def change
    add_column :average_prices, :average_oil, :float
  end
end
