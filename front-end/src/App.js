import React, { Component } from 'react'
import './App.css'
import LaunchScreen from './LaunchScreen'
import Register from './register'
import Login from './login'
import CameraScreen from './cameraScreen';

class App extends Component {
  router() {
    switch (document.location.pathname) {
      case '/':
        return <LaunchScreen />
      case '/register':
        return <Register />
      case '/login':
        return <Login />
      case '/camera':
        return <CameraScreen />
      default:
        break
      // return <Error />
    }
  }

  render() {
    return this.router()
  }
}

export default App
