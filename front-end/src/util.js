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

export default { getCameraAccess }
