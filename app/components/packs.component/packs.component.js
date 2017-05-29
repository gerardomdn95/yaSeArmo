(function () {
    'use strict'

    var yaPacks = {
        templateUrl: './app/components/packs.component/packs.component.html',
        controller: packsCtrl
    };

    packsCtrl.$inject = ['$location', "usersJson"];

    function packsCtrl($location, usersJson) {

        var users = this;
        $('.collapsible').collapsible();
        users.apiData = usersJson.query();
        console.log(users)
    }

    angular
        .module('yaApp')
        .component('yaPacks', yaPacks);
})();