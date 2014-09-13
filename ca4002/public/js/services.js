'use strict';

/* Services */


// Demonstrate how to register services
angular.module('myApp.services', [])
    .factory('AveragePricesService', [ '$http', function ($http) {
        return {
            index: function (success) {
                $http({
                    method: 'GET',
                    url: '/api/average_prices.json',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/json'
                    }
                }).success(function (data) {
                    success(data);
                }).error(function (data) {
                    console.log('error' + data);
                })
            },

            show: function (success) {
                $http({
                    method: 'GET',
                    url: '/api/average_prices/1.json',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/json'
                    }
                }).success(function (data) {
                    success(data);
                }).error(function (data) {
                    console.log('error' + data);
                })
            }
        }
    }])

    .factory('CorrelationsService', [ '$http', function ($http) {
        return {
            index: function (success) {
                $http({
                    method: 'GET',
                    url: '/api/correlations.json',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/json'
                    }
                }).success(function (data) {
                    success(data);
                }).error(function (data) {
                    console.log('error' + data);
                })
            }
        }
    }]);

