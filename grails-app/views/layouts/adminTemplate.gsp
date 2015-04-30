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
        <%-- TODO: Make counter for tasks --%>
        <li><g:link controller="Employee" action="assignments" class="navbar-link">My Tasks (0)</g:link></li>
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
    <tb:row>
        <tb:col2 cssClasses="sidebar">
            <ul class="nav nav-pills nav-stacked admin">
                <li class="navbar-brand header">My User</li><hr>
                <li class="menu"><g:link controller="employee" action="assignments" class="navbar-link">Assignments</g:link></li>
                <li class="menu"><a href="#">Categories</a></li>
            </ul><br>
            <ul class="nav nav-pills nav-stacked admin">
                <li class="navbar-brand header">Products</li><hr>
                <li class="menu"><a href="#">All products</a></li>
                <li class="menu"><a href="#">Categories</a></li>
            </ul><br>
            <ul class="nav nav-pills nav-stacked admin">
            <li class="navbar-brand header">Orders</li><hr>
                <li class="menu"><a href="#">All orders</a></li>
                <li class="menu"><g:link controller="productOrder" action="shipment">Shipment</g:link></li>
                <li class="menu"><g:link controller="productOrder" action="packaging">Packing</g:link></li>
                <li class="menu"><g:link controller="productOrder" action="completed">Completed orders</g:link></li>
            </ul>
        </tb:col2>
        <div class="col-xs-10 col-xs-offset-2 content">
            <tb:header cssClasses="headerAdmin">
                <h1><g:layoutTitle/></h1>
            </tb:header>
            <article>
                <g:layoutBody/>
            </article>
        </div>
    </tb:row>
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
