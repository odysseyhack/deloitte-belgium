import React, { Component } from 'react'
import './App.css'
import LaunchScreen from './LaunchScreen'
import Register from './register'
import Login from './login'

class App extends Component {
  router() {
    switch (document.location.pathname) {
      case '/register':
        return <Register />
      case '/login':
        return <Login />
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
