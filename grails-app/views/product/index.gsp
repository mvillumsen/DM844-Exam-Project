<%@ page import="dk.dm844.webshop.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<tb:pLeadText>List of all products</tb:pLeadText>
<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<tb:tableStriped>
    <thead>
    <tr>

        <g:sortableColumn property="name" title="${message(code: 'product.name.label', default: 'Name')}"/>

        <g:sortableColumn property="description"
                          title="${message(code: 'product.description.label', default: 'Description')}"/>

        <g:sortableColumn property="category"
                          title="${message(code: 'product.category.label', default: 'Category')}"/>

        <th><g:message code="product.stock.label"/></th>

        <th><g:message code="product.price.label"/></th>


    </tr>
    </thead>
    <tbody>
    <g:each in="${productInstanceList}" status="i" var="productInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="edit"
                        id="${productInstance.id}">${fieldValue(bean: productInstance, field: "name")}</g:link></td>

            <td>${fieldValue(bean: productInstance, field: "description")}</td>

            <td>${fieldValue(bean: productInstance, field: "category")}</td>

            <td>${fieldValue(bean: productInstance, field: "stock")}</td>

            <td>${fieldValue(bean: productInstance, field: "price")}</td>

        </tr>
    </g:each>
    </tbody>
</tb:tableStriped>
<tb:row>
    <tb:pullLeft cssClasses="adminNewButton">
        <g:link class="create" action="create">
            <tb:button cssClasses="nav-pills"><g:message code="default.new.label" args="[entityName]"/></tb:button>
        </g:link>
    </tb:pullLeft>
    <tb:pullRight>
        <g:paginate total="${productInstanceCount ?: 0}"/>
    </tb:pullRight>
</tb:row>

</body>
</html>
