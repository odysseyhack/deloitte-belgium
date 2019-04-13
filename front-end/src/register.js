import React, { Component } from 'react'
import './register.css'
import { localized } from './l10n';

class LaunchScreen extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p className="register__title">
            <span className="register__step">{localized('step1')}</span>
          </p>
          <p className="register__subtitle">
            <span className="">{localized('enterBusinessInformation')}</span>
          </p>
        </header>
        <form className="register__form">
          <input
            className="field-option"
            placeholder={localized('name')}
          />
          <input
            className="field-option"
            placeholder={localized('legalForm')}
          />
          <input
            className="field-option"
            placeholder={localized('establishment')}
          />
          <input
            className="field-option"
            placeholder={localized('creationDate')}
          />
        </form>
        <a
          className="launchScreen__button"
          href="/register"
        >
          <span className="launchScreen__button--text">
            {localized('next')}
          </span>
        </a>
        <p className="register__footer">
          {localized('alreadyRegistered')} <a href="/login" className="register__footer--login">{localized('signIn')}</a>
        </p>
      </div>
    )
  }
}

export default LaunchScreen
