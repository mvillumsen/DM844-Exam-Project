<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 29/04/15
  Time: 15:34
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="shopTemplate">
    <title><g:message code="productOrder.comfirmation.title.label"/></title>
</head>

<body>
<tb:breadcrumb>
    <li><g:link url="/webshop"><g:message code="default.home.label"/></g:link></li>
    <li><g:link controller="ShoppingCart"><g:message code="shoppingCart.label"/></g:link></li>
    <li><g:link controller="shoppingCart" action="delivery"><g:message code="delivery.breadcrumbs.label"/></g:link></li>
    <li><g:link controller="shoppingCart" action="checkout"><g:message code="shoppingCart.checkout"/></g:link></li>
    <tb:liActive><g:message code="shoppingCart.confirmation"/></tb:liActive>
</tb:breadcrumb>
<tb:progressBar percentCompleted="100"/>
<section>
    Thank you for your order!
    <dl>
        <dt><g:message code="productOrder.id.label"/></dt>
        <dd>${order.id}</dd>

        <dt><g:message code="productOrder.address.label"/></dt>
        <dd>${order.address}</dd>

        <dt><g:message code="productOrder.entries.label"/></dt>
        <dd>
            <ul>
                <g:each in="${order.orderEntries}" var="entry">
                    <li>${entry}</li>
                </g:each>
            </ul>
        </dd>
    </dl>
</section>
</body>
</html>