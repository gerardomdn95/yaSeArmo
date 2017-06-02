(function () {
    'use strict'

    var yaLogin = {
        bindings: {
            category: "="
        },
        templateUrl: './app/components/login.component/login.component.html',
        controller: loginCtrl
    };

    angular
        .module('yaApp')
        .component('yaLogin', yaLogin);

    function loginCtrl() {
        var vm = this;

        vm.reloader = reloader;
    }
})();
