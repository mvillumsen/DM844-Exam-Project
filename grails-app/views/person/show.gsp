<%@ page import="dk.dm844.webshop.SecurityRole" %>
<%@ page import="dk.dm844.webshop.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}"/>
    <title>${personInstance?.name}</title>
</head>

<body>

<g:render template="view" model="${[person: personInstance]}"/>
<sec:ifAllGranted roles="${SecurityRole.EMPLOYEE}">
    <h2><g:message code="person.assignedOrders.label"/></h2>
    <g:if test="${personInstance.assignedOrders}">
        <g:render template="/productOrder/accordionList" model="${[orders: personInstance?.assignedOrders]}"/>
    </g:if>
    <g:else>
        <tb:pLeadText><g:message code="person.noOrders.label"/></tb:pLeadText>
    </g:else>
</sec:ifAllGranted>
<tb:row>
    <tb:pullLeft cssClasses="adminNewButton">
        <g:link action="index">
            <tb:button cssClasses="nav-pills"><g:message code="default.back.label"/></tb:button>
        </g:link>
        <g:link action="edit" resource="${personInstance}">
            <tb:button cssClasses="nav-pills"><g:message code="default.button.edit.label" default="Edit"/></tb:button>
        </g:link>
    </tb:pullLeft>
</tb:row>

</body>
</html>
