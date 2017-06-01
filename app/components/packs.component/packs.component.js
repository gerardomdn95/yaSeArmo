(function() {
    'use strict'

    var yaPacks = {
        templateUrl: './app/components/packs.component/packs.component.html',
        controller: packsCtrl
    };

    packsCtrl.$inject = ['$location', "usersJson"];

    function packsCtrl($location, usersJson) {

        var users = this;

        users.apiData = usersJson.query();
        console.log(users)
    }

    angular
        .module('yaApp')
        .component('yaPacks', yaPacks);
})();

/*
packsCtrl.$inject = ["packsApi"];
    function packsCtrl(packsApi) {
        var vm = this;

        vm.packs = null;
        vm.apiData = null;

        vm.$onInit = onInit;
        //vm.otherFun = function(){}

        function onInit(){
            vm.apiData = packsApi.get({category: vm.category})
                .$promise
                .then(function(response){
                    console.log(response)
                    vm.packs = response.results
                });
        }
    }
*/