<%@ page import="dk.dm844.webshop.Address" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <g:set var="entityName" value="${message(code: 'address.label', default: 'Address')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-address" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><g:link controller="home" action="index" class="home"><g:message code="default.home.label" default="Home"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
    </ul>
</div>

<div id="list-address" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

        </tr>
        </thead>
        <tbody>
        <g:each in="${addressInstanceList}" status="i" var="addressInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${addressInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
