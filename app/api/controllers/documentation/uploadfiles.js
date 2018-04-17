/**
 * Module dependencies
 */

// ...

const fs = require('fs');
/**
 * documentation/upload-files.js
 *
 * Upload files.
 */
module.exports = {
	friendlyName: 'Uploadfiles',
	description: 'upload files',

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
		invalid: {
			responseType: 'badRequest',
			description: 'The provided fullName, password and/or email address are invalid.',
			extendedDescription: 'If this request was sent from a graphical user interface, the request ' +
				'parameters should have been validated/coerced _before_ they were sent.'
		}
	},
	fn: async function (req, res) {
		console.log("me cago en todo");
		fs.writeFile(req.name, req.file.split(',')[1], 'base64');

		return exits.success();
	}
}
