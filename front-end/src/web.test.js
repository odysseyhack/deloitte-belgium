import web from './web'

it('gets register data', () => {
  console.log('…')
  web.getRegisterDataForCity('Delft')
    .then(result => {
      console.log(result)
    })
    .catch(error => {
      console.log(error)
    })
})
