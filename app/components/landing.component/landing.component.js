(function () {
    'use strict'

    var yaLanding = {
        bindings: {
            category: "="
        },
        templateUrl: './app/components/landing.component/landing.component.html',
        controller: landingCtrl
    };

    angular
        .module('yaApp')
        .component('yaLanding', yaLanding);

    function landingCtrl() {
        var vm = this;
    }
})();