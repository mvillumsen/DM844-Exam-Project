<%@ page import="dk.dm844.webshop.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="product.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${productInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="product.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${productInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="product.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="category" name="category.id" from="${dk.dm844.webshop.Category.list()}" optionKey="id" required="" value="${productInstance?.category?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'orderEntries', 'error')} ">
	<label for="orderEntries">
		<g:message code="product.orderEntries.label" default="Order Entries" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${productInstance?.orderEntries?}" var="o">
    <li><g:link controller="orderEntry" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="orderEntry" action="create" params="['product.id': productInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'orderEntry.label', default: 'OrderEntry')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="product.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${productInstance.price}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'stock', 'error')} required">
	<label for="stock">
		<g:message code="product.stock.label" default="Stock" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="stock" type="number" value="${productInstance.stock}" required=""/>

</div>

