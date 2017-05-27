(function () {

    'use strict'

    angular
        .module('yaApp')
        .config(config);

    function config($routeProvider) {
        $routeProvider

            .when('/event',{
                template:'<ya-event></ya-event>'
            })

            .when('/friendsmo',{
                template:'<h1>Hola Morros dodo<h1>'
            })


            .otherwise({
                redirectTo: '/'
            });
    }

})();
