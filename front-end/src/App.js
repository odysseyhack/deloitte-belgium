import React, { Component } from 'react'
import './App.css'
import LaunchScreen from './LaunchScreen'
import Register from './register'
import Login from './login'
import CameraScreen from './cameraScreen'
import Contract from './contract'
import Profile from './profile'

class App extends Component {
  componentDidMount() {
  }

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
      case '/contract':
        return <Contract />
      case '/profile':
        return <Profile />
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
