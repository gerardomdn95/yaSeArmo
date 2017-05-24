(function(){
    'use strict'

var yaLanding = {
    templateUrl: './app/components/home.component/landing.component.html',
    controller: landingCtrl
};

    angular
        .module('yaApp')
        .component('yaLanding', yaLanding);

    function landingCtrl(){
        var vm = this;
    }
})();