<!DOCTYPE html>
<html>
<head>
    <title><g:if env="development"><g:message code="grails.runtime.exception" /></g:if><g:else>Error</g:else></title>
    <meta name="layout" content="shopTemplate">
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
</head>

<body>
<g:if env="development">
    <g:renderException exception="${exception}"/>
</g:if>
<g:else>
    <ul class="errors">
        <li><g:message code="default.error" /></li>
    </ul>
</g:else>
</body>
</html>
