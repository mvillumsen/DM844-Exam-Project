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
    <li><g:link controller="shoppingCart" action="checkout"><g:message code="shoppingCart.checkout.title"/></g:link></li>
    <li><g:link controller="shoppingCart" action="delivery"><g:message code="delivery.breadcrumbs.label"/></g:link></li>
    <tb:liActive><g:message code="shoppingCart.confirmation"/></tb:liActive>
</tb:breadcrumb>

<h2>Order Confirmation</h2>
<tb:progressBar percentCompleted="100"/>
<tb:pLeadText>Thank you for your order!</tb:pLeadText>
<tb:label><h4>Delivery Address</h4></tb:label>
<tb:address cssClasses="address">
    <tb:label><g:message code="delivery.name.label"/>:</tb:label> ${order.customer.name}<br>
    <tb:label><g:message code="delivery.address1.label"/>:</tb:label> ${order.address.address1}<br>
    <tb:label><g:message code="delivery.address2.label"/>:</tb:label> ${order.address.address2}<br>
    <tb:label><g:message code="delivery.address.postalCode"/>:</tb:label> ${order.address.zipCode}<br>
    <tb:label><g:message code="delivery.address.city"/>:</tb:label>${order.address.city}<br>
    <tb:label><g:message code="delivery.address.country"/>:</tb:label>${order.address.country}<br>
</tb:address>
<table class="table">
    <thead>
    <tr>
        <th><g:message code="shoppingCart.product"/></th>
        <th><g:message code="shoppingCart.amount"/></th>
        <th><g:message code="product.price"/></th>
        <th><g:message code="shoppingCart.total"/></th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${order.orderEntries}" var="entry">
        <tr>
            <td>
                ${entry.product}
            </td>
            <td>
                x ${entry.amount}
            </td>
            <td>
                <sc:price>
                    ${entry.product.price}
                </sc:price>
            </td>
            <td>
                <sc:price>
                    ${entry.product.price * entry.amount}
                </sc:price>
            </td>
        </tr>
    </g:each>
    </tbody>
    <tfoot>
    <tr>
        <td><g:message code="shoppingCart.total"/></td>
        <td/>
        <td/>
        <td>
            <sc:price><po:calcTotalPrice order="${order}"/></sc:price>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>