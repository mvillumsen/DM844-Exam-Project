// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self
//= require bootstrap

console.log("My javascript goes here");

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

// Enable/disable fields within radios in shoppingCart/delivery.gsp
$("#optionsRadios1").click(function() {$("#alternativeAddress").prop("disabled", true);});
$("#optionsRadios2").click(function() {$("#alternativeAddress").prop("disabled", false);});
