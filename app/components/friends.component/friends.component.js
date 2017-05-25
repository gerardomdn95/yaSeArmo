(function () {
    'use strict'



    var yaFriends = {
        templateUrl:'app/components/friends.component/friends.component.html',
        controller:friendsCtrl,
    }


    friendsCtrl.$inject = [ '$location', "usersJson"];

    function  friendsCtrl($location,usersJson) {

        var users = this;
 
        users.apiData = usersJson.query();
        console.log(users)
    }
        
    angular
        .module('yaApp')
        .component('yaFriends',yaFriends)
})();





