<%@ page import="dk.dm844.webshop.Category" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<tb:tableStriped>
    <thead>
    <tr>

        <g:sortableColumn property="name" title="${message(code: 'category.name.label', default: 'Name')}"/>

        <g:sortableColumn property="description"
                          title="${message(code: 'category.description.label', default: 'Description')}"/>

        <g:sortableColumn property="dateCreated"
                          title="${message(code: 'category.dateCreated.label', default: 'Date Created')}"/>

        <g:sortableColumn property="lastUpdated"
                          title="${message(code: 'category.lastUpdated.label', default: 'Last Updated')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${categoryInstanceList}" status="i" var="categoryInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="edit"
                        id="${categoryInstance.id}">${fieldValue(bean: categoryInstance, field: "name")}</g:link></td>

            <td>${fieldValue(bean: categoryInstance, field: "description")}</td>

            <td><g:formatDate date="${categoryInstance.dateCreated}"/></td>

            <td><g:formatDate date="${categoryInstance.lastUpdated}"/></td>

        </tr>
    </g:each>
    </tbody>
</tb:tableStriped>

<tb:row>
    <tb:pullLeft cssClasses="adminNewButton">
        <g:link class="create" action="create">
            <tb:button cssClasses="nav-pills"><g:message code="default.new.label" args="[entityName]"/></tb:button>
        </g:link>
    </tb:pullLeft>
    <tb:pullRight>
        <g:if test="${productInstanceCount > 1}">
            <g:paginate total="${productInstanceCount ?: 0}"/>
        </g:if>
    </tb:pullRight>
</tb:row>

</body>
</html>
