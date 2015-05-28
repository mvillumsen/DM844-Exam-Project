<%@ page import="dk.dm844.webshop.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>

<g:hasErrors bean="${productInstance}">
    <ul class="errors" role="alert">
        <g:eachError bean="${productInstance}" var="error">
            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                    error="${error}"/></li>
        </g:eachError>
    </ul>
</g:hasErrors>
<tb:row>
    <g:form url="[resource: productInstance, action: 'update']" method="PUT" class="form-horizontal address">
        <g:hiddenField name="version" value="${productInstance?.version}"/>
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:actionSubmit action="update" class="btn btn-primary"
                            value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</tb:row>
</body>
</html>
