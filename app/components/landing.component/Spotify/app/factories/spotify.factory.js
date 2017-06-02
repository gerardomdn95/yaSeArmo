(() => {
  'use strict'

  angular
    .module('spotify', ['ngResource'])
    .factory('spotifyAPI', spotifyAPI)

  spotifyAPI.$inject = ['$resource']
  function spotifyAPI ($resource) {
    return $resource('https://api.spotify.com/v1/search?query=:song&type=track&market=MX')
  }

})()