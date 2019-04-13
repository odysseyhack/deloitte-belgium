//
const baseURL = 'http://localhost:8080'
const registerBaseURL = 'https://kvk-hackathon.azurewebsites.net'
const registerAPIKey = 'Token Ax&=^tx&5EM4$5jP'

//
//

const login = (obj) => {
    const url = `${baseURL}/login`
    const { name, password } = obj
    return fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify({
            firstName: name,
            password
        })
    })
}

const sendPayment = (obj) => {
    const url = `${baseURL}/pay`
    const { amount, address } = obj
    return fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify({
            amount,
            address
        })
    })
}


//
// REGISTER
//

const getRegisterDataFor = (obj) => {
    const { city } = obj
    if (city) {
        return getRegisterDataForCity(city)
    }
}

const getRegisterDataForCity = (city) => {
    const url = `${registerBaseURL}/api/Handelsregister/by-city/${city}`
    return fetch(url, {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json; charset=utf-8',
            Authorization: registerAPIKey
        },
    })
}

export default { login, getRegisterDataFor, getRegisterDataForCity }
