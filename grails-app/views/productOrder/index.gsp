<%@ page import="dk.dm844.webshop.ProductOrder" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'productOrder.label', default: 'ProductOrder')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>

<g:if test="${productOrderInstanceList?.size() > 0}">
    <g:render template="accordionList" model="${[orders: productOrderInstanceList, id: "packingAccordion"]}"/>
</g:if>
<g:else>
    <g:message code="productOrder.noOrders" />
</g:else>

<tb:row>
    <tb:pullLeft cssClasses="adminNewButton">
        <g:link class="create" action="create">
            <tb:button cssClasses="nav-pills"><g:message code="default.new.label" args="[entityName]"/></tb:button>
        </g:link>
    </tb:pullLeft>
    <tb:pullRight>
        <g:paginate total="${productInstanceCount ?: 0}"/>
    </tb:pullRight>
</tb:row><br>

</body>
</html>
