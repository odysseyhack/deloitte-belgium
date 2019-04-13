import React, { Component } from 'react'
import './login.css'
import web from './web'
import { localized } from './l10n';

class Login extends Component {
  login() {
    const inputs = document.querySelectorAll('.field-option')
    const name = inputs[0].value
    const password = inputs[1].value

    web.login({ name, password })
      .then(response => {
        console.log(response)
      })
      .catch(error => {
        console.log(error)
      })
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p className="login__title">
            <span className="login__title--text">{localized('signIn')}</span>
          </p>
        </header>
        <form className="register__form">
          <input
            className="field-option"
            placeholder={localized('name')}
          />
          <input
            className="field-option"
            placeholder={localized('password')}
          />
        </form>
        <button
          className="launchScreen__button"
          onClick={this.login}
        >
          <span className="launchScreen__button--text">
            {localized('signIn')}
          </span>
        </button>
        <a
          className="launchScreen__button"
          href="/"
        >
          <span className="launchScreen__button--text">
            {localized('back')}
          </span>
        </a>
      </div>
    )
  }
}

export default Login
