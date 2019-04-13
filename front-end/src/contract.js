import React, { Component, Fragment } from 'react'
import './contract.css'
import { localized } from './l10n'

class Contract extends Component {
  render() {
    return (
      <Fragment>
        <div className="App">
          <header className="App-header">
            <p className="launchScreen__title">
              <span className="contract__title">{localized('contract')}</span>
            </p>
          </header>
          <form className="register__form">
            <input
              type="number"
              className="field-option"
              placeholder={localized('amount')}
            />
            <input
              className="field-option"
              placeholder={localized('address')}
            />
          </form>
          <a
            className="launchScreen__button"
            href="/"
          >
            <span className="launchScreen__button--text">
              {localized('send')}
            </span>
          </a>
        </div>
      </Fragment>
    )
  }
}

export default Contract