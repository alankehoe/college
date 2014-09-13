'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', [
        'ngRoute',
        'myApp.filters',
        'myApp.services',
        'myApp.directives',
        'myApp.controllers',
        'ui.bootstrap',
        'n3-charts.linechart',
        'n3-pie-chart',
        'highcharts-ng'
    ]).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/main.html'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);
