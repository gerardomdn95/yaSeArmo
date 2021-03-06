(function () {
    'use strict'

    var yaFriends = {
        templateUrl: 'app/components/friends.component/friends.component.html',
        controller: friendsCtrl,
    }


    friendsCtrl.$inject = ['$location', 'users', '$scope'];

    function friendsCtrl($location, users, $scope) {

        var self = this;

        self.$onInit = function () {
            self.friends = users.query()
        }

        console.log(self.friends)
    }

    angular
        .module('yaApp')
        .component('yaFriends', yaFriends)
})();
