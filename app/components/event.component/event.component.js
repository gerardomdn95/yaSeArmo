(function(){
    'use strict'

var yaEvent = {
    templateUrl: './app/components/event.component/event.component.html',
    controller: eventCtrl
}

    angular
        .module('yaApp')
        .component('yaEvent', yaEvent);

    function eventCtrl(){
        var vm = this;
    }
})();
