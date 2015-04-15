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
                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Link</a></li>
                <li><g:link controller="ShoppingCart">ShoppingCart (<sc:count>it</sc:count>)</g:link>
            </tb:navbarLeftContent>
            <tb:navbarRightContent>
                <sec:ifLoggedIn>
                    <li><tb:navbarText>Logged in as <sec:username/></tb:navbarText></li>
                    <li><tb:navbarLink url="j_spring_security_logout">Logout</tb:navbarLink></li>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <tb:signinDropdown>
                        <form action="${resource(file: 'j_spring_security_check')}" method="POST" accept-charset="UTF-8">
                            <input style="margin-bottom: 15px;" type="text" placeholder="Username" id="username" name="j_username" class="text_">
                            <input style="margin-bottom: 15px;" type="password" placeholder="Password" id="password" name="j_password" class="text_">
                            <input style="float: left; margin-right: 10px;" type="checkbox" class="chk" name="_spring_security_remember_me" id="remember_me" >
                            <label class="string optional"> Remember me</label>
                            <input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Sign In">
                        </form>
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
                    <%-- TODO: Move to Service --%>
                    <%-- Show categories--%>
                    <g:each in="${Category.list()}" var="category">
                        <li role="presentation"><g:link controller="Category" action="show" id="${category.id}">${category.name}</g:link></li>
                    </g:each>

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
