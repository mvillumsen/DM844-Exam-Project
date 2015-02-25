<%@ page import="dk.dm844.webshop.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="person.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${personInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="person.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" required="" value="${personInstance?.address}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="person.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" value="${personInstance?.phone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="person.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${personInstance?.email}"/>

</div>

