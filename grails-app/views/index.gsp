<!DOCTYPE html>
<html>
	<head>
        <meta name="layout" content="main"/>
        <title>Welcome to The Webshop</title>

	</head>
	<body>
        <ol class="breadcrumb">
            <li class="active">Home</li>
        </ol>

        <%-- EXAMPLE GRID LAYOUT --%>
        <g:each in="${(1..3).toList()}">
            <div class="row">
            <g:each in="${(1..6).toList()}">
                <div class="col-sm-2 col-md-2">
                    <div class="thumbnail">
                        <img src="http://lorempixel.com/100/100/food/" alt="...">
                        <div class="caption">
                            <h4 class="text-center">Grocery</h4>
                            <p class="small">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            <p class="text-center"><a href="#" class="btn btn-primary btn-xs" role="button">Add to basket</a></p>
                        </div>
                    </div>
                </div>
            </g:each>
            </div>
        </g:each>

	</body>
</html>
