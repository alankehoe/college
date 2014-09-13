'use strict';

/* Controllers */

angular.module('myApp.controllers', [])

    .controller('GaugeController', ['$scope', 'AveragePricesService', function ($scope, AveragePricesService) {
        $scope.diesel_data = [];
        $scope.petrol_data = [];
        $scope.oil_data = [];

        $scope.init = function () {
            AveragePricesService.show(function (data) {
                $scope.diesel_data = [];
                $scope.petrol_data = [];
                $scope.oil_data = [];
                angular.forEach(data, function (average_price) {
                    $scope.diesel_data.push({
                            label: 'diesel',
                            value: average_price.average_diesel.toFixed(2),
                            color: "#000000",
                            suffix: '€'
                        }
                    );
                    $scope.petrol_data.push({
                            label: 'petrol',
                            value: average_price.average_petrol.toFixed(2),
                            color: '#048A58',
                            suffix: '€'
                        }
                    );
                    $scope.oil_data.push({
                            label: 'oil',
                            value: average_price.average_oil.toFixed(2),
                            color: '#19586D',
                            suffix: '$'
                        }
                    );
                });
            });
        };

        $scope.diesel_options = {thickness: 5, mode: "gauge", total: 2.0};
        $scope.petrol_options = {thickness: 5, mode: "gauge", total: 2.0};
        $scope.oil_options = {thickness: 5, mode: "gauge", total: 2.0};

        $scope.init();
    }])

    .controller('CorrelationsCtrl', ['$scope', 'CorrelationsService', function ($scope, CorrelationsService) {
        CorrelationsService.index(function (data) {
            $scope.correlations = data
        });
    }])

    .controller('myctrl', ['$scope', 'AveragePricesService', function ($scope, AveragePricesService) {

        $scope.init = function () {
            AveragePricesService.index(function (data) {
                angular.forEach(data, function (average_prices) {
                    angular.forEach(average_prices, function (average_price) {
                        $scope.chartConfig.series[0].data.push([
                            Date.parse(average_price.average_price.created_at),
                            average_price.average_price.average_diesel
                        ]);
                        $scope.chartConfig.series[1].data.push([
                            Date.parse(average_price.average_price.created_at),
                            average_price.average_price.average_petrol
                        ]);
                        $scope.chartConfig.series[2].data.push([
                            Date.parse(average_price.average_price.created_at),
                            average_price.average_price.average_oil
                        ]);
                    });
                });
            });
        };

        $scope.chartConfig = {
            //This is not a highcharts object. It just looks a little like one!

            options: {
                //This is the Main Highcharts chart config. Any Highchart options are valid here.
                //will be overriden by values specified below.
                chart: {
                    type: 'line',
                    zoomType: 'x'
                },
                rangeSelector: {enabled: true},
                tooltip: {
                    style: {
                        padding: 10,
                        fontWeight: 'bold'
                    }
                },
                plotOptions: {
                    series: {
                        stacking: ''
                    }
                }
            },

            //The below properties are watched separately for changes.

            //Series object - a list of series using normal highcharts series options.
            series: [
                {
                    name: 'Diesel',
                    type: 'spline',
                    color: '#0A000A',
                    data: []
                },
                {
                    name: 'Petrol',
                    type: 'spline',
                    color: '#048A58',
                    data: []
                },
                {
                    name: 'Oil',
                    type: 'spline',
                    color: '#19586D',
                    data: []
                }
            ],
            //Title configuration
            title: {
                text: 'Fuel over time'
            },
            //Boolean to control showing loading status on chart
            loading: false,
            //Configuration for the xAxis. Currently only one x axis can be dynamically controlled.
            //properties currentMin and currentMax provided 2-way binding to the chart's maximum and minimum
            xAxis: {
                type: 'datetime',
                maxZoom: 2 * 3600000 // 2 hours
            },
            //Whether to use HighStocks instead of HighCharts. Defaults to false.
            useHighStocks: false
        };

        $scope.init();
    }]);