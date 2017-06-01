(function () {
    'use strict'


    var yaFriends = {
        templateUrl:'app/components/friends.component/friends.component.html',
        controller:friendsCtrl,
    }


    friendsCtrl.$inject = [ '$location', 'usersJson', '$scope'];

    function  friendsCtrl($location,usersJson, $scope) {

        var users = this;

        users.apiData = usersJson.query();
        console.log(users)

        $('#modal2').modal().modal();



    }

    angular
        .module('yaApp')
        .component('yaFriends',yaFriends)
})();
