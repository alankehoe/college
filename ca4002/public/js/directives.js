'use strict';

/* Directives */


angular.module('myApp.directives', [])

    .directive('navbar', function () {
        return {
            restrict: 'E',
            templateUrl: 'partials/navbar.html'
        }
    })

    .directive('gauges', function () {
        return {
            restrict: 'E',
            templateUrl: 'partials/gauges.html'
        }
    });
