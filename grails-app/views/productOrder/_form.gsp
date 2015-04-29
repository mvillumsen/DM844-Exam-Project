<%@ page import="dk.dm844.webshop.ProductOrder" %>



<div class="fieldcontain ${hasErrors(bean: productOrderInstance, field: 'assignedEmployee', 'error')} ">
	<label for="assignedEmployee">
		<g:message code="productOrder.assignedEmployee.label" default="Assigned Employee" />
		
	</label>
	<g:select id="assignedEmployee" name="assignedEmployee.id" from="${dk.dm844.webshop.Person.list()}" optionKey="id" value="${productOrderInstance?.assignedEmployee?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productOrderInstance, field: 'orderEntries', 'error')} ">
	<label for="orderEntries">
		<g:message code="productOrder.orderEntries.label" default="Order Entries" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${productOrderInstance?.orderEntries?}" var="o">
    <li><g:link controller="orderEntry" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="orderEntry" action="create" params="['productOrder.id': productOrderInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'orderEntry.label', default: 'OrderEntry')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: productOrderInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="productOrder.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="address" name="address.id" from="${dk.dm844.webshop.Address.list()}" optionKey="id" required="" value="${productOrderInstance?.alternativeAddress?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productOrderInstance, field: 'customer', 'error')} required">
	<label for="customer">
		<g:message code="productOrder.customer.label" default="Customer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="customer" name="customer.id" from="${dk.dm844.webshop.Person.list()}" optionKey="id" required="" value="${productOrderInstance?.customer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productOrderInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="productOrder.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="status" from="${dk.dm844.webshop.ProductOrder$Status?.values()}" keys="${dk.dm844.webshop.ProductOrder$Status.values()*.name()}" required="" value="${productOrderInstance?.status?.name()}" />

</div>

