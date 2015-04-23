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

    <%-- TODO: Activation/Deactivation with JS --%>
    <div class="radio">
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
            <h4>Delivery Address</h4>
        </label>
        <tb:address>
            <%-- TODO: Extract User address --%>
        </tb:address>
    </div>

    <div class="radio">
        <label>
            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
            <h4>Alternative Delivery Address</h4>
            <tb:address>
                <login:getUserInfo/>
            </tb:address>
        </label>
        <fieldset id="alternativeAddress" disabled>
        <tb:formHorizontal cssClasses="address">
            <tb:formGroup>
                <tb:label for="name"><g:message code="delivery.name.label"/></tb:label>
                <tb:inputForm id="name" name="name" type="text" placeholder="Full name"/>
            </tb:formGroup>
            <tb:formGroup>
                <tb:label for="address-line1"><g:message code="delivery.address1.label"/></tb:label>
                <tb:inputForm id="address-line1" name="address-line1" type="address" placeholder="Address 1"/>
            </tb:formGroup>
            <tb:formGroup>
                <tb:label for="address-line2"><g:message code="delivery.address2.label"/></tb:label>
                <tb:inputForm id="address-line2" name="address-line2" type="text" placeholder="Address 2"/>
            </tb:formGroup>
            <tb:formGroup>
                <tb:label for="city"><g:message code="delivery.address.city"/></tb:label>
                <tb:inputForm id="city" name="city" type="text" placeholder="City"/>
            </tb:formGroup>
            <tb:formGroup>
                <tb:label for="postal-code"><g:message code="delivery.address.postalCode"/></tb:label>
                <tb:inputForm id="postal-code" name="postal-code" type="number" placeholder="Postal code"/>
            </tb:formGroup>
            <tb:formGroup>
                <tb:label for="country"><g:message code="delivery.address.country"/></tb:label>
                    <select name="language" class="form-control">
                        <option value=""></option>
                        <option value="DK"><g:message code="delivery.country.dk"/></option>
                        <option value="GB"><g:message code="delivery.country.gb"/></option>
                        <option value="US"><g:message code="delivery.country.us"/></option>
                    </select>
            </tb:formGroup>
        </tb:formHorizontal>
        </fieldset>
    </div>
    <script>
        $("#optionsRadios1").click(function() {$("#alternativeAddress").prop("disabled", true);});
        $("#optionsRadios2").click(function() {$("#alternativeAddress").prop("disabled", false);});
    </script>
    </body>
</html>
