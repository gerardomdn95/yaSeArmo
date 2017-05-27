(function () {
    'use strict';

    angular
        .module('yaApp')
        .config(config);

    config.$inject = ["$routeProvider"];
    function config($routeProvider) {
        $routeProvider
            .when('/event',
            {
                template: `<ya-event></ya-event>`
            })
            .when('/friends',
            {
                template: "<ya-friends></ya-friends>"
            })
            .when('/home',
            {
                template: "<ya-friends></ya-friends>"
            })
            .when('/landing',
            {
                template: "<ya-friends></ya-friends>"
            })
            .when('/services',
            {
                template: "<ya-services></ya-services>"
            })
            .otherwise({
                redirectTo: '/'
            });
    }
})();