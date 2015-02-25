<%@ page import="dk.dm844.webshop.Customer" %>



<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'credentials', 'error')} required">
	<label for="credentials">
		<g:message code="customer.credentials.label" default="Credentials" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="credentials" name="credentials.id" from="${dk.dm844.webshop.Person.list()}" optionKey="id" required="" value="${customerInstance?.credentials?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'orders', 'error')} ">
	<label for="orders">
		<g:message code="customer.orders.label" default="Orders" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${customerInstance?.orders?}" var="o">
    <li><g:link controller="productOrder" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="productOrder" action="create" params="['customer.id': customerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'productOrder.label', default: 'ProductOrder')])}</g:link>
</li>
</ul>


</div>

