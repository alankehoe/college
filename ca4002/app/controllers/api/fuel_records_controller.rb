module Api
  class FuelRecordsController < ApplicationController

    def index
      @fuel_records = FuelRecord.where(
          "county LIKE ?","%#{params[:county]}%"
      )

      respond_with @fuel_records
    end

    def show
    end

    def create
      @fuel_record = FuelRecord.create!(fuel_record_params)

      respond_with @fuel_record
    end

    def update
    end

    def destroy
    end

    private

    def fuel_record_params
      params.required(:fuel_record).permit(:name, :road, :area, :county, :petrol, :diesel)
    end
  end
end
