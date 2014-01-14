function CallService() {
}

CallService.prototype.start = function(description) {
	return cordova.exec(function(args) {
	}, function(args) {
	}, "CallService", "start", [ description ]);
};

CallService.prototype.stop = function() {
	return cordova.exec(function(args) {
	}, function(args) {
	}, "CallService", "stop", []);
};

window.CallService = new CallService();

var callService = new CallService();
module.exports = callService;
