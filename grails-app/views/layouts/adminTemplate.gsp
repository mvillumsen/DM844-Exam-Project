<%@ page import="dk.dm844.webshop.admin.AdminController" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags --%>

    <g:javascript library="jquery" plugin="jquery"/>
    <asset:stylesheet src="application.css"/>

    <link rel="shortcut icon" href="http://faviconist.com/icons/d2d33e488275751fc34e3d0fe953857c/favicon.ico" />
    <title><g:layoutTitle default="Grails"/></title>
    <g:layoutHead/>
</head>
<body>
<tb:navbarAdmin cssClasses="admin">
    <tb:navbarLeftContent>
        <tb:language/>
        <tb:tasks/>
    </tb:navbarLeftContent>
    <tb:navbarRightContent>
        <sec:ifLoggedIn>
            <li><tb:navbarLink url="/webshop/">Webshop</tb:navbarLink>
            <li><tb:navbarText>Logged in as <sec:username/></tb:navbarText></li>
            <li><tb:navbarLink url="/webshop/j_spring_security_logout">Logout</tb:navbarLink></li>
        </sec:ifLoggedIn>
    </tb:navbarRightContent>
</tb:navbarAdmin>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-2 sidebar">
            <ul class="nav nav-pills nav-stacked admin" role="tablist">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">HTML</a></li>
                <li><a href="#">CSS</a></li>
                <li><a href="#">About</a></li>
            </ul>
        </div>
        <div class="col-xs-9 col-xs-offset-2 content">
            <tb:header>
                <h1>The Grocery Shop <small>Fresh groceries for everyone!</small></h1>
            </tb:header>
        </div>
    </div>
</div>

<%-- FEEDBACK AREA --%>
<section id="feedback-area"></section>


<tb:footer cssClasses="admin">
    <tb:container>
        <p class="muted credit">Example footer</p>
    </tb:container>
</tb:footer>

<asset:javascript src="application.js"/>
</body>
</html>
