<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 15.01.2023
  Time: 05:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
    if(session.getAttribute("retailerId") == null){
        response.sendRedirect("loginRetailer.jsp");
    }
    int billId = (int) session.getAttribute("billId");
%>
<html>
<head>
    <title>Sipariş Detayları</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<div class="container">
    <div class="d-flex py-3">
        <h3>${billId} Numaralı Tedarik Işlemi</h3>
    </div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Ürün Adı</th>
            <th scope="col">Adeti</th>
            <th scope="col">Toplam Fiyat</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cartListById}" var="cartListById">
            <tr>
                <td>${cartListById.name}</td>
                <td>${cartListById.quantity}</td>
                <td>${cartListById.price} TL</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="delete-bill" method="POST" style="display: inline">
        <a href="delete-bill?id=${billId}" class="btn btn-danger">Işlemi Iptal Et</a>
    </form>
</div>
<script>

</script>
<%@include file="includes/footer.jsp" %>
</body>
</html>

