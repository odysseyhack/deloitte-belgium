import React, { Component } from 'react'
import './permission.css'
import logo from './permission.svg'
import { localized } from './l10n'

class Permission extends Component {
  state = {
    name: 'Anna Nassen',
    permission: 'Store Manager',
    date: '10/04/2019',
    people: [
      {
        name: 'Tom Maeten',
        role: 'Director'
      },
      {
        name: 'Sid Roenen',
        role: 'Sales Manager'
      }
    ]
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p className="launchScreen__title">
            <span className="profile">{localized('profile')}</span>
          </p>
        </header>
        <img src={logo} className="permission__image" alt="logo" />
        <div className="permission__card">
          <div className="permission__card--title">
            {this.state.name}
          </div>
          <div>
            <span className="permission__card--title permission__card--name">
              {localized('permission')}
            </span>
            :
            {' '}
            {this.state.permission}
          </div>
          <div>
            <span className="permission__card--title">
              {localized('requested')}
            </span>
            :
            {' '}
            {this.state.date}
          </div>
          <div className="permission__action-buttons">
            <button className="permission__action-1">
              {localized('accept')}
            </button>
            <button className="permission__action-0">
              {localized('decline')}
            </button>
          </div>
        </div>
        {this.state.people.map(arg => (
          <a
            className="permission__button"
            href="/permission"
          >
            <div className="permission__button--name">
              {arg.name}
            </div>
            <div className="permission__button--text">
              {arg.role}
            </div>
          </a>
        ))}
      </div>
    )
  }
}

export default Permission
