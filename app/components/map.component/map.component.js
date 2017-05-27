(function () {
    'use strict'

    var yaMap = {
        bindings: {
            category: "="
        },
        templateUrl: './app/components/map.component/map.component.html',
        controller: mapCtrl
    };

    angular
        .module('yaApp')
        .component('yaMap', yaMap);

    function mapCtrl() {
        var vm = this;
    }
})();