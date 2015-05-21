<%@ page import="dk.dm844.webshop.Category" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<g:hasErrors bean="${categoryInstance}">
    <ul class="errors" role="alert">
        <g:eachError bean="${categoryInstance}" var="error">
            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                    error="${error}"/></li>
        </g:eachError>
    </ul>
</g:hasErrors>
<g:form url="[resource: categoryInstance, action: 'update']" method="PUT">
    <g:hiddenField name="version" value="${categoryInstance?.version}"/>
    <fieldset class="form">
        <g:render template="form"/>
    </fieldset>
    <fieldset class="buttons">
        <g:actionSubmit class="save" action="update"
                        value="${message(code: 'default.button.update.label', default: 'Update')}"/>
    </fieldset>
</g:form>

</body>
</html>
