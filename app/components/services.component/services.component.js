(function(){
    'use strict'

var yaServices = {
    templateUrl: './app/components/services.component/services.component.html',
    controller: servicesCtrl
};

    angular
        .module('yaApp')
        .component('yaServices', yaServices);

    function servicesCtrl(){
        var vm = this;
         $('.modal').modal();
    }
})();