import React, { Component, Fragment } from 'react'
import './contracts.css'
import logo from './img/eth.svg'
import { localized } from './l10n'
import web from './web'

class Contracts extends Component {
  render() {
    return (
      <Fragment>
        <div className="App">
          <header className="App-header">
            <p className="launchScreen__title">
              <span className="contract__title">{localized('transactions')}</span>
            </p>
          </header>
          <img src={logo} className="contracts__image" alt="logo" />
          <a
            className="launchScreen__button"
            href="/contract"
          >
            <span className="launchScreen__button--text">
              {localized('newTransaction')}
            </span>
          </a>
          <a
            className="launchScreen__button"
            href="/contracts"
          >
            <span className="launchScreen__button--text">
              {localized('transactionHistory')}
            </span>
          </a>
        </div>
      </Fragment>
    )
  }
}

export default Contracts
