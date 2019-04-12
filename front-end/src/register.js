import React, { Component } from 'react'
import './register.css'

class LaunchScreen extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p className="register__title">
            <span className="register__step">stap 1</span>
          </p>
          <p className="register__subtitle">
            <span className="">vul hier uw bedrijfsinformatie in</span>
          </p>
        </header>
        <form className="register__form">
          <input
            className="field-option"
            placeholder="Naam"
          />
          <input
            className="field-option"
            placeholder="Rechtsvorm"
          />
          <input
            className="field-option"
            placeholder="Vestiging"
          />
          <input
            className="field-option"
            placeholder="Datum van oprichting"
          />
        </form>
        <a
          className="launchScreen__button"
          href="/register"
          target="_blank"
          rel="noopener noreferrer"
        >
          <span className="launchScreen__button--text">
            volgende
        </span>
        </a>
        <p className="register__footer">
          al geregistreerd? <a href="/login" className="register__footer--login">login</a>
        </p>
      </div>
    )
  }
}

export default LaunchScreen
