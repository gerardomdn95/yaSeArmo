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

        function comenzar() {
            console.log("Hola");
            var miboton = document.getElementById("dame_ubicacion");
            miboton.addEventListener("click", obtener, false);
        }

        function obtener() {
            navigator.geolocation.getCurrentPosition(mostrar_posicion);
        }

        function mostrar_posicion(posicion) {
            var ubicacion = document.getElementById("ubicacion");
            var mi_ubicacion = "";
            mi_ubicacion += "Latitud: " + posicion.coords.latitude + "<br>";
            mi_ubicacion += "Longitud: " + posicion.coords.longitude + "<br>";
            mi_ubicacion += "Exactitud: " + posicion.coords.accuracy + "<br>";
            ubicacion.innerHTML = mi_ubicacion;
        }

        window.addEventListener("load", comenzar, false);

    }
})();