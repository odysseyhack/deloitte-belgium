export const localized = (key, lang = 'nl') => {
  const string = localizations[lang][key]

  if (string === undefined) {
    console.error(`ERROR: localizable strings — language:${lang} — key:${key}`)
    return `ERROR: ${lang} — ${key}`
  }

  return string
}

const localizations = {
  en: {
  },
  fr: {
  },
  de: {
  },
  nl: {
    back: 'Terug',
    next: 'Volgende',
    name: 'Naam',
    password: 'Passwoord',
    signIn: 'Aanmelden',
    send: 'Verzenden',
    amount: 'Bedrag',
    address: 'Adres',
    contract: 'Contract',
    registrationNumber: 'Registratienummer',
    transaction: 'Transactie',
    transactions: 'Transacties',
    newTransaction: 'Nieuwe transactie',
    doTransaction: 'Transactie uitvoeren',
    saveTransaction: 'Transactie opslaan',
    transactionHistory: 'Transactie geschiedenis',
    profile: 'Profiel',
    permission: 'Permissie',
    requested: 'Aangevraagd',
    accept: 'Aanvaard',
    decline: 'Weiger',
    launchScreenTitle0: 'register',
    launchScreenTitle1: 'van koophandel',
    step1: 'stap 1',
    registerForCertificate: 'Registreer',
    registerAction: 'Registreer',
    legalForm: 'Rechtsvorm',
    establishment: 'Vestiging',
    creationDate: 'Datum van oprichting',
    enterBusinessInformation: 'Vul hier uw bedrijfsinformatie in',
    alreadyRegistered: 'Al geregistreerd?',
    checkPermissions: 'Permissies',
    showQRCode: 'QR-code tonen'
  },
}
