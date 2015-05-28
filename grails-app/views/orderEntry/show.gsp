<%@ page import="dk.dm844.webshop.OrderEntry" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'orderEntry.label', default: 'OrderEntry')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-orderEntry" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                 default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><g:link controller="home" action="index" class="home"><g:message code="default.home.label" default="Home"/></g:link></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-orderEntry" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list orderEntry">

        <g:if test="${orderEntryInstance?.amount}">
            <li class="fieldcontain">
                <span id="amount-label" class="property-label"><g:message code="orderEntry.amount.label"
                                                                          default="Amount"/></span>

                <span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${orderEntryInstance}"
                                                                                          field="amount"/></span>

            </li>
        </g:if>

        <g:if test="${orderEntryInstance?.dateCreated}">
            <li class="fieldcontain">
                <span id="dateCreated-label" class="property-label"><g:message code="orderEntry.dateCreated.label"
                                                                               default="Date Created"/></span>

                <span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate
                        date="${orderEntryInstance?.dateCreated}"/></span>

            </li>
        </g:if>

        <g:if test="${orderEntryInstance?.lastUpdated}">
            <li class="fieldcontain">
                <span id="lastUpdated-label" class="property-label"><g:message code="orderEntry.lastUpdated.label"
                                                                               default="Last Updated"/></span>

                <span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate
                        date="${orderEntryInstance?.lastUpdated}"/></span>

            </li>
        </g:if>

        <g:if test="${orderEntryInstance?.order}">
            <li class="fieldcontain">
                <span id="order-label" class="property-label"><g:message code="orderEntry.order.label"
                                                                         default="Order"/></span>

                <span class="property-value" aria-labelledby="order-label"><g:link controller="productOrder"
                                                                                   action="show"
                                                                                   id="${orderEntryInstance?.order?.id}">${orderEntryInstance?.order?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${orderEntryInstance?.price}">
            <li class="fieldcontain">
                <span id="price-label" class="property-label"><g:message code="orderEntry.price.label"
                                                                         default="Price"/></span>

                <span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${orderEntryInstance}"
                                                                                         field="price"/></span>

            </li>
        </g:if>

        <g:if test="${orderEntryInstance?.product}">
            <li class="fieldcontain">
                <span id="product-label" class="property-label"><g:message code="orderEntry.product.label"
                                                                           default="Product"/></span>

                <span class="property-value" aria-labelledby="product-label"><g:link controller="product" action="show"
                                                                                     id="${orderEntryInstance?.product?.id}">${orderEntryInstance?.product?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: orderEntryInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${orderEntryInstance}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
