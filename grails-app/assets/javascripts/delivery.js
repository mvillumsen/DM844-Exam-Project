/**
 * Created by martin on 26/05/15.
 */

if (typeof jQuery !== 'undefined') {
    $(function() {
        $('.radio input[type="radio"]')
            .click(function(event) {
                if (this.id === 'optionsRadios1') {
                    $('#alternativeAddress').finish().hide();
                    $('address.address').fadeIn();
                    $('input[name="address1"]').val($('.address1').text());
                    $('input[name="address2"]').val($('.address2').text());
                    $('input[name="city"]').val($('.city').text());
                    $('input[name="zipCode"]').val($('.zipCode').text());
                    $('input[name="country"]').val($('.country').text());
                } else {
                    $('address.address').finish().hide();
                    $('#alternativeAddress').fadeIn();
                }
            });
        $('#optionsRadios1').trigger('click');
    });
}