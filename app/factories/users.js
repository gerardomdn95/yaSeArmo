(function(){
    'use strict';

    angular
        .module('yaApp')
        .factory("users", users);

    users.$inject = ["$resource"];
    function users($resource){
        return $resource("https://ya-se-armo-api.herokuapp.com/yaAPI/v1/eventos/invitados")
    }
})();
