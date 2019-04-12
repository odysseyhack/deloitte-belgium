import React, { Component } from 'react'
import './Register.css'

class LaunchScreen extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p className="launchScreen__title">
            <span class="register">register</span><br /><span className="van-koophandel">van koophandel</span>
          </p>
        </header>
        <img src={logo} className="App-logo" alt="logo" />
        <a
          className="launchScreen__button"
          href="/register"
          target="_blank"
          rel="noopener noreferrer"
        >
          <span className="launchScreen__button--text">
            Registreer voor certificaat
        </span>
        </a>
        <a
          className="launchScreen__button"
          href="/login"
          target="_blank"
          rel="noopener noreferrer"
        >
          <span className="launchScreen__button--text">
            Login
        </span>
        </a>
      </div>
    )
  }
}

export default LaunchScreen
