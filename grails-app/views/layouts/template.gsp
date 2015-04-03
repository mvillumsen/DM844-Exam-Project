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
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <%-- Brand and toggle get grouped for better mobile display --%>
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/webshop">WEBSHOP</a>
                </div>

                <%-- Collect the nav links, forms, and other content for toggling --%>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <%-- TODO: Insert menu items --%>
                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Link</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <sec:ifLoggedIn>
                            <li><p class="navbar-text">Logged in as <sec:username/></p></li>
                            <li><a class="navbar-link" href="j_spring_security_logout">Logout</a></li>
                        </sec:ifLoggedIn>
                        <sec:ifNotLoggedIn>
                            <li class="dropdown">
                                <a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a>
                                <div class="dropdown-menu" style="padding: 15px; padding-bottom: 15px;">
                                    <form action="${resource(file: 'j_spring_security_check')}" method="POST" accept-charset="UTF-8">
                                        <input style="margin-bottom: 15px;" type="text" placeholder="Username" id="username" name="j_username" class="text_">
                                        <input style="margin-bottom: 15px;" type="password" placeholder="Password" id="password" name="j_password" class="text_">
                                        <input style="float: left; margin-right: 10px;" type="checkbox" class="chk" name="_spring_security_remember_me" id="remember_me" >
                                        <label class="string optional"> Remember me</label>
                                        <input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Sign In">
                                    </form>
                                </div>
                            </li>
                        </sec:ifNotLoggedIn>
                    </ul>
                </div> <%-- /.navbar-collapse --%>
            </div> <%-- /.container-fluid --%>
        </nav>

        <%-- CONTENT --%>
        <div id="wrap">
            <div class="container">

                <div class="page-header">
                    <h1>The Webshop <small>Fresh groceries for everyone!</small></h1>
                </div>

                <%-- SIDEBAR --%>
                <%-- TODO: Layout for small devices (col-xs) --%>
                <%-- TODO: Move to a TagLib at some point? --%>
                <div class="row">
                    <div class="hidden-xs col-sm-3 col-md-3">
                        <ul class="nav nav-pills nav-stacked">

                            <%-- DUMMY DATA --%>
                            <li role="presentation" class="disabled"><a href="#">Special Offers</a></li>
                            <li role="presentation" class="disabled"><a href="#">Fruit & Vegetables</a></li>

                            <%-- Show categories--%>
                            <g:each in="${dk.dm844.webshop.Category.list()}" var="category">
                                <li role="presentation"><g:link controller="Category" action="show" id="${category.id}">${category.name}</g:link></li>
                            </g:each>

                            <%-- DUMMY DATA --%>
                            <li role="presentation" class="disabled"><a href="#">Cold Cuts & Sausages</a></li>
                            <li role="presentation" class="disabled"><a href="#">Bakery</a></li>
                            <li role="presentation" class="disabled"><a href="#">Colonial</a></li>
                            <li role="presentation" class="disabled"><a href="#">Frozen Food</a></li>
                            <li role="presentation" class="disabled"><a href="#">Drinks</a></li>
                            <li role="presentation" class="disabled"><a href="#">Crisps & Candy</a></li>
                            <li role="presentation" class="disabled"><a href="#">Household</a></li>
                            <li role="presentation" class="disabled"><a href="#">Health & Beauty</a></li>
                            <li role="presentation" class="disabled"><a href="#">Home & Ents</a></li>
                        </ul>
                    </div>

                    <%-- Main content frame --%>
                    <div class="col-xs-12 col-sm-9 col-md-9">
                        <g:layoutBody/>
                    </div>

                </div>
            </div>
            <div id="push"></div>
        </div>

        <%-- FOOTER --%>
        <div id="footer">
            <div class="container">
                <p class="muted credit">Example footer</p>
            </div>
        </div>

        <asset:javascript src="application.js"/>
    </body>
</html>
