<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title><g:layoutTitle default="Grails"/></title>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">WEBSHOP</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
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
        </div> <!-- /.navbar-collapse -->
    </div> <!-- /.container-fluid -->
</nav>
<div class="container">
    <div class="page-header">
        <h1>Example page header <small>Subtext for header1</small></h1>
    </div>

    <div class="row">
        <div class="hidden-xs col-sm-2 col-md-2">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active"><a href="#">Meat</a></li>
                <li role="presentation"><a href="#">Vegetables</a></li>
                <li role="presentation"><a href="#">Drinks</a></li>
                <li role="presentation"><a href="#">Meat</a></li>
                <li role="presentation"><a href="#">Vegetables</a></li>
                <li role="presentation"><a href="#">Drinks</a></li>
            </ul>
        </div>
        <div class="col-xs-12 col-sm-10 col-md-10">
            <%-- EXAMPLE CONTENT START --%>

            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque blandit justo at dui laoreet, vel ultrices odio ultrices. Aliquam mattis eros vitae tortor molestie dapibus. Integer in convallis massa, sit amet imperdiet tellus. Nulla elit elit, volutpat in vulputate non, rhoncus eget libero. Aenean non interdum tellus. Vivamus a quam consequat, interdum nunc a, tempus massa. Nam sodales convallis lacus sit amet condimentum.</p>

            <p>Suspendisse viverra convallis cursus. Ut nisl quam, eleifend pellentesque leo sit amet, sodales porta leo. Curabitur accumsan nisi at pellentesque blandit. Curabitur pretium non sapien sed ornare. In hac habitasse platea dictumst. Integer et magna lectus. Nunc laoreet nulla iaculis, pellentesque sapien ac, egestas ipsum. Fusce a semper felis, vulputate pulvinar justo. Fusce hendrerit fringilla sollicitudin. Phasellus bibendum orci eget eleifend sodales.</p>

            <p>Curabitur ac ullamcorper neque. Duis massa sapien, ullamcorper ultricies metus vitae, luctus posuere mi. Mauris et aliquet velit. Cras gravida nisi vitae accumsan facilisis. Aenean vitae rhoncus metus. Curabitur libero ante, finibus sed enim et, aliquet convallis risus. Curabitur tortor felis, dictum sit amet sem et, mollis suscipit nisl. Nulla elementum at sapien ut tristique. Sed scelerisque nunc vel finibus efficitur. Integer tortor massa, pretium ullamcorper gravida non, tristique ac neque. Donec sagittis lorem ac ligula imperdiet volutpat non et nisi.</p>

            <p>Nunc interdum ipsum eu elit sagittis, nec volutpat libero condimentum. Integer ut lobortis ipsum. Sed vitae dui feugiat, condimentum odio quis, pretium neque. Curabitur vitae urna et dolor ultrices pretium. Sed aliquet enim quis mauris ullamcorper, id rhoncus enim dictum. In consequat porta nisl vel ultrices. In mauris nunc, tincidunt tincidunt laoreet a, dictum at nunc. Pellentesque venenatis libero eget fringilla aliquam.</p>

            <p>Aenean bibendum nec lectus non pulvinar. Phasellus consequat, magna ac euismod fermentum, leo ante feugiat metus, non tempus sapien tellus at erat. Vivamus a eros eget libero imperdiet fermentum. Morbi vitae accumsan dolor. Vestibulum hendrerit euismod efficitur. Suspendisse iaculis non justo suscipit tempus. Vivamus malesuada erat a nunc mollis fermentum. Proin semper venenatis ante, in semper nisi rutrum a. Mauris pellentesque sem et arcu viverra venenatis. Curabitur lacus risus, gravida vel convallis sit amet, tristique eu risus. Phasellus egestas feugiat nibh, vel pharetra mauris sodales sed. Fusce viverra convallis purus.</p>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque blandit justo at dui laoreet, vel ultrices odio ultrices. Aliquam mattis eros vitae tortor molestie dapibus. Integer in convallis massa, sit amet imperdiet tellus. Nulla elit elit, volutpat in vulputate non, rhoncus eget libero. Aenean non interdum tellus. Vivamus a quam consequat, interdum nunc a, tempus massa. Nam sodales convallis lacus sit amet condimentum.</p>

            <p>Suspendisse viverra convallis cursus. Ut nisl quam, eleifend pellentesque leo sit amet, sodales porta leo. Curabitur accumsan nisi at pellentesque blandit. Curabitur pretium non sapien sed ornare. In hac habitasse platea dictumst. Integer et magna lectus. Nunc laoreet nulla iaculis, pellentesque sapien ac, egestas ipsum. Fusce a semper felis, vulputate pulvinar justo. Fusce hendrerit fringilla sollicitudin. Phasellus bibendum orci eget eleifend sodales.</p>

            <p>Curabitur ac ullamcorper neque. Duis massa sapien, ullamcorper ultricies metus vitae, luctus posuere mi. Mauris et aliquet velit. Cras gravida nisi vitae accumsan facilisis. Aenean vitae rhoncus metus. Curabitur libero ante, finibus sed enim et, aliquet convallis risus. Curabitur tortor felis, dictum sit amet sem et, mollis suscipit nisl. Nulla elementum at sapien ut tristique. Sed scelerisque nunc vel finibus efficitur. Integer tortor massa, pretium ullamcorper gravida non, tristique ac neque. Donec sagittis lorem ac ligula imperdiet volutpat non et nisi.</p>

            <p>Nunc interdum ipsum eu elit sagittis, nec volutpat libero condimentum. Integer ut lobortis ipsum. Sed vitae dui feugiat, condimentum odio quis, pretium neque. Curabitur vitae urna et dolor ultrices pretium. Sed aliquet enim quis mauris ullamcorper, id rhoncus enim dictum. In consequat porta nisl vel ultrices. In mauris nunc, tincidunt tincidunt laoreet a, dictum at nunc. Pellentesque venenatis libero eget fringilla aliquam.</p>

            <p>Aenean bibendum nec lectus non pulvinar. Phasellus consequat, magna ac euismod fermentum, leo ante feugiat metus, non tempus sapien tellus at erat. Vivamus a eros eget libero imperdiet fermentum. Morbi vitae accumsan dolor. Vestibulum hendrerit euismod efficitur. Suspendisse iaculis non justo suscipit tempus. Vivamus malesuada erat a nunc mollis fermentum. Proin semper venenatis ante, in semper nisi rutrum a. Mauris pellentesque sem et arcu viverra venenatis. Curabitur lacus risus, gravida vel convallis sit amet, tristique eu risus. Phasellus egestas feugiat nibh, vel pharetra mauris sodales sed. Fusce viverra convallis purus.</p>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque blandit justo at dui laoreet, vel ultrices odio ultrices. Aliquam mattis eros vitae tortor molestie dapibus. Integer in convallis massa, sit amet imperdiet tellus. Nulla elit elit, volutpat in vulputate non, rhoncus eget libero. Aenean non interdum tellus. Vivamus a quam consequat, interdum nunc a, tempus massa. Nam sodales convallis lacus sit amet condimentum.</p>

            <p>Suspendisse viverra convallis cursus. Ut nisl quam, eleifend pellentesque leo sit amet, sodales porta leo. Curabitur accumsan nisi at pellentesque blandit. Curabitur pretium non sapien sed ornare. In hac habitasse platea dictumst. Integer et magna lectus. Nunc laoreet nulla iaculis, pellentesque sapien ac, egestas ipsum. Fusce a semper felis, vulputate pulvinar justo. Fusce hendrerit fringilla sollicitudin. Phasellus bibendum orci eget eleifend sodales.</p>

            <p>Curabitur ac ullamcorper neque. Duis massa sapien, ullamcorper ultricies metus vitae, luctus posuere mi. Mauris et aliquet velit. Cras gravida nisi vitae accumsan facilisis. Aenean vitae rhoncus metus. Curabitur libero ante, finibus sed enim et, aliquet convallis risus. Curabitur tortor felis, dictum sit amet sem et, mollis suscipit nisl. Nulla elementum at sapien ut tristique. Sed scelerisque nunc vel finibus efficitur. Integer tortor massa, pretium ullamcorper gravida non, tristique ac neque. Donec sagittis lorem ac ligula imperdiet volutpat non et nisi.</p>

            <p>Nunc interdum ipsum eu elit sagittis, nec volutpat libero condimentum. Integer ut lobortis ipsum. Sed vitae dui feugiat, condimentum odio quis, pretium neque. Curabitur vitae urna et dolor ultrices pretium. Sed aliquet enim quis mauris ullamcorper, id rhoncus enim dictum. In consequat porta nisl vel ultrices. In mauris nunc, tincidunt tincidunt laoreet a, dictum at nunc. Pellentesque venenatis libero eget fringilla aliquam.</p>

            <p>Aenean bibendum nec lectus non pulvinar. Phasellus consequat, magna ac euismod fermentum, leo ante feugiat metus, non tempus sapien tellus at erat. Vivamus a eros eget libero imperdiet fermentum. Morbi vitae accumsan dolor. Vestibulum hendrerit euismod efficitur. Suspendisse iaculis non justo suscipit tempus. Vivamus malesuada erat a nunc mollis fermentum. Proin semper venenatis ante, in semper nisi rutrum a. Mauris pellentesque sem et arcu viverra venenatis. Curabitur lacus risus, gravida vel convallis sit amet, tristique eu risus. Phasellus egestas feugiat nibh, vel pharetra mauris sodales sed. Fusce viverra convallis purus.</p>

            <%-- EXAMPLE CONTENT END --%>

            <g:layoutBody/>

        </div>

    </div>

</div>
<asset:javascript src="application.js"/>
</body>
</html>
