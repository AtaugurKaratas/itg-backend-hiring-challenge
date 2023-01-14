<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 14.01.2023
  Time: 03:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String auth = (String) session.getAttribute("auth");
    /*
    if (session.getAttribute("retailerId") == null) {
        response.sendRedirect("loginRetailer.jsp");
    }
     */
%>
<c:set var="count" value="${0}"/>
<html>
<head>
    <title>Ürün Detayları</title>
    <%@include file="includes/head.jsp" %>
    <style>
        body {
            background-color: darkslategray;
        }
    </style>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="carousel slide w-25 h-25 mx-auto my-5">
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
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
