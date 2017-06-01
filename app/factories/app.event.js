(function(){
    'use strict';

    angular
        .module('yaApp')
        .factory("eventApi",eventApi);

    eventApi.$inject = ["$resource"];
    function eventApi($resource){
        return $resource("https://ya-se-armo-api.herokuapp.com/yaAPI/v1/eventos/")
    }
})();