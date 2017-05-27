(function () {
    'use strict'

    var yaServices = {
        templateUrl: './app/components/services.component/services.component.html',
        controller: servicesCtrl
    };



    angular
        .module('yaApp')
        .component('yaServices', yaServices);

    servicesCtrl.$inject = ["usersJson"];

    function servicesCtrl(usersJson) {
        var users = this;



        $('.modal').modal();
        users.apiData = usersJson.query();
        console.log(users)
        $('.collapsible').collapsible({
          accordion : true
        });

        

    }
})();

// $scope.collapsibleElements = [{
//         icon: 'mdi-image-filter-drama',
//         title: 'First',
//         content: 'Lorem ipsum dolor sit amet.'
//     },{
//         icon: 'mdi-maps-place',
//         title: 'Second',
//         content: 'Lorem ipsum dolor sit amet.'
//     },{
//         icon: 'mdi-social-whatshot',
//         title: 'Third',
//         content: 'Lorem ipsum dolor sit amet.'
//     }
// ];
