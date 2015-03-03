<%@ page import="dk.dm844.webshop.OrderEntry" %>



<div class="fieldcontain ${hasErrors(bean: orderEntryInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="orderEntry.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" type="number" min="1" value="${orderEntryInstance.amount}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderEntryInstance, field: 'order', 'error')} required">
	<label for="order">
		<g:message code="orderEntry.order.label" default="Order" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="order" name="order.id" from="${dk.dm844.webshop.ProductOrder.list()}" optionKey="id" required="" value="${orderEntryInstance?.order?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderEntryInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="orderEntry.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${orderEntryInstance.price}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderEntryInstance, field: 'product', 'error')} required">
	<label for="product">
		<g:message code="orderEntry.product.label" default="Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="product" name="product.id" from="${dk.dm844.webshop.Product.list()}" optionKey="id" required="" value="${orderEntryInstance?.product?.id}" class="many-to-one"/>

</div>

