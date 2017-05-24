(function(){
    'use strict';

    angular
        .module('yaApp')
        .factory("usersJson", usersJson);

    usersJson.$inject = ["$resource"];
    function usersJson($resource){
        return $resource("../server/users.json")
    }
})();