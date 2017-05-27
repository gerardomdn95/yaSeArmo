(function () {
    'use strict'


    var yaFriends = {
        bindings: {
            category: "="
        },
        templateUrl: './app/components/friends.component/friends.component.html',
        controller: friendsCtrl
    };

    angular
        .module('yaApp')
        .component('yaFriends', yaFriends);


    friendsCtrl.$inject = [ '$location', "usersJson"];

    function  friendsCtrl($location,usersJson) {

        var users = this;
 
        users.apiData = usersJson.query();
        console.log(users)
    }
})();





