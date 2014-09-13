Ca4002Api::Application.routes.draw do

  namespace :api do
    resources :average_prices, only: [:index, :create, :show]
    resources :correlations, only: [:index]
  end

end
