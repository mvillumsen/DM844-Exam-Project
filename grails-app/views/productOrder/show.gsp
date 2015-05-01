<%@ page import="dk.dm844.webshop.ProductOrder" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'productOrder.label', default: 'ProductOrder')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-productOrder" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                   default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-productOrder" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list productOrder">

        <g:if test="${productOrderInstance?.assignedEmployee}">
            <li class="fieldcontain">
                <span id="assignedEmployee-label" class="property-label"><g:message
                        code="productOrder.assignedEmployee.label" default="Assigned Employee"/></span>

                <span class="property-value" aria-labelledby="assignedEmployee-label"><g:link controller="person"
                                                                                              action="show"
                                                                                              id="${productOrderInstance?.assignedEmployee?.id}">${productOrderInstance?.assignedEmployee?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${productOrderInstance?.orderEntries}">
            <li class="fieldcontain">
                <span id="orderEntries-label" class="property-label"><g:message code="productOrder.orderEntries.label"
                                                                                default="Order Entries"/></span>

                <g:each in="${productOrderInstance.orderEntries}" var="o">
                    <span class="property-value" aria-labelledby="orderEntries-label"><g:link controller="orderEntry"
                                                                                              action="show"
                                                                                              id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

        <g:if test="${productOrderInstance?.alternativeAddress}">
            <li class="fieldcontain">
                <span id="alternativeAddress-label" class="property-label"><g:message
                        code="productOrder.alternativeAddress.label" default="Alternative Address"/></span>

                <span class="property-value" aria-labelledby="alternativeAddress-label"><g:link controller="address"
                                                                                                action="show"
                                                                                                id="${productOrderInstance?.alternativeAddress?.id}">${productOrderInstance?.alternativeAddress?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${productOrderInstance?.customer}">
            <li class="fieldcontain">
                <span id="customer-label" class="property-label"><g:message code="productOrder.customer.label"
                                                                            default="Customer"/></span>

                <span class="property-value" aria-labelledby="customer-label"><g:link controller="person" action="show"
                                                                                      id="${productOrderInstance?.customer?.id}">${productOrderInstance?.customer?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${productOrderInstance?.dateCreated}">
            <li class="fieldcontain">
                <span id="dateCreated-label" class="property-label"><g:message code="productOrder.dateCreated.label"
                                                                               default="Date Created"/></span>

                <span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate
                        date="${productOrderInstance?.dateCreated}"/></span>

            </li>
        </g:if>

        <g:if test="${productOrderInstance?.lastUpdated}">
            <li class="fieldcontain">
                <span id="lastUpdated-label" class="property-label"><g:message code="productOrder.lastUpdated.label"
                                                                               default="Last Updated"/></span>

                <span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate
                        date="${productOrderInstance?.lastUpdated}"/></span>

            </li>
        </g:if>

        <g:if test="${productOrderInstance?.status}">
            <li class="fieldcontain">
                <span id="status-label" class="property-label"><g:message code="productOrder.status.label"
                                                                          default="Status"/></span>

                <span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${productOrderInstance}"
                                                                                          field="status"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: productOrderInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${productOrderInstance}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
