<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 10.01.2023
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String auth = (String) session.getAttribute("auth");
    if(session.getAttribute("supplierId") == null){
        response.sendRedirect("loginSupplier.jsp");
    }
%>
<html>
<head>
    <title>HomePage Supplier</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<div class="container">
    <div class="d-flex py-3">
        <h3>Bekleyen Tedarik Işlemleri</h3>
    </div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Satıcı Adı</th>
            <th scope="col">Toplam Fiyat</th>
            <th scope="col">Sipariş Tarihi</th>
            <th scope="col">Detaylar</th>
            <th scope="col">ONAY - IPTAL</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${billList}" var="billList">
            <tr>
                <td>${billList.retailerName}</td>
                <td>${billList.totalPrice} TL</td>
                <td>${billList.creationDate}</td>
                <td>
                    <form action="" method="POST" style="display: inline">
                        <a href="detailBill?id=${billList.id}" type="submit" class="btn btn-warning" id="btn-detail">Detaylar</a>
                    </form>
                </td>
                <td>
                    <form action="" method="POST" style="display: inline">
                        <button type="submit" class="btn btn-warning" id="btn-check">Işlemi Onayla</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>