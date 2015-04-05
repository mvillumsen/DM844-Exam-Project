
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
					<div class="thumbnail products">
						<img src="${p.getPicture()}" alt="${p.name}">
						<div class="caption productCaption">
							<h5 class="text-center">${p.name}</h5>
							<p class="small">${p.description} ${p.description}</p>
						</div>
						<div class="row productBuy">
							<g:form controller="product" action="addToCart" id="${p.id}">
							<div class="col-sm-6 col-md-6 buyButton">
								<button type="submit" class="btn btn-primary btn-sm" role="button">Buy</button>
							</div>
							<div class="col-sm-6 col-md-6 buyForm">
                            <g:textField class="form-control input-sm buyForm" id="amount" type="text" value="1" name="amount"/>
							</div>
							</g:form>
						</div>
					</div>
				</div>
			</g:each>
		</g:if>
		</div> <!-- Hvad lukker denne div? -->
	</body>
</html>
