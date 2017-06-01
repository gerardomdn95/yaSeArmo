(function () {
    'use strict'

    var yaEvent = {
        templateUrl: './app/components/event.component/event.component.html',
        controller: eventCtrl
    };

    angular
        .module('yaApp')
        .component('yaEvent', yaEvent);

    eventCtrl.$inject = ['$location', 'eventApi'];

    function eventCtrl($location, eventApi) {
        var vm = this;

        vm.evento = null;
        vm.apiData = null;

        vm.$onInit = onInit;

        function onInit() {

            vm.apiData = eventApi.query()
            console.log(vm.apiData)
        }
    }
})();