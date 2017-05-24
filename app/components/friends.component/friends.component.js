(function(){
    'use strict'

var yaFriends = {
    templateUrl: './app/components/friends.component/friends.component.html',
    controller: friendsCtrl
};
    angular
        .module('yaApp')
        .component('yaFriends', yaFriends);

    function friendsCtrl(){
        var vm = this;
    }
})();