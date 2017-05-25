(function () {
    'use strict'

    var yaServices = {
        templateUrl: './app/components/services.component/services.component.html',
        controller: servicesCtrl
    };

    angular
        .module('yaApp')
        .component('yaServices', yaServices);

    servicesCtrl.$inject = ["usersJson"];

    function servicesCtrl(usersJson) {
        var users = this;

        $('.modal').modal();
        users.apiData = usersJson.query();
        console.log(users)
    }
})();