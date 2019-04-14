// screen for demo

import React, { Component } from 'react'
import logo from './img/profile.svg'
import company from './img/business.svg'
import location from './img/location.svg'
import role from './img/role.svg'
import './profileDirector.css'
import { localized } from './l10n'

class ProfileDirector extends Component {
  state = {
    name: 'Kasper',
    business: 'De Suikerfabriek',
    location: 'Groningen',
    function: 'Directeur'
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p className="launchScreen__title">
            <span className="profile">{localized('profile')}</span>
          </p>
        </header>
        <img src={logo} className="profile__image" alt="logo" />
        <div className="profile__name">
          {this.state.name}
        </div>
        <div className="profile__info">
          <div className="profile__info--item">
            <img src={company} className="profile__info--image" alt="logo" />
            {this.state.business}
          </div>
          <div className="profile__info--item">
            <img src={location} className="profile__info--image" alt="logo" />
            {this.state.location}
          </div>
          <div className="profile__info--item">
            <img src={role} className="profile__info--image" alt="logo" />
            {this.state.function}
          </div>
        </div>
        <div style={{ margin: '16px' }}>

        </div>
        <a
          className="launchScreen__button"
          href="/permission/1"
        >
          <span className="launchScreen__button--text">
            {localized('checkPermissions')}
          </span>
        </a>
        <a
          className="launchScreen__button"
          href="/contracts"
        >
          <span className="launchScreen__button--text">
            {localized('transactions')}
          </span>
        </a>
        <a
          className="launchScreen__button"
          href="/profile/1"
        >
          <span className="launchScreen__button--text">
            {localized('showQRCode')}
          </span>
        </a>
      </div>
    )
  }
}

export default ProfileDirector
