import React, { Component, Fragment } from 'react'
import './contract.css'
import logo from './img/eth.svg'
import { localized } from './l10n'
import web from './web'

class Contract extends Component {
  send() {
    const inputs = document.querySelectorAll('.field-option')
    const amount = inputs[0].value
    const address = inputs[1].value

    web.sendPayment({ amount, address })
      .then(response => {
        console.log(response)
      })
      .catch(error => {
        console.log(error)
      })
  }

  render() {
    return (
      <Fragment>
        <div className="App">
          <header className="App-header">
            <p className="launchScreen__title">
              <span className="contract__title">{localized('newTransaction')}</span>
            </p>
          </header>
          <img src={logo} className="profile__image" alt="logo" />
          <form className="contract__form">
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
            href="/contract"
          >
            <span className="launchScreen__button--text">
              {localized('doTransaction')}
            </span>
          </a>
          <a
            className="launchScreen__button"
            href="/contract"
          >
            <span className="launchScreen__button--text">
              {localized('saveTransaction')}
            </span>
          </a>
        </div>
      </Fragment>
    )
  }
}

export default Contract
