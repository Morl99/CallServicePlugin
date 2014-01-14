(function( cordova ) {

	function CallService() {}

	CallService.prototype.start = function(description) {
		return cordova.exec(
				function (args) {  } },
				function (args) {  } },
				"CallService", "start", [description]);
	};

	CallService.prototype.stop = function() {
		return cordova.exec(
				function (args) {  } },
				function (args) {  } },
				"CallService", "stop", []);
	};


	if(!window.plugins) {
		window.plugins = {};
	}

	if (!window.plugins.CallService) {
		window.plugins.CallService = new CallService();
	}

	var callService = new CallService();
	module.exports = callService;

})( window.cordova );