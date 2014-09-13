module Api
  class AveragePricesController < ApplicationController

    def index
      @average_prices = AveragePrice.all

      respond_with @average_prices
    end

    def show
      @average_price = AveragePrice.last

      respond_with @average_price
    end

    def create
      @average_price = AveragePrice.create!(average_price_params)
    end

    def update
    end

    def destroy
    end

    private

    def average_price_params
      params.required(:average_values).permit(:average_diesel, :average_petrol, :average_oil)
    end
  end
end
