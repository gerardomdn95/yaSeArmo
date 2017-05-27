(function(){
    'use strict'

var yaNav = {
    templateUrl: './app/components/nav.component/nav.component.html',
    controller: navCtrl
};
    angular
        .module('yaApp')
        .component('yaNav', yaNav);

    function navCtrl(){
        var vm = this;
    }
})();