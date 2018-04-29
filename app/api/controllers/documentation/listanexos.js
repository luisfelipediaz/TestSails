const fs = require('fs');


module.exports = {


    friendlyName: 'ListAnexos',


    description: 'ListAnexos',



    exits: {
        success: {
        }
    },


    fn: async function (inputs, exits) {
        const anexoNombre = this.req.query['anexo']
        var rc = await User.findOne({
            id: this.req.session.userId,
        });

        var listAnexos = [];

        //fs.readdirSync(`assets/documents/${rc.nit}/${inputs.anexo}`)
        fs.readdirSync(`assets/documents/${rc.nit}/${anexoNombre}`).forEach(file => {
            listAnexos.push({
                url: `/documents/${rc.nit}/${anexoNombre}/${file}`,
                descripcion: file
            });
        });

        const objRetorno = { 
            nombre: anexoNombre,
            descripcion: 'Aca hay que buscar la descripción',
            documentos: listAnexos
        }

        return exits.success(objRetorno);
    }
};
