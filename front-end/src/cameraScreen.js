import React, { Component } from 'react'
import './cameraScreen.css'
import { localized } from './l10n'
import util from './util'

class CameraScreen extends Component {
  stopVideo() {
    const player = document.querySelector('video')
    if (player.srcObject) {
      player.srcObject.getVideoTracks().forEach(track => track.stop())
    }
  }

  capture() {
    const video = document.querySelector('video')
    const canvas = document.querySelector('canvas')
    const context = canvas.getContext('2d')
    context.drawImage(video, 0, 0, canvas.width, canvas.height)
    this.stopVideo()
    this.getImage()
  }

  getImage() {
    const canvas = document.querySelector('canvas')
    const data = canvas.toDataURL()
    const blob = util.dataToBlob(data)
    return blob
  }

  componentDidMount() {
    util.getCameraAccess()

    // TODO: get camera access -> completion handler -> set canvas to size of video

    const canvas = document.querySelector('canvas')
    canvas.setAttribute('width', window.getComputedStyle(canvas, null).getPropertyValue('width'))
    canvas.setAttribute('height', window.getComputedStyle(canvas, null).getPropertyValue('height'))
  }

  render() {
    return (
      <div className="App">
        <video id="video" controls autoPlay></video>
        <canvas id="canvas"></canvas>
        <button
          className="camera__captureButton"
          onClick={this.capture.bind(this)}
        >
          IMAGE
        </button>
      </div>
    )
  }
}

export default CameraScreen
