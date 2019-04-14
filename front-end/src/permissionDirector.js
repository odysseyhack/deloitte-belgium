// screen for demo

// screen for demo

import React, { Component } from 'react'
import logo from './img/permission.svg'
import './permissionDirector.css'
import { localized } from './l10n'

class PermissionDirector extends Component {
  state = {
    owner: {
      name: 'Peter',
      business: 'Deloitte',
      location: 'Brussel',
      function: 'Bedrijfsleider'
    },
    name: 'Kasper',
    company: 'Deloitte',
    role: 'Directeur',
    mainActivity: 'Evenementen',
    permissions: [
      'Dep A - all',
      'Dep B - all',
      'Dep C - all'
    ]
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p className="launchScreen__title">
            <span className="profile">{this.state.owner.name} {localized('hasConfirmedYourPermissions')}</span>
          </p>
        </header>
        <img src={logo} className="profile__image" alt="logo" />

        <div className="permissionDirector__card">
          <div>
            <span className="permission__card--title permission__card--name">
              {localized('name')}
            </span>
            :
            {' '}
            {this.state.name}
          </div>
          <div>
            <span className="permission__card--title permission__card--name">
              {localized('company')}
            </span>
            :
            {' '}
            {this.state.name}
          </div>
          <div>
            <span className="permission__card--title permission__card--name">
              {localized('role')}
            </span>
            :
            {' '}
            {this.state.name}
          </div>
          <div>
            <span className="permission__card--title permission__card--name">
              {localized('mainActivity')}
            </span>
            :
            {' '}
            {this.state.name}
          </div>
          <div>
            <span className="permission__card--title permission__card--name">
              {localized('permissions')}
            </span>
            :
            {' '}
            {this.state.name}
          </div>
        </div>

        <button
          className="launchScreen__button"
          onClick={() => window.history.go(-1)}
        >
          <span className="launchScreen__button--text">
            {localized('back')}
          </span>
        </button>
      </div>
    )
  }
}

export default PermissionDirector
