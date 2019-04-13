import React, { Component } from 'react'
import './PushNotification.css'

class PushNotification extends Component {
  render() {
    const { content } = this.props
    return (
      <div className="pushNotification">
        <div className="pushNotification__content">
          {content}
        </div>
      </div>
    )
  }
}

export default PushNotification
