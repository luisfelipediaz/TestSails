module.exports = {


  friendlyName: 'View anexos',


  description: 'Display "Anexos" page.',


  exits: {

    success: {
      viewTemplatePath: 'pages/documentation/anexos'
    },

    redirect: {
      responseType: 'redirect',
      description: 'El usuario no está logeado'
    },

  },


  fn: async function (inputs, exits) {

    if (!this.req.me) {
      throw {redirect:'/login'};
    }
    // Respond with view.
    return exits.success();

  }


};
