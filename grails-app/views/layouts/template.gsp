<%@ page import="dk.dm844.webshop.Category" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <%-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags --%>

        <link rel="shortcut icon" href="http://faviconist.com/icons/d2d33e488275751fc34e3d0fe953857c/favicon.ico" />
        <title><g:layoutTitle default="Grails"/></title>
        <asset:stylesheet src="application.css"/>
        <g:layoutHead/>
    </head>
    <body>
        <tb:navbar>
            <tb:navbarLeftContent>
                <tb:activeli><a href="#">Link <span class="sr-only">(current)</span></a></tb:activeli>
                <li><a href="#">Link</a></li>
                <li><g:link controller="ShoppingCart">ShoppingCart (<sc:count>it</sc:count>)</g:link>
            </tb:navbarLeftContent>
            <tb:navbarRightContent>
                <sec:ifLoggedIn>
                    <li><tb:navbarText>Logged in as <sec:username/></tb:navbarText></li>
                    <li><tb:navbarLink url="/webshop/j_spring_security_logout">Logout</tb:navbarLink></li>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <tb:signinDropdown>
                        <login:form resource="${resource(file: 'j_spring_security_check')}">
                            <login:label for="username">Username</login:label>
                            <login:formGroup><login:inputForm name="j_username" id="username" type="username" placeholder="Username"/></login:formGroup>
                            <login:label for="password">Password</login:label>
                            <login:formGroup><login:inputForm name="j_password" id="password" type="password" placeholder="Password"/></login:formGroup>
                            <login:checkbox>Remember me</login:checkbox>
                            <login:signInButton>Sign In</login:signInButton>
                        </login:form>
                    </tb:signinDropdown>
                </sec:ifNotLoggedIn>
            </tb:navbarRightContent>
        </tb:navbar>

        <%-- CONTENT --%>
        <tb:content>
            <header>
                <tb:header>
                    <h1>The Webshop <small>Fresh groceries for everyone!</small></h1>
                </tb:header>
            </header>

            <%-- SIDEBAR --%>
            <tb:row>
                <tb:sidebar>

                    <%-- Show categories--%>
                    <cat:listCategories/>

                    <%-- DUMMY DATA --%>
                    <li role="presentation" class="disabled"><a href="#">Special Offers</a></li>
                    <li role="presentation" class="disabled"><a href="#">Fruit & Vegetables</a></li>
                    <li role="presentation" class="disabled"><a href="#">Cold Cuts & Sausages</a></li>
                    <li role="presentation" class="disabled"><a href="#">Bakery</a></li>
                    <li role="presentation" class="disabled"><a href="#">Colonial</a></li>
                    <li role="presentation" class="disabled"><a href="#">Frozen Food</a></li>
                    <li role="presentation" class="disabled"><a href="#">Drinks</a></li>
                    <li role="presentation" class="disabled"><a href="#">Crisps & Candy</a></li>
                    <li role="presentation" class="disabled"><a href="#">Household</a></li>
                    <li role="presentation" class="disabled"><a href="#">Health & Beauty</a></li>
                    <li role="presentation" class="disabled"><a href="#">Home & Ents</a></li>
                </tb:sidebar>

                <%-- Main content frame --%>
                <tb:contentFrame>
                    <article>
                        <g:layoutBody/>
                    </article>
                </tb:contentFrame>
            </tb:row>
        </tb:content>

        <footer>
            <tb:container>
                <p class="muted credit">Example footer</p>
            </tb:container>
        </footer>

        <asset:javascript src="application.js"/>
    </body>
</html>
