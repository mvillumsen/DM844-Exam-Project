<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="shopTemplate">
    <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}"/>
    <title><g:message code="shoppingcart.checkout.title"/></title>
</head>

<body>
<ol class="breadcrumb">
    <li>Home</li>
    <li>ShoppingCart</li>
</ol>

<table class="table">
    <thead>
    <tr>
        <th><g:message code="cart.product"/></th>
        <th><g:message code="cart.amount"/></th>
        <th><g:message code="product.price"/></th>
        <th><g:message code="cart.total"/></th>
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
        <td><g:message code="cart.grandtotal"/></td>
        <td/>
        <td/>
        <td>
            <sc:price><sc:total/></sc:price>
        </td>
    </tr>
    </tfoot>
</table>

<g:form action="delivery">
    <g:submitButton name="Confirm" class="btn btn-primary"/>
</g:form>

</body>
</html>

