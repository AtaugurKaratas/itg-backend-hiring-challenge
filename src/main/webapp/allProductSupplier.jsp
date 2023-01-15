<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 15.01.2023
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
    if (session.getAttribute("supplierId") == null) {
        response.sendRedirect("loginSupplier.jsp");
    }
%>
<html>
<head>
    <title>HomePage Retailer</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<form action="all-product-supplier" method="POST">
    <div class="form-group">
        <label for="exampleInputName">Urun Adı</label>
        <input name="name" type="name" class="form-control" id="exampleInputName" placeholder="Urun Adınız Giriniz">
    </div>
    <div class="text-center mt-2">
        <form action="all-product-supplier" method="POST" style="display: inline">
            <button type="submit" class="btn btn-primary" id="btn-submit">Ara</button>
        </form>
        <form action="out-of-stock-supplier" method="POST" style="display: inline">
            <button type="submit" class="btn btn-primary" id="btn-submit-stock">Stokta Bulunmayan Ürünler</button>
        </form>
    </div>
    <div class="container">
        <div class="card-header my-3">Ürünler</div>
        <div class="row">
            <c:forEach items="${productList}" var="productList">
                <div class="col-md-3 my-3">
                    <div class="card w-100" style="width: 18rem;">
                        <img class="card-img-top" src="${productList.path}" alt="#" style="width: 150px; height: 150px">
                        <div class="card-body">
                            <h5 class="card-title">${productList.name}</h5>
                            <h6 class="price">${productList.price}</h6>
                            <h6 class="category">${productList.quantity}</h6>
                            <div class="mt-3 d-flex justify-content-between">
                                <a class="btn btn-primary"
                                   href="detail-product-supplier?id=${productList.productId}&price=${productList.price}&name=${productList.name}&quantity=${productList.quantity}&discount=${productList.discount}">Ürün
                                    Detayları</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <%@include file="includes/footer.jsp" %>
</body>
</html>
