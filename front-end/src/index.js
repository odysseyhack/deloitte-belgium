import React from 'react'
import ReactDOM from 'react-dom'
import './index.css'
import App from './App'
import * as sw from './sw'

ReactDOM.render(<App />, document.getElementById('root'))
sw.unregister()
