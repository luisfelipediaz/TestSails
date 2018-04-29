parasails.registerPage('signup', {
  //  ╦╔╗╔╦╔╦╗╦╔═╗╦    ╔═╗╔╦╗╔═╗╔╦╗╔═╗
  //  ║║║║║ ║ ║╠═╣║    ╚═╗ ║ ╠═╣ ║ ║╣
  //  ╩╝╚╝╩ ╩ ╩╩ ╩╩═╝  ╚═╝ ╩ ╩ ╩ ╩ ╚═╝
  data: {
    // Form data
    formData: { /* … */ },

    // For tracking client-side validation errors in our form.
    // > Has property set to `true` for each invalid property in `formData`.
    formErrors: { /* … */ },

    // Syncing / loading state
    syncing: false,

    // Server error state
    cloudError: '',

    // Success state when form has been submitted
    cloudSuccess: false,
  },

  //  ╦  ╦╔═╗╔═╗╔═╗╦ ╦╔═╗╦  ╔═╗
  //  ║  ║╠╣ ║╣ ║  ╚╦╝║  ║  ║╣
  //  ╩═╝╩╚  ╚═╝╚═╝ ╩ ╚═╝╩═╝╚═╝
  beforeMount: function () {
    // Attach any initial data from the server.
    _.extend(this, SAILS_LOCALS);
  },
  mounted: async function () {
    //…
  },

  //  ╦╔╗╔╔╦╗╔═╗╦═╗╔═╗╔═╗╔╦╗╦╔═╗╔╗╔╔═╗
  //  ║║║║ ║ ║╣ ╠╦╝╠═╣║   ║ ║║ ║║║║╚═╗
  //  ╩╝╚╝ ╩ ╚═╝╩╚═╩ ╩╚═╝ ╩ ╩╚═╝╝╚╝╚═╝
  methods: {

    submittedForm: async function () {
      if (this.isEmailVerificationRequired) {
        // If email confirmation is enabled, show the success message.
        this.cloudSuccess = true;
      }
      else {
        // Otherwise, redirect to the logged-in dashboard.
        // > (Note that we re-enable the syncing state here.  This is on purpose--
        // > to make sure the spinner stays there until the page navigation finishes.)
        this.syncing = true;
        window.location = '/';
      }
    },

    handleParsingForm: function () {
      // Clear out any pre-existing error messages.
      this.formErrors = {};

      var argins = this.formData;

      // Validate full name:
      if (!argins.nombre) {
        this.formErrors.nombre = true;
      }

      // Validate email:
      if (!argins.correo || !parasails.util.isValidEmailAddress(argins.correo)) {
        this.formErrors.correo = true;
      }

      // Validate password:
      if (!argins.password) {
        this.formErrors.password = true;
      }

      // Validate password confirmation:
      if (argins.password && argins.password !== argins.confirmPassword) {
        this.formErrors.confirmPassword = true;
      }

      // Validate ToS agreement:
      if (!argins.agreed) {
        this.formErrors.agreed = true;
      }

      // If there were any issues, they've already now been communicated to the user,
      // so simply return undefined.  (This signifies that the submission should be
      // cancelled.)
      if (Object.keys(this.formErrors).length > 0) {
        return;
      }

      return argins;
    },

  }
});


parasails.registerPage('uploadfiles', {
  data: {
    formData: {},
    formErrors: {},
    syncing: false,
    cloudError: '',
    cloudSuccess: false
  },
  beforeMount: function () {
    const anexoNombre = decodeURIComponent(window.location.search.replace(new RegExp("^(?:.*[&\\?]" + encodeURIComponent('anexo').replace(/[\.\+\*]/g, "\\$&") + "(?:\\=([^&]*))?)?.*$", "i"), "$1"));
    this.formData.anexo = anexoNombre;

    var peticion = new XMLHttpRequest();
    peticion.responseType = 'json';
    const _this = this;
    peticion.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        _this.formData.nombreAnexo = peticion.response.nombre;
        _this.formData.descripcionAnexo = peticion.response.descripcion;
        _this.$set(_this.formData, 'documents', peticion.response.documentos);
        console.log(peticion.response);
      }
    };
    peticion.open("GET", `/api/v1/documentation/listanexos?anexo=${anexoNombre}`, true);
    peticion.send();
  },
  mounted: async function () {
  },
  methods: {
    previewFiles() {
      this.formData.name = this.$refs.myFiles.files[0].name;
      this.getBase64(this.$refs.myFiles.files[0]);
    },
    submittedForm: async function () {
      alert('Se guardó el archivo correctamente');
      window.location.reload();
    },
    handleParsingForm: function () {
      this.formErrors = {};
      var argins = this.formData;
      return argins;
    },
    getBase64: function (file) {
      var reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.formData.file = reader.result;
      };
      reader.onerror = function (error) {
        console.log('Error: ', error);
      };
    }
  }
});
