/**
 * DocumentsManagerController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
  
	uploadFile : function(req,res){
		req.file('file').upload(function(err,file){
			if(err) {
				console.log("ehaki");
				console.log(err);
			}
			res.json({"status" : "file upload successfully", "file" :file});
		});
	}
};

