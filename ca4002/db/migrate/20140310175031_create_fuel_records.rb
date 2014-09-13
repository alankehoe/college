class CreateFuelRecords < ActiveRecord::Migration
  def change
    create_table :fuel_records do |t|
      t.string :name
      t.string :road
      t.string :area
      t.string :county
      t.float :petrol
      t.float :diesel

      t.timestamps
    end
  end
end
