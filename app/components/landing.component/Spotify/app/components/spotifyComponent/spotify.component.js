(() => {
  'use strict'

  const spotifyComponent = {
    templateUrl : './app/components/spotifyComponent/spotify.component.html',
    controller : spotifyController
  }

  spotifyController.$inject = ['spotifyAPI']
  function spotifyController (spotifyAPI) {

    let self = this

    self.audio = new Audio
    self.searchlist

    self.search = () => {
      self.apiData = spotifyAPI.get({
        song : self.song_name
      }).$promise
        .then((response) => {
          self.searchlist = response.tracks.items
        }).finally(() => {
          console.info(self.searchlist)
        })
    }

    self.play = (song) => {
      self.song = song
      self.audio.src = song.preview_url
      self.audio.play()
    }

    self.pause = () => {
      self.audio.paused ? self.audio.play() : self.audio.pause()
    }

    self.playing = () => {
      self.audio.paused ? self.audio.play() : self.audio.pause()
    }

  }

  function toSeconds (miliseconds) {
    return (miliseconds/1000/60) << 0 + ':' + (miliseconds/1000) % 60;
  }

  angular
    .module('spotify')
    .component('spotifyComponent', spotifyComponent)
    .filter('toSeconds', toSeconds)
})()