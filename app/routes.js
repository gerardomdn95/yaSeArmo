(function(){
    'use strict';

    angular
        .module('yaApp')
        .config(config);

    config.$inject = ["$routeProvider"];
    function config($routeProvider) {
        $routeProvider
            .when('/friends',
                {
                    template: "<ya-friends></ya-friends>"
                })
            .when('/login',
                {
                    template: "<login></login>"
                })
            .otherwise({
                redirectTo : '/'
            });
    }

})();