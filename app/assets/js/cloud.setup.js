/**
 * cloud.setup.js
 *
 * Configuration for this Sails app's generated browser SDK ("Cloud").
 *
 * Above all, the purpose of this file is to provide endpoint definitions,
 * each of which corresponds with one particular route+action on the server.
 *
 * > This file was automatically generated.
 * > (To regenerate, run `sails run rebuild-cloud-sdk`)
 */

Cloud.setup({

  /* eslint-disable */
  methods: {
    "confirmEmail": { "verb": "GET", "url": "/email/confirm", "args": ["token"] }
    , "logout": { "verb": "GET", "url": "/api/v1/account/logout", "args": [] }
    , "updatePassword": {
      "verb": "PUT", "url": "/api/v1/account/update-password"
      , "args": ["password"]
    },
    "updateProfile": { "verb": "PUT", "url": "/api/v1/account/update-profile", "args": ["nombre", "correo"] }
    , "updateBillingCard": { "verb": "PUT", "url": "/api/v1/account/update-billing-card", "args": ["stripeToken", "billingCardLast4", "billingCardBrand", "billingCardExpMonth", "billingCardExpYear"] },
    "login": { "verb": "PUT", "url": "/api/v1/entrance/login", "args": ["correo", "password", "rememberMe"] },
    "signup": { "verb": "POST", "url": "/api/v1/entrance/signup", "args": ["correo", "password", "nombre", "nit"] },
    "uploadfiles": { "verb": "POST", "url": "/api/v1/documentation/uploadfiles", "args": ["name"] },
    "sendPasswordRecoveryEmail": { "verb": "POST", "url": "/api/v1/entrance/send-password-recovery-email", "args": ["correo"] },
    "updatePasswordAndLogin": { "verb": "POST", "url": "/api/v1/entrance/update-password-and-login", "args": ["password", "token"] },
    "deliverContactFormMessage": { "verb": "POST", "url": "/api/v1/deliver-contact-form-message", "args": ["correo", "topic", "nombre", "message"] }
  }
  /* eslint-enable */

});
