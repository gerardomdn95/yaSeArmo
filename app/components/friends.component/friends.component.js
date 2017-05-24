(function(){
    'use strict'

var yaFriends = {
    templateUrl: './app/components/friends.component/friends.component.html',
    controller: friendsCtrl
};
    angular
        .module('yaApp')
        .component('yaFriends', yaFriends);

    friendsCtrl.$inject = ["usersJson"];
    console.log("Hola")

    function friendsCtrl(usersJson){
        var users = this;
        console.log("Hola")
        
        users.apiData = usersJson.query();
    }
})();