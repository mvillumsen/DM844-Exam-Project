<%@ page import="dk.dm844.webshop.Product" %>

<%-- First Column --%>
<tb:colMd6Xs12>

<%-- Name --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label><strong><g:message code="product.name.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="name" name="name" type="text" placeholder="${g.message(code: "product.name.label")}" value="${productInstance?.name}"
                          required="required"/>
        </tb:col8>
    </tb:formGroup>

<%-- Stock --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label><strong><g:message code="product.stock.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="stock" name="stock" type="number" placeholder="${g.message(code: "product.stock.label")}" value="${productInstance.stock}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Description --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label><strong><g:message code="product.description.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <g:textArea class="form-control" name="description" placeholder="${g.message(code: "product.description.label")}"
                        value="${productInstance?.description}" maxlength="255"/>
        </tb:col8>
    </tb:formGroup>

</tb:colMd6Xs12>

<%-- Second Column --%>
<tb:colMd6Xs12>
<%-- Category --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label><strong><g:message code="product.category.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <g:select class="form-control" id="category" name="category.id" from="${dk.dm844.webshop.Category.list()}" optionKey="id" required="required"
                      value="${productInstance?.category?.id}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Price --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label><strong><g:message code="product.price.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="price" name="price" type="number" placeholder="${g.message(code: "product.price.label")}" value="${productInstance?.price}"/>

        </tb:col8>
    </tb:formGroup>
</tb:colMd6Xs12>
