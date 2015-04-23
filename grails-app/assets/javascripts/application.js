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

		$('.buyButton button').click(function(event) {
			var form = $(this).closest('form');
			var amountField = $(form).find("input[name='amount']");
			$.post(
				$(form).attr('action'),
				{ amount: $(amountField).val() } )
			.done(function (result) {
					$('#cart-count').html(result['count']);
					var msg =
						'<strong>' + $(amountField).val() + '</strong> "' +
						$(form).find('h5').html() + '" has been added to your cart.';
					displayMessage('success', msg);
					$(amountField).val(1);
			});
			event.preventDefault();
		});
	})(jQuery);

	function displayMessage(alertType, msg) {
		$('#feedback-area').queue( function() {
			$(this).html(
			'<div class="alert alert-' + alertType + '">' +
			'<a href="#" class="close" data-dismiss="alert">&times;</a>' +
				msg +
			'</div>'
			);
			$.dequeue(this)
		})
		.fadeIn()
		.delay(2000)
		.fadeOut();
	}
}
