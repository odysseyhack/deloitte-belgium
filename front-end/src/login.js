import React, { Component } from 'react'
import './login.css'
import web from './web'

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
            <span className="login__title--text">Login</span>
          </p>
        </header>
        <form className="register__form">
          <input
            className="field-option"
            placeholder="Naam"
          />
          <input
            className="field-option"
            placeholder="Passwoord"
          />
        </form>
        <button
          className="launchScreen__button"
          onClick={this.login}
        >
          <span className="launchScreen__button--text">
            Login
        </span>
        </button>
        <a
          className="launchScreen__button"
          href="/"
        >
          <span className="launchScreen__button--text">
            Terug
        </span>
        </a>
      </div>
    )
  }
}

export default Login
