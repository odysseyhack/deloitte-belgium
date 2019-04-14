import React, { Component } from 'react'
import './App.css'
import LaunchScreen from './LaunchScreen'
import Register from './register'
import Login from './login'
import CameraScreen from './cameraScreen'
import Contracts from './contracts'
import Contract from './contract'
import Profile from './profile'
import ProfileDirector from './profileDirector'
import Permission from './permission'
import PermissionDirector from './permissionDirector'

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
      case '/contracts':
        return <Contracts />
      case '/contract':
        return <Contract />
      case '/profile':
        return <Profile />
      case '/profile/1':
        return <ProfileDirector />
      case '/permission':
        return <Permission />
      case '/permission/1':
        return <PermissionDirector />
      default:
        // return <Error />
        return <LaunchScreen />
    }
  }

  render() {
    return this.router()
  }
}

export default App
