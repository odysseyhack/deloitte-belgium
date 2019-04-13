//

const getData = (key) => {
  const s = window.localStorage.getItem(key)
  return JSON.parse(s)
}

const setData = (data) => {
  const { key, value } = data
  if (!(key && value)) {
    return false
  }
  const s = JSON.stringify(value)
  window.localStorage.setItem(key, s)
  return s
}

const removeData = (key) => {
  if (!key) {
    window.localStorage.clear()
    return
  }
  window.localStorage.removeItem(key)
}

export default { getData, setData, removeData }
