<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="shopTemplate"/>
    <title><g:message code="delivery.title.label"/></title>

</head>
<body>
    <tb:breadcrumb>
        <li><g:link url="/webshop"><g:message code="default.home.label"/></g:link></li>
        <li><g:link controller="ShoppingCart"><g:message code="shoppingCart.label"/></g:link></li>
        <tb:liActive><g:message code="delivery.breadcrumbs.label"/></tb:liActive>
    </tb:breadcrumb>

    <h1><g:message code="delivery.title.label"/></h1>
    <tb:pLeadText><g:message code="delivery.message"/></tb:pLeadText>

    <g:form controller="ShoppingCart" action="doCheckout" class="form-horizontal address">
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
        <tb:formGroup>
            <tb:col2><tb:label cssClasses="deliveryLabel" for="name"><strong><g:message code="delivery.name.label"/>:</strong></tb:label></tb:col2>
            <tb:col8><tb:inputForm id="name" name="name" type="text" placeholder="Full name"/></tb:col8>
        </tb:formGroup>
        <tb:formGroup>
            <tb:col2><tb:label cssClasses="deliveryLabel" for="address1"><strong><g:message code="delivery.address1.label"/>:</strong></tb:label></tb:col2>
            <tb:col8><tb:inputForm id="address1" name="address1" type="address" placeholder="Address 1"/></tb:col8>
        </tb:formGroup>
        <tb:formGroup>
            <tb:col2><tb:label cssClasses="deliveryLabel" for="address2"><strong><g:message code="delivery.address2.label"/>:</strong></tb:label></tb:col2>
            <tb:col8><tb:inputForm id="address2" name="address2" type="text" placeholder="Address 2"/></tb:col8>
        </tb:formGroup>
        <tb:formGroup>
            <tb:col2><tb:label cssClasses="deliveryLabel" for="zipCode"><strong><g:message code="delivery.address.postalCode"/>:</strong></tb:label></tb:col2>
            <tb:col8><tb:inputForm id="zipCode" name="zipCode" type="text" placeholder="Postal code"/></tb:col8>
        </tb:formGroup>
        <tb:formGroup>
            <tb:col2><tb:label cssClasses="deliveryLabel" for="city"><strong><g:message code="delivery.address.city"/></strong>:</tb:label></tb:col2>
            <tb:col8><tb:inputForm id="city" name="city" type="text" placeholder="City"/></tb:col8>
        </tb:formGroup>
        <tb:formGroup>
            <tb:col2><tb:label cssClasses="deliveryLabel" for="country"><strong><g:message code="delivery.address.country"/></strong>:</tb:label></tb:col2>
                <tb:col8>
                    <select name="country" class="form-control">
                        <option value=""></option>
                        <option value="DK"><g:message code="delivery.country.dk"/></option>
                        <option value="GB"><g:message code="delivery.country.gb"/></option>
                        <option value="US"><g:message code="delivery.country.us"/></option>
                    </select>
                </tb:col8>
        </tb:formGroup>
        </fieldset>
    </tb:radio>
    <tb:col6 cssClasses="backButton">
        <g:link controller="ShoppingCart" name="Back" class="btn btn-primary">Back</g:link>
    </tb:col6>
    <tb:col6 cssClasses="forwardButton">
        <g:submitButton controller="ShoppingCart" action="checkout" name="Next" class="btn btn-primary"/>
    </tb:col6>
        </g:form>
    </body>
</html>
