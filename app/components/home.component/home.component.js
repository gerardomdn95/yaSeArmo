(function () {
    'use strict'

    var yaHome = {
        bindings: {
            category: "="
        },
        templateUrl: './app/components/home.component/home.component.html',
        controller: homeCtrl
    };

    angular
        .module('yaApp')
        .component('yaHome', yaHome);

    function homeCtrl() {
        var vm = this;
    }
})();