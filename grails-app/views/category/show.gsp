<%@ page import="dk.dm844.webshop.Category" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="shopTemplate">
    <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}"/>
    <title>${categoryInstance?.name}</title>
</head>

<body>
<tb:breadcrumb>
    <li><g:link url="/webshop">Home</g:link></li>
    <tb:liActive>${categoryInstance.name}</tb:liActive>
</tb:breadcrumb>

<cat:listProducts category="${categoryInstance}">
    <tb:productsGridLayout>
        <tb:thumbnails cssClasses="products">
            <g:form controller="product" action="addToCart" id="${it.id}">
                <img class="centerIMG" src="${it.getPicture()}" alt="${it.name}">

                <div class="caption productCaption">
                    <h5 class="text-center">${it.name}</h5>

                    <p class="small">${it.description}</p>
                </div>
                <tb:row cssClasses="productBuy">
                    <tb:col6 cssClasses="buyButton">
                        <tb:buyButton>Buy</tb:buyButton>
                    </tb:col6>
                    <tb:col6 cssClasses="buyForm">
                        <g:field type="number" min="1" class="form-control input-sm buyForm" id="amount" value="1"
                                 name="amount"/>
                    </tb:col6>
                </tb:row>
            </g:form>
        </tb:thumbnails>
    </tb:productsGridLayout>
</cat:listProducts>
</body>
</html>
