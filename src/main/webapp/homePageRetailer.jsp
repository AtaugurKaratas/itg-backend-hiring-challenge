<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 10.01.2023
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String auth = (String) session.getAttribute("auth");
    if(session.getAttribute("retailerId") == null){
        response.sendRedirect("loginRetailer.jsp");
    }
%>
<html>
<head>
    <title>HomePage Retailer</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<form action="search-product" method="POST">
    <div class="form-group">
        <label for="exampleInputName">Urun Adı</label>
        <input name="name" type="name" class="form-control" id="exampleInputName" placeholder="Urun Adınız Giriniz">
    </div>
    <div class="text-center mt-2">
        <button type="submit" class="btn btn-primary" id="btn-submit">Ara</button>
    </div>
</form>
<div class="container">
    <div class="card-header my-3">Ürünler</div>
    <div class="row">
    <c:forEach items="${productList}" var="productList">
        <div class="col-md-3 my-3">
            <div class="card w-100" style="width: 18rem;">
                <img class="card-img-top" src="productImage/download.png" alt="#">
                <div class="card-body">
                    <h5 class="card-title">${productList.name}</h5>
                    <h6 class="price">${productList.price}</h6>
                    <h6 class="category">${productList.quantity}</h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a class="btn btn-dark" href="#">Add to Cart</a>
                        <a class="btn btn-primary" href="#">Buy Now</a>
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
