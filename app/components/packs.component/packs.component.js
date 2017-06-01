(function () {
    'use strict'

    var yaPacks = {
        templateUrl: './app/components/packs.component/packs.component.html',
        controller: packsCtrl
    };

    angular
        .module('yaApp')
        .component('yaPacks', yaPacks);

    packsCtrl.$inject = ['$location', 'packsApi'];

    function packsCtrl($location, packsApi) {
        var vm = this;

        vm.packs = null;
        vm.apiData = null;

        vm.$onInit = onInit;
        //vm.otherFun = function(){}

        function onInit() {

            vm.apiData = packsApi.query()
            console.log(vm.apiData)
        }
    }
})();


