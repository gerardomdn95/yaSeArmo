(function(){
    'use strict';

    angular
        .module('yaApp')
        .factory("packsApi",packsApi);

    packsApi.$inject = ["$resource"];
    function starApi($resource){
        return $resource("https://ya-se-armo-api.herokuapp.com/yaAPI/v1/productos/paquetes/")
    }
})();