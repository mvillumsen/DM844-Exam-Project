<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="template">
    <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}" />
    <title>${categoryInstance?.name}</title>
</head>
<body>
<ol class="breadcrumb">
    <li><g:link url="/webshop"><g:message code="default.home.label"/></g:link></li>
    <tb:liActive><g:message code="shoppingCart.label"/></tb:liActive>
</ol>

<table class="table">
    <thead>
        <tr>
            <th><g:message code="cart.product" /></th>
            <th><g:message code="cart.amount" /></th>
            <th><g:message code="product.price" /></th>
            <th><g:message code="cart.total" /></th>
            <th></th>
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
            <td>
                <g:form controller="product" action="removeAllFromCart" id="${it['product'].id}">
                    <g:submitButton name="Remove" class="form-control btn btn-danger"/>
                </g:form>
            </td>
        </tr>
    </sc:each>
    </tbody>
    <tfoot>
        <tr>
            <td><g:message code="cart.grandtotal" /></td>
            <td/>
            <td/>
            <td>
                <sc:price><sc:total /></sc:price>
            </td>
            <td>
                <g:form action="checkout">
                    <g:submitButton name="Order now!" class="btn btn-primary" />
                </g:form>
            </td>
        </tr>
    </tfoot>
</table>

</body>
</html>

