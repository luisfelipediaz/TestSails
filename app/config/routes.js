/**
 * Route Mappings
 * (sails.config.routes)
 *
 * Your routes tell Sails what to do each time it receives a request.
 *
 * For more information on configuring custom routes, check out:
 * https://sailsjs.com/anatomy/config/routes-js
 */

module.exports.routes = {


  //  ╦ ╦╔═╗╔╗ ╔═╗╔═╗╔═╗╔═╗╔═╗
  //  ║║║║╣ ╠╩╗╠═╝╠═╣║ ╦║╣ ╚═╗
  //  ╚╩╝╚═╝╚═╝╩  ╩ ╩╚═╝╚═╝╚═╝
  'GET /':                   { action: 'view-homepage-or-redirect' },
  'GET /welcome':            { action: 'dashboard/view-welcome' },
  'GET /anexos/*':           { action: 'documentation/view-anexos'},
  'GET /anexos':             { action: 'documentation/view-anexos'},


  'GET /faq':                { view:   'pages/faq' },
  'GET /legal/terms':        { view:   'pages/legal/terms' },
  'GET /legal/privacy':      { view:   'pages/legal/privacy' },
  'GET /contact':            { view:   'pages/contact' },
  'GET /anexos/anexo_0':            { view: 'pages/documentation/Anexo0/anexo_0'},
  'GET /anexos/anexo_1':            { view: 'pages/documentation/Anexo1/anexo_1'},
  'GET /anexos/anexo_2':            { view: 'pages/documentation/Anexo2/anexo_2'},
  'GET /anexos/anexo_3':            { view: 'pages/documentation/Anexo3/anexo_3'},
  'GET /anexos/anexo_4':            { view: 'pages/documentation/Anexo4/anexo_4'},
  'GET /anexos/anexo_5':            { view: 'pages/documentation/Anexo5/anexo_5'},
  'GET /anexos/anexo_6':            { view: 'pages/documentation/Anexo6/anexo_6'},
  'GET /anexos/anexo_7':            { view: 'pages/documentation/Anexo7/anexo_7'},
  'GET /anexos/anexo_8':            { view: 'pages/documentation/Anexo8/anexo_8'},
  'GET /anexos/anexo_9':            { view: 'pages/documentation/Anexo9/anexo_9'},
  'GET /anexos/anexo_10':           { view: 'pages/documentation/Anexo10/anexo_10'},
  'GET /anexos/anexo_12':            { view: 'pages/documentation/Anexo12/anexo_12'},
  'GET /anexos/anexo_13':            { view: 'pages/documentation/Anexo13/anexo_13'},
  'GET /anexos/anexo_14':            { view: 'pages/documentation/Anexo14/anexo_14'},
  'GET /anexos/anexo_15':            { view: 'pages/documentation/Anexo15/anexo_15'},
  'GET /anexos/anexo_16':            { view: 'pages/documentation/Anexo16/anexo_16'},
  'GET /anexos/anexo_17':            { view: 'pages/documentation/Anexo17/anexo_17'},
  'GET /anexos/anexo_18':            { view: 'pages/documentation/Anexo18/anexo_18'},
  'GET /anexos/anexo_19':            { view: 'pages/documentation/Anexo19/anexo_19'},
  'GET /anexos/anexo_20':            { view: 'pages/documentation/Anexo20/anexo_20'},
  'GET /anexos/anexo_21':            { view: 'pages/documentation/Anexo21/anexo_21'},

  'GET /signup':             { action: 'entrance/view-signup' },
  'GET /email/confirm':      { action: 'entrance/confirm-email' },
  'GET /email/confirmed':    { view:   'pages/entrance/confirmed-email' },

  'GET /login':              { action: 'entrance/view-login' },
  'GET /password/forgot':    { action: 'entrance/view-forgot-password' },
  'GET /password/new':       { action: 'entrance/view-new-password' },

  'GET /account':            { action: 'account/view-account-overview' },
  'GET /account/password':   { action: 'account/view-edit-password' },
  'GET /account/profile':    { action: 'account/view-edit-profile' },


  //  ╔═╗╔═╗╦  ╔═╗╔╗╔╔╦╗╔═╗╔═╗╦╔╗╔╔╦╗╔═╗
  //  ╠═╣╠═╝║  ║╣ ║║║ ║║╠═╝║ ║║║║║ ║ ╚═╗
  //  ╩ ╩╩  ╩  ╚═╝╝╚╝═╩╝╩  ╚═╝╩╝╚╝ ╩ ╚═╝
  // Note that, in this app, these API endpoints may be accessed using the `Cloud.*()` methods
  // from the CloudSDK library.
  '/api/v1/account/logout':                           { action: 'account/logout' },
  'PUT   /api/v1/account/update-password':            { action: 'account/update-password' },
  'PUT   /api/v1/account/update-profile':             { action: 'account/update-profile' },
  'PUT   /api/v1/account/update-billing-card':        { action: 'account/update-billing-card' },
  'PUT   /api/v1/entrance/login':                        { action: 'entrance/login' },
  'POST  /api/v1/entrance/signup':                       { action: 'entrance/signup' },
  'POST  /api/v1/entrance/send-password-recovery-email': { action: 'entrance/send-password-recovery-email' },
  'POST  /api/v1/entrance/update-password-and-login':    { action: 'entrance/update-password-and-login' },
  'POST  /api/v1/deliver-contact-form-message':          { action: 'deliver-contact-form-message' },
  'POST  /api/v1/documentation/uploadfiles':            { action: 'documentation/uploadfiles' },


  //  ╦ ╦╔═╗╔╗ ╦ ╦╔═╗╔═╗╦╔═╔═╗
  //  ║║║║╣ ╠╩╗╠═╣║ ║║ ║╠╩╗╚═╗
  //  ╚╩╝╚═╝╚═╝╩ ╩╚═╝╚═╝╩ ╩╚═╝


  //  ╔╦╗╦╔═╗╔═╗  ╦═╗╔═╗╔╦╗╦╦═╗╔═╗╔═╗╔╦╗╔═╗
  //  ║║║║╚═╗║    ╠╦╝║╣  ║║║╠╦╝║╣ ║   ║ ╚═╗
  //  ╩ ╩╩╚═╝╚═╝  ╩╚═╚═╝═╩╝╩╩╚═╚═╝╚═╝ ╩ ╚═╝
  '/terms':                   '/legal/terms',
  '/logout':                  '/api/v1/account/logout',

};