<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="shopTemplate">
    <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}"/>
    <title><g:message code="shoppingCart.checkout.title"/></title>
</head>

<body>
<tb:breadcrumb>
    <li><g:link url="/webshop"><g:message code="default.home.label"/></g:link></li>
    <li><g:link controller="ShoppingCart"><g:message code="shoppingCart.label"/></g:link></li>
    <tb:liActive><g:message code="shoppingCart.checkout.title"/></tb:liActive>
</tb:breadcrumb>

<h2>Checkout</h2>
<tb:progressBar percentCompleted="33"/>

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
    <sc:each>
        <tr>
            <td>
                ${it['product']}
            </td>
            <td>
                x ${it['qty']}
            </td>
            <td>
                <sc:price>
                    ${it['product'].price}
                </sc:price>
            </td>
            <td>
                <sc:price>
                    ${it['product'].price * it['qty']}
                </sc:price>
            </td>
        </tr>
    </sc:each>
    </tbody>
    <tfoot>
    <tr>
        <td><g:message code="shoppingCart.grandTotal"/></td>
        <td/>
        <td/>
        <td>
            <sc:price><sc:total/></sc:price>
        </td>
    </tr>
    </tfoot>
</table>
<tb:col6 cssClasses="backButton">
    <g:link controller="ShoppingCart" name="Back" class="btn btn-primary">Back</g:link>
</tb:col6>
<tb:col6 cssClasses="forwardButton">
    <g:form action="delivery">
        <g:submitButton name="Confirm" class="btn btn-primary"/>
    </g:form>
</tb:col6>
</body>
</html>

