<%@ page import="com.metasieve.shoppingcart.Shoppable" %>
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
    <sc:each>
        <tr>
            <td>
                ${Shoppable.findByShoppingItem(it['item'])}
            </td>
            <td>
                ${it['qty']}
            </td>
            <td>
                <g:form controller="product" action="addToCart" id="${Shoppable.findByShoppingItem(it['item']).id}">
                    <g:submitButton name="Add 1" class="btn btn-success"/>
                </g:form>
            </td>
            <td>
                <g:form controller="product" action="removeFromCart" id="${Shoppable.findByShoppingItem(it['item']).id}">
                    <g:submitButton name="Remove 1" class="form-control btn btn-warning" />
                </g:form>
            </td>
            <td>
                <g:form controller="product" action="removeAllFromCart" id="${Shoppable.findByShoppingItem(it['item']).id}">
                    <g:submitButton name="Remove All" class="form-control btn btn-danger" />
                </g:form>
            </td>
        </tr>
    </sc:each>
</table>
<g:submitButton name="Order now! (Coming soon)" class="btn btn-primary" disabled="disabled" />

</body>
</html>

