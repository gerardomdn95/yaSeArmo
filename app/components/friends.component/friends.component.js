(function () {
    'use strict'

    var yaFriends = {
        templateUrl: './app/components/friends.component/friends.component.html',
        controller: friendsCtrl
    };
    
    angular
        .module('yaApp')
        .component('yaFriends', yaFriends);

    friendsCtrl.$inject = ["usersJson"];

    function friendsCtrl(usersJson) {
        var users = this;

        users.apiData = usersJson.query();
        console.log(users)
    }
})();