<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 29/04/15
  Time: 00:56
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <title><g:message code="employee.assignments.title"/></title>
</head>

<body>
<g:message code="employee.assignments.description" />
<sec:ifAnyGranted roles="${dk.dm844.webshop.SecurityRole.Employee.PACKER}">
    <h2><g:message code="employee.assignments.packing.header"/>:</h2>
    <g:if test="${packingOrders.size() > 0}">
        <g:render template="assignedAccordionList"
                  model="${[orders: packingOrders, id: "packingAccordion"]}"/>
    </g:if>
    <g:else>
        <g:message code="employee.assignments.description.noPackagingOrders"
    </g:else>
</sec:ifAnyGranted>

<sec:ifAnyGranted roles="${dk.dm844.webshop.SecurityRole.Employee.DRIVER}">
    <h2><g:message code="employee.assignments.delevery.header"/>:</h2>
    <g:if test="${deliveringOrders.size() > 0}">
        <g:render template="assignedAccordionList"
                  model="${[orders: deliveringOrders, id: "deliveringAccordion"]}"/>
    </g:if>
    <g:else>
        <g:message code="employee.assignments.description.noDeliveringOrders"
    </g:else>
</sec:ifAnyGranted>
</body>
</html>