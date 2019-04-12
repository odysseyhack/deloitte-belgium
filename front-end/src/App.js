import React, { Component } from 'react'
import logo from './logo.svg'
import './App.css'
import LaunchScreen from './LaunchScreen'
import Register from './register'

class App extends Component {
  router() {
    switch (document.location.pathname) {
      case '/register':
        return <Register />
      case '/login':
        break
      // return <Login />
      case '/':
        return <LaunchScreen />
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
