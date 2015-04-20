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
			<li>Home</li>
			<tb:breadcrumbActive>${categoryInstance.name}</tb:breadcrumbActive>
		</tb:breadcrumb>

		<%-- TODO: Test this --%>
		<cat:listProducts category="${categoryInstance}">
			<tb:productsGridLayout>
				<tb:thumbnails cssClasses="products">
					<img src="${it.getPicture()}" alt="${it.name}">
					<div class="caption productCaption">
						<h5 class="text-center">${it.name}</h5>
						<p class="small">${it.description} ${it.description}</p>
					</div>
					<tb:row cssClasses="productBuy">
						<g:form controller="product" action="addToCart" id="${it.id}">
							<tb:col6of12 cssClasses="buyButton">
								<tb:buyButton>Buy</tb:buyButton>
							</tb:col6of12>
							<tb:col6of12 cssClasses="buyForm">
								<g:textField class="form-control input-sm buyForm" id="amount" type="text" value="1" name="amount"/>
							</tb:col6of12>
						</g:form>
					</tb:row>
				</tb:thumbnails>
			</tb:productsGridLayout>
		</cat:listProducts>
	</body>
</html>
