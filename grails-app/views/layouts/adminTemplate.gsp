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
<tb:navbarDefault cssClasses="adminNav">
    <tb:containerFluid>
        <tb:navbarHeader>
            <tb:navbarCollapse brand="Admin" url="${createLink(controller: 'employee', action: 'index')}">
                <tb:navbarLeftContent>
                    <tb:language/>
                    <li><g:link controller="Employee" action="assignments" class="navbar-link"><glyph:myTasks/> <g:message
                            code="admin.MyTasks"/><glyph:badge><emp:assignedCount/></glyph:badge></g:link></li>
                </tb:navbarLeftContent>
                <tb:navbarRightContent>
                    <sec:ifLoggedIn>
                        <li><tb:navbarLink url="${createLink(controller: 'home', action: 'index')}"><glyph:shoppingCart/> <g:message
                                code="admin.webshop.label"/></tb:navbarLink>
                        <li><tb:navbarLink url="/webshop/j_spring_security_logout"><glyph:logout/> <g:message
                                code="default.logout.label"/></tb:navbarLink></li>
                        <li><tb:navbarText><strong><g:message
                                code="default.loggedIn"/> <sec:username/></strong></tb:navbarText></li>
                    </sec:ifLoggedIn>
                </tb:navbarRightContent>
            </tb:navbarCollapse>
        </tb:navbarHeader>
    </tb:containerFluid>
</tb:navbarDefault>

<tb:containerFluid>
    <tb:row>
        <tb:col2 cssClasses="navbar-default adminSidebar">
            <tb:navPills cssClasses="admin">
                <tb:sidebarHeader cssClasses="header"><glyph:users/> <g:message code="admin.users.label"/></tb:sidebarHeader>
                <sec:ifAnyGranted roles="${SecurityRole.Employee.ADMIN}">
                    <li><g:link controller="person" class="navbar-link"><g:message code="admin.allUsers"/></g:link></li>
                    <li><g:link controller="person" action="create" class="navbar-link"><g:message
                            code="admin.user.create"/></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="${SecurityRole.Employee.ADMIN}">
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled"><g:message
                            code="admin.allUsers"/></g:link></li>
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled"><g:message
                            code="admin.user.create"/></g:link></li>
                </sec:ifNotGranted>
            </tb:navPills><br>
            <tb:navPills cssClasses="admin">
                <tb:sidebarHeader cssClasses="header"><glyph:products/> <g:message code="admin.products.label"/></tb:sidebarHeader>
                <li><g:link controller="product" class="navbar-link"><g:message
                        code="admin.products.all"/></g:link></li>
                <li><g:link controller="product" class="navbar-link" action="create"><g:message
                        code="admin.products.create"/></g:link></li>
                <li><g:link controller="category" class="navbar-link"><g:message
                        code="admin.categories.label"/></g:link></li>
                <li><g:link controller="category" class="navbar-link" action="create"><g:message
                        code="admin.categories.create"/></g:link></li>
            </tb:navPills><br>
            <tb:navPills cssClasses="admin">
                <tb:sidebarHeader cssClasses="header"><glyph:orders/> <g:message code="admin.orders.label"/></tb:sidebarHeader>

                <li><g:link controller="productOrder" class="navbar-link"><g:message
                        code="admin.orders.all"/></g:link></li>

                <sec:ifAnyGranted roles="${SecurityRole.Employee.PACKER}">
                    <li><g:link controller="productOrder" action="packaging" class="navbar-link">
                        <g:message code="admin.orders.packing"/><tb:pullRight><glyph:badge><po:count
                                status="${ProductOrder.Status.NEW}"/></glyph:badge></tb:pullRight>
                    </g:link></li>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="${SecurityRole.Employee.PACKER}">
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled"><g:message
                            code="admin.orders.shipment"/></g:link></li>
                </sec:ifNotGranted>

                <sec:ifAnyGranted roles="${SecurityRole.Employee.DRIVER}">
                    <li><g:link controller="productOrder" action="shipment" class="navbar-link">
                        <g:message code="admin.orders.shipment"/><tb:pullRight><glyph:badge><po:count
                                status="${ProductOrder.Status.PACKED}"/></glyph:badge></tb:pullRight>
                    </g:link></li>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="${SecurityRole.Employee.DRIVER}">
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled"><g:message
                            code="admin.orders.shipment"/></g:link></li>
                </sec:ifNotGranted>

                <sec:ifAnyGranted roles="${SecurityRole.Employee.ADMIN}">
                    <li><g:link controller="productOrder" action="completed" class="navbar-link">
                        <g:message code="admin.orders.completed"/><tb:pullRight><glyph:badge><po:count
                                status="${ProductOrder.Status.COMPLETED}"/></glyph:badge></tb:pullRight>
                    </g:link></li>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="${SecurityRole.Employee.ADMIN}">
                    <li class="disabled"><g:link url="#" class="navbar-link adminDisabled"><g:message
                            code="admin.orders.completed"/></g:link></li>
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

<tb:footer cssClasses="navbar-default">
    <tb:container>
    </tb:container>
</tb:footer>

<asset:javascript src="application.js"/>
</body>
</html>
