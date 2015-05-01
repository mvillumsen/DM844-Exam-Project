<%@ page import="dk.dm844.webshop.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<tb:table cssClasses="table-striped table-hover">
    <thead>
    <tr>

        <g:sortableColumn property="name" title="${message(code: 'person.name.label', default: 'Name')}"/>

        <th><g:message code="person.address.label" default="Address"/></th>

        <g:sortableColumn property="phone" title="${message(code: 'person.phone.label', default: 'Phone')}"/>

        <g:sortableColumn property="email" title="${message(code: 'person.email.label', default: 'Email')}"/>

        <g:sortableColumn property="salary" title="${message(code: 'person.salary.label', default: 'Salary')}"/>

        <g:sortableColumn property="dateHired"
                          title="${message(code: 'person.dateHired.label', default: 'Date Hired')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${personInstanceList}" status="i" var="personInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show"
                        id="${personInstance.id}">${fieldValue(bean: personInstance, field: "name")}</g:link></td>

            <td>${fieldValue(bean: personInstance, field: "address")}</td>

            <td>${fieldValue(bean: personInstance, field: "phone")}</td>

            <td>${fieldValue(bean: personInstance, field: "email")}</td>

            <td>${fieldValue(bean: personInstance, field: "salary")}</td>

            <td><g:formatDate date="${personInstance.dateHired}"/></td>

        </tr>
    </g:each>
    </tbody>
</tb:table>

<tb:row>
    <tb:pullLeft cssClasses="adminNewButton">
        <g:link class="create" action="create">
            <tb:button cssClasses="nav-pills"><g:message code="default.new.label" args="[entityName]"/></tb:button>
        </g:link>
    </tb:pullLeft>
    <tb:pullRight>
        <g:paginate total="${productInstanceCount ?: 0}"/>
    </tb:pullRight>
</tb:row>

</body>
</html>
