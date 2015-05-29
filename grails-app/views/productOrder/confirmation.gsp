<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="shopTemplate">
    <title><g:message code="productOrder.comfirmation.title.label"/></title>
</head>

<body>
<tb:breadcrumb>
    <li><g:link controller="home" action="index"><g:message code="default.home.label"/></g:link></li>
    <li><g:link controller="ShoppingCart"><g:message code="shoppingCart.label"/></g:link></li>
    <li><g:link controller="shoppingCart" action="checkout"><g:message code="shoppingCart.checkout.title"/></g:link></li>
    <li><g:link controller="shoppingCart" action="delivery"><g:message code="delivery.breadcrumbs.label"/></g:link></li>
    <tb:liActive><g:message code="shoppingCart.confirmation"/></tb:liActive>
</tb:breadcrumb>

<h2><g:message code="productOrder.comfirmation.title.label"/> </h2>
<tb:progressBar percentCompleted="100"/>
<tb:pLeadText><g:message code="productOrder.thankYou" /></tb:pLeadText>

<g:render template="view" model="${[order: order]}"/>
</body>
</html>