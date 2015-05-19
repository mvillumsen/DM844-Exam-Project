<%@ page import="dk.dm844.webshop.SecurityRole" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags --%>

    <g:javascript library="jquery" plugin="jquery"/>
    <asset:stylesheet src="application.css"/>

    <link rel="shortcut icon" href="http://faviconist.com/icons/d2d33e488275751fc34e3d0fe953857c/favicon.ico"/>
    <title><g:layoutTitle default="Grails"/></title>
    <g:layoutHead/>
</head>

<body>
<tb:navbarDefault>
    <tb:container>
        <tb:navbarHeader>
            <tb:navbarCollapse brand="GroceryShop" url="${createLink(controller: 'home', action: 'index')}">
                <tb:navbarLeftContent>
                    <tb:language/>
                    <li><g:link controller="ShoppingCart"><g:message
                        code="shoppingCart.label"/> <span class="badge"><sc:count/></span></g:link>
                </tb:navbarLeftContent>
                <tb:navbarRightContent>
                    <sec:ifLoggedIn>
                        <sec:ifAnyGranted roles="${SecurityRole.EMPLOYEE}">
                            <li><g:link controller="employee"><g:message code="default.admin.label" /></g:link></li>
                        </sec:ifAnyGranted>
                        <li><tb:navbarLink url="/webshop/j_spring_security_logout"><g:message code="default.logout.label"/> </tb:navbarLink></li>
                        <li><tb:navbarText><strong><g:message code="default.loggedIn" /> <sec:username/></strong></tb:navbarText></li>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <tb:signinDropdown>
                            <login:form resource="${resource(file: 'j_spring_security_check')}">
                                <tb:label for="username"><g:message code="default.username.label"/> </tb:label>
                                <tb:formGroup><tb:inputForm name="j_username" id="username" type="username"
                                                            placeholder="Username"/></tb:formGroup>
                                <tb:label for="password"><g:message code="default.password.label"/> </tb:label>
                                <tb:formGroup><tb:inputForm name="j_password" id="password" type="password"
                                                            placeholder="Password"/></tb:formGroup>
                                <login:checkbox><g:message code="default.rememberMe" /></login:checkbox>
                                <login:signInButton><g:message code="default.signIn.label"/></login:signInButton>
                            </login:form>
                        </tb:signinDropdown>
                    </sec:ifNotLoggedIn>
                </tb:navbarRightContent>
            </tb:navbarCollapse>
        </tb:navbarHeader>
    </tb:container>
</tb:navbarDefault>

<%-- FEEDBACK AREA --%>
<section id="feedback-area"></section>

<%-- CONTENT --%>
<tb:container>
    <header>
        <tb:header>
            <h1><g:layoutTitle/></h1>
        </tb:header>
    </header>

<%-- SIDEBAR --%>
    <tb:row>
        <tb:sidebar>
            <tb:navPills>
            <%-- Show categories--%>
                <cat:listCategories/>
            </tb:navPills>
        </tb:sidebar>

    <%-- Main content frame --%>
        <tb:contentFrame>
            <article>
                <g:layoutBody/>
            </article>
        </tb:contentFrame>
    </tb:row>
</tb:container>

<%-- TODO: Put content in footer --%>
<tb:footer cssClasses="navbar-default">
    <tb:container>
    </tb:container>
</tb:footer>

<asset:javascript src="application.js"/>
</body>
</html>
