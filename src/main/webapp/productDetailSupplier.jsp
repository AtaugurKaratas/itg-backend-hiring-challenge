<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 15.01.2023
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
    /*
    if (session.getAttribute("retailerId") == null) {
        response.sendRedirect("loginRetailer.jsp");
    }
     */
    int productId = (Integer) session.getAttribute("productId");
    double productPrice = (Double) session.getAttribute("productPrice");
    String productName = String.valueOf(session.getAttribute("productName"));
    int productQuantity = (Integer) session.getAttribute("productQuantity");
    int productDiscount = (Integer) session.getAttribute("productDiscount");
%>
<c:set var="count" value="${0}"/>
<html>
<head>
    <title>Ürün Detayları</title>
    <%@include file="includes/head.jsp" %>
    <style>
        body {
            background-color: gainsboro;
        }
    </style>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="carousel slide w-25 h-25 mx-auto my-5">
    <div class="text-center mt-2">
        <h5 class="card-title">${productName}</h5>
    </div>
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <c:forEach items="${imageList}" var="imageList">
                <c:if test="${count > 0}">
                    <div class="carousel-item">
                        <img src="${imageList.path}" class="d-block" alt="..." style="height: 500px; width: 500px;">
                    </div>
                </c:if>
                <c:if test="${count == 0}">
                    <div class="carousel-item active">
                        <img src="${imageList.path}" class="d-block" alt="..." style="height: 500px; width: 500px;">
                    </div>
                    <c:set var="count" value="${count+1}"/>
                </c:if>
            </c:forEach>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <div class="text-center mt-2">
        <form action="update-product" method="POST">
            <h6 class="card-title">Fiyat: ${productPrice} TL</h6>
            <div class="form-group">
                <label for="exampleInputQuantity">Ürün Adedi</label>
                <input name="quantity" type="text" class="form-control" id="exampleInputQuantity"
                       value="${productQuantity}">
                <input name="id" type="hidden" class="form-control" value="${productId}">
            </div>
            <div class="form-group">
                <label for="exampleInputDiscount">Indirim Orani</label>
                <input name="discount" type="text" class="form-control" id="exampleInputDiscount"
                       value="${productDiscount}">
            </div>
            <button type="submit" class="btn btn-primary" id="btn-submit">Güncelle</button>
        </form>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>