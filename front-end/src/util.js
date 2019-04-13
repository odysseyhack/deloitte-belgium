//
const getCameraAccess = () => {
  const supported = 'mediaDevices' in navigator
  if (supported) {
    const constraints = { video: true }
    navigator.mediaDevices.getUserMedia(constraints)
      .then((stream) => {
        const player = document.querySelector('video')
        if (player) {
          player.srcObject = stream
        }
      })
  } else {
    console.log('`mediaDevices` is not supported')
  }
}

const dataToBlob = (data) => {
  let bytes
  if (data.split(',')[0].indexOf('base64') >= 0) {
    bytes = atob(data.split(',')[1])
  } else {
    bytes = unescape(data.split(',')[1])
  }

  const mimeString = data.split(',')[0].split(':')[1].split(';')[0]

  const array = new Uint8Array(bytes.length)
  for (let i = 0; i < bytes.length; i++) {
    array[i] = bytes.charCodeAt(i)
  }

  return new Blob([array], { type: mimeString })
}

export default { getCameraAccess, dataToBlob }
