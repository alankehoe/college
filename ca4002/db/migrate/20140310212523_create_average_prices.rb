class CreateAveragePrices < ActiveRecord::Migration
  def change
    create_table :average_prices do |t|
      t.float :average_diesel
      t.float :average_petrol

      t.timestamps
    end
  end
end
