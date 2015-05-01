<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="shopTemplate"/>
    <title><g:message code="springSecurity.login.title"/></title>

</head>

<body>
<tb:breadcrumb>
    <li><g:link url="/webshop"><g:message code="default.home.label"/></g:link></li>
    <tb:liActive><g:message code="default.login.label"/></tb:liActive>
</tb:breadcrumb>

<h1><g:message code="springSecurity.login.header"/></h1>
<tb:pLeadText><g:message code="springSecurity.errors.login.fail"/></tb:pLeadText>

<tb:col12 cssClasses="center">
    <login:form resource="${resource(file: 'j_spring_security_check')}">
        <tb:formGroup>
            <tb:label for="username"><g:message code="default.username.label"/></tb:label>
            <tb:inputForm name="j_username" id="username" type="username" placeholder="Username"/>
        </tb:formGroup>
        <tb:formGroup>
            <tb:label for="password"><g:message code="default.password.label"/></tb:label>
            <tb:inputForm name="j_password" id="password" type="password" placeholder="Password"/>
        </tb:formGroup>
        <login:checkbox><g:message code="default.rememberMe.label"/></login:checkbox>
        <login:signInButton><g:message code="default.signIn.label"/></login:signInButton>
    </login:form>
</tb:col12>

</body>
</html>
