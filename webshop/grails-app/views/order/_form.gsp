<%@ page import="dk.dm844.webshop.Order" %>



<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'employee', 'error')} ">
	<label for="employee">
		<g:message code="order.employee.label" default="Employee" />
		
	</label>
	<g:select id="employee" name="employee.id" from="${dk.dm844.webshop.Employee.list()}" optionKey="id" value="${orderInstance?.employee?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'customer', 'error')} required">
	<label for="customer">
		<g:message code="order.customer.label" default="Customer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="customer" name="customer.id" from="${dk.dm844.webshop.Customer.list()}" optionKey="id" required="" value="${orderInstance?.customer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'orderEntries', 'error')} ">
	<label for="orderEntries">
		<g:message code="order.orderEntries.label" default="Order Entries" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${orderInstance?.orderEntries?}" var="o">
    <li><g:link controller="orderEntry" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="orderEntry" action="create" params="['order.id': orderInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'orderEntry.label', default: 'OrderEntry')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="order.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="status" from="${dk.dm844.webshop.Order$Status?.values()}" keys="${dk.dm844.webshop.Order$Status.values()*.name()}" required="" value="${orderInstance?.status?.name()}" />

</div>

