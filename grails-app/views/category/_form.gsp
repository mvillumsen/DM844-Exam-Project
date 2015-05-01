<%@ page import="dk.dm844.webshop.Category" %>

<div class="fieldcontain ${hasErrors(bean: categoryInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="category.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${categoryInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: categoryInstance, field: 'description', 'error')} ">
    <label for="description">
        <g:message code="category.description.label" default="Description"/>

    </label>
    <g:textField name="description" value="${categoryInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: categoryInstance, field: 'products', 'error')} ">
    <label for="products">
        <g:message code="category.products.label" default="Products"/>

    </label>

    <ul class="one-to-many">
        <g:each in="${categoryInstance?.products ?}" var="p">
            <li><g:link controller="product" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
        </g:each>
        <li>
            <g:link controller="product" action="create"
                    params="['category.id': categoryInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'product.label', default: 'Product')])}</g:link>
        </li>
    </ul>

</div>

