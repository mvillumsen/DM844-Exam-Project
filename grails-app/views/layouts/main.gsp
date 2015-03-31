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
                    <a class="navbar-brand" href="#">WEBSHOP</a>
                </div>

                <%-- Collect the nav links, forms, and other content for toggling --%>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <%-- TODO: Insert menu items --%>
                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Link</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a>
                            <div class="dropdown-menu" style="padding: 15px; padding-bottom: 15px;">
                                <form method="post" action="login" accept-charset="UTF-8">
                                    <input style="margin-bottom: 15px;" type="text" placeholder="Username" id="username" name="username" class="form-control">
                                    <input style="margin-bottom: 15px;" type="password" placeholder="Password" id="password" name="password" class="form-control">
                                    <input style="float: left; margin-right: 10px;" type="checkbox" name="remember-me" id="remember-me" >
                                    <label class="string optional"> Remember me</label>
                                    <input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Sign In">
                                </form>
                            </div>
                        </li>
                    </ul>
                </div> <%-- /.navbar-collapse --%>
            </div> <%-- /.container-fluid --%>
        </nav>

        <%-- CONTENT --%>
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
                        <li role="presentation"><a href="#">Special Offers</a></li>
                        <li role="presentation"><a href="#">Fruit & Vegetables</a></li>
                        <li role="presentation"><a href="#">Dairy</a></li>
                        <li role="presentation"><a href="#">Meat</a></li>
                        <li role="presentation"><a href="#">Cold Cuts & Sausages</a></li>
                        <li role="presentation"><a href="#">Bakery</a></li>
                        <li role="presentation"><a href="#">Colonial</a></li>
                        <li role="presentation"><a href="#">Frozen Food</a></li>
                        <li role="presentation"><a href="#">Drinks</a></li>
                        <li role="presentation"><a href="#">Crisps & Candy</a></li>
                        <li role="presentation"><a href="#">Household</a></li>
                        <li role="presentation"><a href="#">Health & Beauty</a></li>
                        <li role="presentation"><a href="#">Home & Ents</a></li>
                    </ul>
                </div>

                <%-- Main content frame --%>
                <div class="col-xs-12 col-sm-9 col-md-9">
                    <g:layoutBody/>
                </div>

            </div>

        </div>
        <asset:javascript src="application.js"/>
    </body>
</html>
