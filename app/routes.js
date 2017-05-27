(function () {

    'use strict'


>>>>>>> d003a2a992a99038471eeb5134c4566ec59d448c

    angular
        .module('yaApp')
        .config(config);

    function config($routeProvider) {
        $routeProvider
<<<<<<< HEAD
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