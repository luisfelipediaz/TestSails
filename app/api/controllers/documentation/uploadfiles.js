const fs = require('fs');


module.exports = {


	friendlyName: 'Uploadfiles',


	description: 'Uploadfiles',


	inputs: {
		name: {
			required: true,
			type: 'string',
		},

		file: {
			require: true,
			type: 'string'
		}

	},


	exits: {

		success: {
			description: 'Archivo subido correctamente.'
		},

		invalid: {
			responseType: 'badRequest',
			description: 'The provided fullName, password and/or email address are invalid.',
			extendedDescription: 'If this request was sent from a graphical user interface, the request ' +
				'parameters should have been validated/coerced _before_ they were sent.'
		},

	},


	fn: async function (inputs, exits) {
		var rc = await User.findOne({
			id: this.req.session.userId,
		});
		var dir = 'assets/documents/' + rc.nit;
		if (!fs.existsSync(dir)) {
			fs.mkdirSync(dir);
		}
		fs.writeFile(dir + '/' + inputs.name, inputs.file.split(',')[1], 'base64', function (err) {
			if (err) throw err;
			console.log('done');
		});
		return exits.success();
	}
};
