import React, { Component } from 'react'
import logo from './logo.svg'
import './LaunchScreen.css'
import { localized } from './l10n'

class LaunchScreen extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p className="launchScreen__title">
            <span className="register">{localized('launchScreenTitle0')}</span><br /><span className="van-koophandel">{localized('launchScreenTitle1')}</span>
          </p>
        </header>
        <img src={logo} className="App-logo" alt="logo" />
        <a
          className="launchScreen__button"
          href="/register"
        >
          <span className="launchScreen__button--text">
            {localized('registerForCertificate')}
          </span>
        </a>
        <a
          className="launchScreen__button"
          href="/login"
        >
          <span className="launchScreen__button--text">
            {localized('signIn')}
          </span>
        </a>
      </div>
    )
  }
}

export default LaunchScreen
