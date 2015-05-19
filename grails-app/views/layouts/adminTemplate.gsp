<%@ page import="dk.dm844.webshop.SecurityRole; dk.dm844.webshop.ProductOrder" %>
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

<tb:navbarInverse cssClasses="admin">
    <tb:containerFluid>
        <tb:navbarHeader>
            <tb:navbarCollapse brand="GroceryShop" url="/webshop/admin">
                <tb:navbarLeftContent>
                    <tb:language/>
                    <li><g:link controller="Employee" action="assignments"
                                class="navbar-link">My Tasks (<emp:assignedCount/>)</g:link></li>
                </tb:navbarLeftContent>
                <tb:navbarRightContent>
                    <sec:ifLoggedIn>
                        <li><tb:navbarLink url="/webshop/">Webshop</tb:navbarLink>
                        <li><tb:navbarLink url="/webshop/j_spring_security_logout">Logout</tb:navbarLink></li>
                        <li><tb:navbarText><strong>Logged in as <sec:username/></strong></tb:navbarText></li>
                    </sec:ifLoggedIn>
                </tb:navbarRightContent>
            </tb:navbarCollapse>
        </tb:navbarHeader>
    </tb:containerFluid>
</tb:navbarInverse>

<tb:containerFluid>
    <tb:row>
        <tb:col2 cssClasses="sidebar">
            <tb:navPills cssClasses="admin">
                <tb:sidebarHeader cssClasses="header">Users</tb:sidebarHeader>
                <sec:ifAnyGranted roles="${SecurityRole.Employee.ADMIN}">
                    <li><g:link controller="person" class="navbar-link">All Users</g:link></li>
                    <li><g:link controller="person" action="create" class="navbar-link">Create User</g:link></li>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="${SecurityRole.Employee.ADMIN}">
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled">All Users</g:link></li>
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled">Create User</g:link></li>
                </sec:ifNotGranted>
            </tb:navPills><br>
            <tb:navPills cssClasses="admin">
                <tb:sidebarHeader cssClasses="header">Products</tb:sidebarHeader>
                <li><g:link controller="product" class="navbar-link">All Products</g:link></li>
                <li><g:link controller="product" action="create">Create Product</g:link></li>
                <li><g:link controller="category" class="navbar-link">Categories</g:link></li>
                <li><g:link controller="category" action="create" class="navbar-link">Create Categorys</g:link></li>
            </tb:navPills><br>
            <tb:navPills cssClasses="admin">
                <tb:sidebarHeader cssClasses="header">Orders</tb:sidebarHeader>

                <li><g:link controller="productOrder" class="navbar-link">All Orders</g:link></li>

                <sec:ifAnyGranted roles="${SecurityRole.Employee.PACKER}">
                    <li><g:link controller="productOrder" action="packaging" class="navbar-link">
                        Packing (<po:count status="${ProductOrder.Status.NEW}"/>)
                    </g:link></li>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="${SecurityRole.Employee.PACKER}">
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled">Shipment</g:link></li>
                </sec:ifNotGranted>

                <sec:ifAnyGranted roles="${SecurityRole.Employee.DRIVER}">
                    <li><g:link controller="productOrder" action="shipment" class="navbar-link">
                        Shipment (<po:count status="${ProductOrder.Status.PACKED}"/>)
                    </g:link></li>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="${SecurityRole.Employee.DRIVER}">
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled">Shipment</g:link></li>
                </sec:ifNotGranted>

                <sec:ifAnyGranted roles="${SecurityRole.Employee.ADMIN}">
                    <li><g:link controller="productOrder" action="completed" class="navbar-link">
                        Completed orders (<po:count status="${ProductOrder.Status.COMPLETED}"/>)
                    </g:link></li>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="${SecurityRole.Employee.ADMIN}">
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled">Completed</g:link></li>
                </sec:ifNotGranted>

            </tb:navPills>
        </tb:col2>
        <tb:contentFrameAdmin cssClasses="content">
            <tb:header cssClasses="headerAdmin">
                <h1><g:layoutTitle/></h1>
            </tb:header>
            <article>
                <g:layoutBody/>
            </article>
        </tb:contentFrameAdmin>
    </tb:row>
</tb:containerFluid>

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
