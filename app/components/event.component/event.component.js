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

    function eventCtrl() {
        var vm = this;
    }
})();