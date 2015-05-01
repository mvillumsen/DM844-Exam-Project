<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="shopTemplate"/>
    <title><g:message code="delivery.title.label"/></title>

</head>

<body>
<tb:breadcrumb>
    <li><g:link url="/webshop"><g:message code="default.home.label"/></g:link></li>
    <li><g:link controller="shoppingCart"><g:message code="shoppingCart.label"/></g:link></li>
    <li><g:link controller="shoppingCart" action="checkout"><g:message code="shoppingCart.checkout"/></g:link></li>
    <tb:liActive><g:message code="delivery.breadcrumbs.label"/></tb:liActive>
</tb:breadcrumb>
<tb:progressBar percentCompleted="66"/>
<h1><g:message code="delivery.title.label"/></h1>
<tb:pLeadText><g:message code="delivery.message"/></tb:pLeadText>

<g:form controller="ShoppingCart" action="confirmation" class="form-horizontal address">
    <tb:radio cssClasses="delivery">
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" class="optionRadio" checked>
            <h4>Delivery Address</h4>
        </label>
        <tb:address cssClasses="address">
            <login:printUserInfo cssClasses="deliveryLabel"/>
        </tb:address>
    </tb:radio>
    <tb:radio>
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" class="optionRadio">
            <h4>Alternative Delivery Address</h4>
        </label>
        <fieldset id="alternativeAddress">
            <login:getUserInfo>
                <tb:formGroup>
                    <tb:col2><tb:label cssClasses="deliveryLabel" for="name"><strong><g:message
                            code="delivery.name.label"/>:</strong></tb:label></tb:col2>
                    <tb:col8><tb:preFilledInputForm id="name" name="name" type="text" value="${it.name}"/></tb:col8>
                </tb:formGroup>
                <tb:formGroup>
                    <tb:col2><tb:label cssClasses="deliveryLabel" for="address1"><strong><g:message
                            code="delivery.address1.label"/>:</strong></tb:label></tb:col2>
                    <tb:col8><tb:preFilledInputForm id="address1" name="address1" type="address"
                                                    value="${it.address1}"/></tb:col8>
                </tb:formGroup>
                <tb:formGroup>
                    <tb:col2><tb:label cssClasses="deliveryLabel" for="address2"><strong><g:message
                            code="delivery.address2.label"/>:</strong></tb:label></tb:col2>
                    <tb:col8><tb:preFilledInputForm id="address2" name="address2" type="text"
                                                    value="${it.address2}"/></tb:col8>
                </tb:formGroup>
                <tb:formGroup>
                    <tb:col2><tb:label cssClasses="deliveryLabel" for="zipCode"><strong><g:message
                            code="delivery.address.postalCode"/>:</strong></tb:label></tb:col2>
                    <tb:col8><tb:preFilledInputForm id="zipCode" name="zipCode" type="text"
                                                    value="${it.zipCode}"/></tb:col8>
                </tb:formGroup>
                <tb:formGroup>
                    <tb:col2><tb:label cssClasses="deliveryLabel" for="city"><strong><g:message
                            code="delivery.address.city"/></strong>:</tb:label></tb:col2>
                    <tb:col8><tb:preFilledInputForm id="city" name="city" type="text" value="${it.city}"/></tb:col8>
                </tb:formGroup>
                <tb:formGroup>
                    <tb:col2><tb:label cssClasses="deliveryLabel" for="country"><strong><g:message
                            code="delivery.address.country"/></strong>:</tb:label></tb:col2>
                    <tb:col8>
                        <select name="country" class="form-control">
                            <option value="${it.country}" selected="selected">${it.country}</option>
                            <option value="DK"><g:message code="delivery.country.dk"/></option>
                            <option value="GB"><g:message code="delivery.country.gb"/></option>
                            <option value="US"><g:message code="delivery.country.us"/></option>
                        </select>
                    </tb:col8>
                </tb:formGroup>
            </login:getUserInfo>
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
