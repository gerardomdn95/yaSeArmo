(function () {

    'use strict'

    angular
        .module('yaApp')
        .config(config);

    function config($routeProvider) {
        $routeProvider

            .when('/home',{
                template:'<ya-home></ya-home>'
            })

            .when('/yaevent',{
                template:'<ya-event></ya-event>'
            })
            
            .when('/yafriends',{
                template:'<ya-friends></ya-friends>'
            })

            .when('/yaservices',{
                template:'<ya-services></ya-services>'
            })
            .when('/yapacks',{
                template:'<ya-packs></ya-packs>'
            })

            .when('/prueba',{
                template:'<h1>Prosible vista</h1>'
            })
            .when('/yamap',{
                template:'<ya-map></ya-map>'
            })
        
            .otherwise({
                redirectTo:'/home'
            })
    }


})();
