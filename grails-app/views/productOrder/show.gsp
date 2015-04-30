<%@ page import="dk.dm844.webshop.OrderEntry" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="template">
    <g:set var="entityName" value="${message(code: 'productOrder.label', default: 'Product order')}" />
    <title><g:message code="productOrder.orderNumber" />  ${productOrderInstance?.id}</title>
</head>
<body>
<tb:breadcrumb>
    <li><g:link url="/webshop"><g:message code="default.home.label" default="Home" /></g:link></li>
    <li><g:link url="/webshop/productOrder"><g:message code="productOrder.listOrders" default="Orders" /></g:link></li>
    <tb:liActive><g:message code="productOrder.orderNumber" /> ${productOrderInstance.id}</tb:liActive>
</tb:breadcrumb>

<%-- TODO: Test this --%>

<div id="list-orderEntry" class="content scaffold-list" role="main">
    <h1><g:message code="productOrder.orderNumber" default="Order no." /> ${productOrderInstance.id}</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <th><g:message code="orderEntry.product.label" default="Product" /></th>

            <th><g:message code="orderEntry.amount.label" default="Amount" /></th>

        </tr>
        </thead>
        <tbody>
            <ord:listOrderEntries order="${productOrderInstance}">
                <tr>

                    <td>${it.product.name}</td>

                    <td>${it.amount}</td>

                </tr>
            </ord:listOrderEntries>
        </tbody>
    </table>
</div>





</body>
</html>
