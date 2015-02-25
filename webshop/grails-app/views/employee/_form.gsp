<%@ page import="dk.dm844.webshop.Employee" %>



<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'assignedOrders', 'error')} ">
	<label for="assignedOrders">
		<g:message code="employee.assignedOrders.label" default="Assigned Orders" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${employeeInstance?.assignedOrders?}" var="a">
    <li><g:link controller="productOrder" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="productOrder" action="create" params="['employee.id': employeeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'productOrder.label', default: 'ProductOrder')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'credentials', 'error')} required">
	<label for="credentials">
		<g:message code="employee.credentials.label" default="Credentials" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="credentials" name="credentials.id" from="${dk.dm844.webshop.Person.list()}" optionKey="id" required="" value="${employeeInstance?.credentials?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'dateHired', 'error')} required">
	<label for="dateHired">
		<g:message code="employee.dateHired.label" default="Date Hired" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateHired" precision="day"  value="${employeeInstance?.dateHired}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'salary', 'error')} required">
	<label for="salary">
		<g:message code="employee.salary.label" default="Salary" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="salary" type="number" value="${employeeInstance.salary}" required=""/>

</div>

