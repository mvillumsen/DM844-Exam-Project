<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 29/04/15
  Time: 00:56
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="template">
    <title><g:message code="productOrder.assigned.all.title" /></title>
</head>

<body>
    This is a list of orders assigned to you.
    <h2>Packing:</h2>
    <tb:table cssClasses="table-hover table-striped">
        <thead>
        <tr>
            <th><g:message code="productOrder.id.label"/></th>
            <th><g:message code="productOrder.status.label"/></th>
            <th><g:message code="productOrder.address.label"/></th>
            <th><g:message code="productOrder.dateCreated.label"/></th>
            <th><g:message code="productOrder.customer.label"/></th>
            <th><g:message code="productOrder.assignedEmployee.label"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${packingOrders}" status="i" var="order">
            <tr>
                <g:render template="/productOrder/productOrderRow" model="${[productOrderInstance: order]}"/>

                <td>
                    <g:link controller="productOrder" action="finishAssignment" id="${order.id}">
                        <g:message code="productOrder.finishAssignment" />
                    </g:link>
                </td>
            </tr>
        </g:each>
        </tbody>
    </tb:table>

    <h2>Delivering:</h2>
<tb:table cssClasses="table-hover table-striped">
    <thead>
    <tr>
        <th><g:message code="productOrder.id.label"/></th>
        <th><g:message code="productOrder.status.label"/></th>
        <th><g:message code="productOrder.address.label"/></th>
        <th><g:message code="productOrder.dateCreated.label"/></th>
        <th><g:message code="productOrder.customer.label"/></th>
        <th><g:message code="productOrder.assignedEmployee.label"/></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${deliveringOrders}" status="i" var="order">
        <tr>
            <g:render template="/productOrder/productOrderRow" model="${[productOrderInstance: order]}"/>

            <td>
                <g:link controller="productOrder" action="finishAssignment" id="${order.id}">
                    <g:message code="productOrder.finishAssignment" />
                </g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</tb:table>
</body>
</html>