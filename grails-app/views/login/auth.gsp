<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="template"/>
    <title><g:message code="springSecurity.login.title"/></title>

</head>
<body>
    <tb:breadcrumb>
        <li><g:link url="/webshop">Home</g:link></li>
        <tb:breadcrumbActive>Login</tb:breadcrumbActive>
    </tb:breadcrumb>

    <h1><g:message code="springSecurity.login.header"/></h1>
    <tb:pLeadText><g:message code="springSecurity.errors.login.fail"/></tb:pLeadText>

    <tb:col12 cssClasses="center">
        <login:form resource="${resource(file: 'j_spring_security_check')}">
            <login:formGroup>
                <login:label for="username">Username</login:label>
                <login:inputForm name="j_username" id="username" type="username" placeholder="Username"/>
            </login:formGroup>
            <login:formGroup>
                <login:label for="password">Password</login:label>
                <login:inputForm name="j_password" id="password" type="password" placeholder="Password"/>
            </login:formGroup>
            <login:checkbox>Remember me</login:checkbox>
            <login:signInButton>Sign In</login:signInButton>
        </login:form>
    </tb:col12>

</body>
</html>
