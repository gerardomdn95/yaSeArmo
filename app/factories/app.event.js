(function(){
    'use strict';

    angular
        .module('yaApp')
        .factory("eventApi",eventApi);

    packsApi.$inject = ["$resource"];
    function packsApi($resource){
        return $resource("https://ya-se-armo-api.herokuapp.com/yaAPI/v1/eventos/")
    }
})();