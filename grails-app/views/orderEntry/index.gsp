<%@ page import="dk.dm844.webshop.OrderEntry" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'orderEntry.label', default: 'OrderEntry')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-orderEntry" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                 default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><g:link controller="home" action="index" class="home"><g:message code="default.home.label" default="Home"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-orderEntry" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="amount" title="${message(code: 'orderEntry.amount.label', default: 'Amount')}"/>

            <g:sortableColumn property="dateCreated"
                              title="${message(code: 'orderEntry.dateCreated.label', default: 'Date Created')}"/>

            <g:sortableColumn property="lastUpdated"
                              title="${message(code: 'orderEntry.lastUpdated.label', default: 'Last Updated')}"/>

            <th><g:message code="orderEntry.order.label" default="Order"/></th>

            <g:sortableColumn property="price" title="${message(code: 'orderEntry.price.label', default: 'Price')}"/>

            <th><g:message code="orderEntry.product.label" default="Product"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${orderEntryInstanceList}" status="i" var="orderEntryInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${orderEntryInstance.id}">${fieldValue(bean: orderEntryInstance, field: "amount")}</g:link></td>

                <td><g:formatDate date="${orderEntryInstance.dateCreated}"/></td>

                <td><g:formatDate date="${orderEntryInstance.lastUpdated}"/></td>

                <td>${fieldValue(bean: orderEntryInstance, field: "order")}</td>

                <td>${fieldValue(bean: orderEntryInstance, field: "price")}</td>

                <td>${fieldValue(bean: orderEntryInstance, field: "product")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${orderEntryInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
