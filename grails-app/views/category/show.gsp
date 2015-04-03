
<%@ page import="dk.dm844.webshop.Category" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}" />
		<title>${categoryInstance?.name}</title>
	</head>
	<body>
		<ol class="breadcrumb">
			<li>Home</li>
			<li class="active">${categoryInstance.name}</li>
		</ol>

		<g:if test="${categoryInstance?.products}">
			<g:each in="${categoryInstance.products}" var="p">
				<div class="col-sm-3 col-md-3">
					<div class="thumbnail">
						<img src="${p.getPicture()}" alt="${p.name}">
						<div class="caption">
							<h5 class="text-center">${p.name}</h5>
							<p class="small">${p.description}</p>
							<div class="row">
								<div class="col-xs-5">
								</div>
								<div class="col-xs-2">
									<input class="form-control input-sm" id="amount" type="text">
								</div>
								<div class="col-xs-4">
									<button type="submit" class="btn btn-primary btn-sm" role="button">Buy</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</g:each>
		</g:if>
		</div>
	</body>
</html>
