(function () {
    'use strict'

    var yaEvent = {
        bindings: {
            category: "="
        },
        templateUrl: './app/components/event.component/event.component.html',
        controller: eventCtrl
    };


        angular
            .module('yaApp')
            .component('yaEvent', yaEvent);

        eventCtrl.$inject = ["usersJson"];

        function eventCtrl(usersJson) {
            var users = this;

            users.apiData = usersJson.query();
            console.log(users)

        }
})();
