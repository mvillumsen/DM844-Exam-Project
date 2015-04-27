<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="template"/>
    <title><g:message code="delivery.title.label"/></title>

</head>
<body>
    <tb:breadcrumb>
        <li><g:link url="/webshop"><g:message code="default.home.label"/></g:link></li>
        <li><g:link controller="ShoppingCart"><g:message code="shoppingCart.label"/></g:link></li>
        <tb:breadcrumbActive><g:message code="delivery.breadcrumbs.label"/></tb:breadcrumbActive>
    </tb:breadcrumb>

    <h1><g:message code="delivery.title.label"/></h1>
    <tb:pLeadText><g:message code="delivery.message"/></tb:pLeadText>

    <tb:radio cssClasses="delivery">
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
            <h4>Delivery Address</h4>
        </label>
        <tb:address cssClasses="address">
            <login:getUserInfo cssClasses="deliveryLabel"/>
        </tb:address>
    </tb:radio>
    <tb:radio>
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
            <h4>Alternative Delivery Address</h4>
        </label>
        <fieldset id="alternativeAddress" disabled>
        <tb:formHorizontal cssClasses="address">
            <tb:formGroup>
                <tb:col2><tb:label cssClasses="deliveryLabel" for="name"><strong><g:message code="delivery.name.label"/>:</strong></tb:label></tb:col2>
                <tb:col8><tb:inputForm id="name" name="name" type="text" placeholder="Full name"/></tb:col8>
            </tb:formGroup>
            <tb:formGroup>
                <tb:col2><tb:label cssClasses="deliveryLabel" for="address-line1"><strong><g:message code="delivery.address1.label"/>:</strong></tb:label></tb:col2>
                <tb:col8><tb:inputForm id="address-line1" name="address-line1" type="address" placeholder="Address 1"/></tb:col8>
            </tb:formGroup>
            <tb:formGroup>
                <tb:col2><tb:label cssClasses="deliveryLabel" for="address-line2"><strong><g:message code="delivery.address2.label"/>:</strong></tb:label></tb:col2>
                <tb:col8><tb:inputForm id="address-line2" name="address-line2" type="text" placeholder="Address 2"/></tb:col8>
            </tb:formGroup>
            <tb:formGroup>
                <tb:col2><tb:label cssClasses="deliveryLabel" for="postal-code"><strong><g:message code="delivery.address.postalCode"/>:</strong></tb:label></tb:col2>
                <tb:col8><tb:inputForm id="postal-code" name="postal-code" type="number" placeholder="Postal code"/></tb:col8>
            </tb:formGroup>
            <tb:formGroup>
                <tb:col2><tb:label cssClasses="deliveryLabel" for="city"><strong><g:message code="delivery.address.city"/></strong>:</tb:label></tb:col2>
                <tb:col8><tb:inputForm id="city" name="city" type="text" placeholder="City"/></tb:col8>
            </tb:formGroup>
            <tb:formGroup>
                <tb:col2><tb:label cssClasses="deliveryLabel" for="country"><strong><g:message code="delivery.address.country"/></strong>:</tb:label></tb:col2>
                    <tb:col8>
                        <select name="language" class="form-control">
                            <option value=""></option>
                            <option value="DK"><g:message code="delivery.country.dk"/></option>
                            <option value="GB"><g:message code="delivery.country.gb"/></option>
                            <option value="US"><g:message code="delivery.country.us"/></option>
                        </select>
                    </tb:col8>
            </tb:formGroup>
        </tb:formHorizontal>
        </fieldset>
    </tb:radio>
    <tb:col6of12 cssClasses="backButton">
        <g:submitButton name="Back" class="btn btn-primary" disabled="disabled"/>
    </tb:col6of12>
    <tb:col6of12 cssClasses="forwardButton">
        <g:submitButton name="Next" class="btn btn-primary" disabled="disabled"/>
    </tb:col6of12>
    </body>
</html>
