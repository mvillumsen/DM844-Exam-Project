<%@ page import="dk.dm844.webshop.Person" %>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="person.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${personInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'address', 'error')} ">
    <label for="address">
        <g:message code="person.address.label" default="Address"/>

    </label>
    <g:select id="address" name="address.id" from="${dk.dm844.webshop.Address.list()}" optionKey="id"
              value="${personInstance?.address?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'phone', 'error')} ">
    <label for="phone">
        <g:message code="person.phone.label" default="Phone"/>

    </label>
    <g:textField name="phone" value="${personInstance?.phone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'email', 'error')} required">
    <label for="email">
        <g:message code="person.email.label" default="Email"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="email" name="email" required="" value="${personInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'salary', 'error')} ">
    <label for="salary">
        <g:message code="person.salary.label" default="Salary"/>

    </label>
    <g:field name="salary" type="number" value="${personInstance.salary}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'dateHired', 'error')} ">
    <label for="dateHired">
        <g:message code="person.dateHired.label" default="Date Hired"/>

    </label>
    <g:datePicker name="dateHired" precision="day" value="${personInstance?.dateHired}" default="none"
                  noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'username', 'error')} required">
    <label for="username">
        <g:message code="person.username.label" default="Username"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="username" required="" value="${personInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'password', 'error')} required">
    <label for="password">
        <g:message code="person.password.label" default="Password"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="password" required="" value="${personInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'accountExpired', 'error')} ">
    <label for="accountExpired">
        <g:message code="person.accountExpired.label" default="Account Expired"/>

    </label>
    <g:checkBox name="accountExpired" value="${personInstance?.accountExpired}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'accountLocked', 'error')} ">
    <label for="accountLocked">
        <g:message code="person.accountLocked.label" default="Account Locked"/>

    </label>
    <g:checkBox name="accountLocked" value="${personInstance?.accountLocked}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'assignedOrders', 'error')} ">
    <label for="assignedOrders">
        <g:message code="person.assignedOrders.label" default="Assigned Orders"/>

    </label>

    <ul class="one-to-many">
        <g:each in="${personInstance?.assignedOrders ?}" var="a">
            <li><g:link controller="productOrder" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
        </g:each>
        <li class="add">
            <g:link controller="productOrder" action="create"
                    params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'productOrder.label', default: 'ProductOrder')])}</g:link>
        </li>
    </ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'enabled', 'error')} ">
    <label for="enabled">
        <g:message code="person.enabled.label" default="Enabled"/>

    </label>
    <g:checkBox name="enabled" value="${personInstance?.enabled}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'orders', 'error')} ">
    <label for="orders">
        <g:message code="person.orders.label" default="Orders"/>

    </label>

    <ul class="one-to-many">
        <g:each in="${personInstance?.orders ?}" var="o">
            <li><g:link controller="productOrder" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
        </g:each>
        <li class="add">
            <g:link controller="productOrder" action="create"
                    params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'productOrder.label', default: 'ProductOrder')])}</g:link>
        </li>
    </ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'passwordExpired', 'error')} ">
    <label for="passwordExpired">
        <g:message code="person.passwordExpired.label" default="Password Expired"/>

    </label>
    <g:checkBox name="passwordExpired" value="${personInstance?.passwordExpired}"/>

</div>

