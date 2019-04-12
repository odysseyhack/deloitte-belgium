export function register() {
  if ('serviceWorker' in navigator) {
    const publicUrl = new URL(process.env.PUBLIC_URL, window.location.href)
    if (publicUrl.origin !== window.location.origin) {
      return
    }

    const swUrl = `${process.env.PUBLIC_URL}/sw.js`
    navigator.serviceWorker
      .register(swUrl)
      .then(registration => {
        console.log('sw reg OK')
      })
      .catch(error => {
        console.log('sw reg error')
      })
  }
}

export function unregister() {
  if ('serviceWorker' in navigator) {
    navigator.serviceWorker.ready.then(registration => {
      registration.unregister()
    })
  }
}
