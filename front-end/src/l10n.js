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
    launchScreenTitle0: 'register',
    launchScreenTitle1: 'van koophandel',
    step1: 'stap 1',
    registerForCertificate: 'Registreer voor certificaat',
    legalForm: 'Rechtsvorm',
    establishment: 'Vestiging',
    creationDate: 'Datum van oprichting',
    enterBusinessInformation: 'Vul hier uw bedrijfsinformatie in',
    alreadyRegistered: 'Al geregistreerd?',
  },
}
