<%@ page import="dk.dm844.webshop.Category" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}" />
		<title>${categoryInstance?.name}</title>
	</head>
	<body>
		<tb:breadcrumb>
			<li><g:link url="/webshop">Home</g:link></li>
			<tb:liActive>${categoryInstance.name}</tb:liActive>
		</tb:breadcrumb>

		<%-- TODO: Test this --%>
		<cat:listProducts category="${categoryInstance}">
			<tb:productsGridLayout>
				<tb:thumbnails cssClasses="products">
					<img src="${it.getPicture()}" alt="${it.name}">
					<div class="caption productCaption">
						<h5 class="text-center">${it.name}</h5>
						<p class="small">${it.description}</p>
					</div>
					<tb:row cssClasses="productBuy">
						<g:form controller="product" action="addToCart" id="${it.id}">
							<tb:col6 cssClasses="buyButton">
								<tb:buyButton>Buy</tb:buyButton>
							</tb:col6>
							<tb:col6 cssClasses="buyForm">
								<g:textField class="form-control input-sm buyForm" id="amount" type="text" value="1" name="amount"/>
							</tb:col6>
						</g:form>
					</tb:row>
				</tb:thumbnails>
			</tb:productsGridLayout>
		</cat:listProducts>
	</body>
</html>
