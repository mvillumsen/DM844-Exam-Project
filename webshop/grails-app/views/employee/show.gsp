
<%@ page import="dk.dm844.webshop.Employee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-employee" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list employee">
			
				<g:if test="${employeeInstance?.assignedOrders}">
				<li class="fieldcontain">
					<span id="assignedOrders-label" class="property-label"><g:message code="employee.assignedOrders.label" default="Assigned Orders" /></span>
					
						<g:each in="${employeeInstance.assignedOrders}" var="a">
						<span class="property-value" aria-labelledby="assignedOrders-label"><g:link controller="order" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.credentials}">
				<li class="fieldcontain">
					<span id="credentials-label" class="property-label"><g:message code="employee.credentials.label" default="Credentials" /></span>
					
						<span class="property-value" aria-labelledby="credentials-label"><g:link controller="person" action="show" id="${employeeInstance?.credentials?.id}">${employeeInstance?.credentials?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="employee.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${employeeInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.dateHired}">
				<li class="fieldcontain">
					<span id="dateHired-label" class="property-label"><g:message code="employee.dateHired.label" default="Date Hired" /></span>
					
						<span class="property-value" aria-labelledby="dateHired-label"><g:formatDate date="${employeeInstance?.dateHired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="employee.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${employeeInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.salary}">
				<li class="fieldcontain">
					<span id="salary-label" class="property-label"><g:message code="employee.salary.label" default="Salary" /></span>
					
						<span class="property-value" aria-labelledby="salary-label"><g:fieldValue bean="${employeeInstance}" field="salary"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:employeeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${employeeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
