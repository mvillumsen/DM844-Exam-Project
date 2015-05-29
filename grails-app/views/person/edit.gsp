<%@ page import="dk.dm844.webshop.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<tb:row>
    <g:form url="[resource: personInstance, action: 'update']" method="PUT" class="form-horizontal address">
        <g:hiddenField name="version" value="${personInstance?.version}"/>
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:link action="index">
                <tb:button cssClasses="nav-pills"><g:message code="default.back.label"/></tb:button>
            </g:link>
            <g:actionSubmit class="btn btn-primary" action="update"
                            value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</tb:row>
</body>
</html>
