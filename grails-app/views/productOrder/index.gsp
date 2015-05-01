<%@ page import="dk.dm844.webshop.ProductOrder" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'productOrder.label', default: 'ProductOrder')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<tb:breadcrumb>
    <li><g:link url="/webshop"><g:message code="default.home.label" default="Home"/></g:link></li>
    <tb:liActive><g:message code="productOrder.listOrders" default="Orders"/></tb:liActive>
</tb:breadcrumb>

<a href="#list-productOrder" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                   default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-productOrder" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <th><g:message code="productOrder.assignedEmployee.label" default="Assigned Employee"/></th>

            <th><g:message code="productOrder.address.label" default="Address"/></th>

            <th><g:message code="productOrder.customer.label" default="Customer"/></th>

            <g:sortableColumn property="dateCreated"
                              title="${message(code: 'productOrder.dateCreated.label', default: 'Date Created')}"/>

            <g:sortableColumn property="lastUpdated"
                              title="${message(code: 'productOrder.lastUpdated.label', default: 'Last Updated')}"/>

            <g:sortableColumn property="status"
                              title="${message(code: 'productOrder.status.label', default: 'Status')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${productOrderInstanceList}" status="i" var="productOrderInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${productOrderInstance.id}">${fieldValue(bean: productOrderInstance, field: "assignedEmployee")}</g:link></td>

                <td>${fieldValue(bean: productOrderInstance, field: "address")}</td>

                <td>${fieldValue(bean: productOrderInstance, field: "customer")}</td>

                <td><g:formatDate date="${productOrderInstance.dateCreated}"/></td>

                <td><g:formatDate date="${productOrderInstance.lastUpdated}"/></td>

                <td>${fieldValue(bean: productOrderInstance, field: "status")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${productOrderInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
