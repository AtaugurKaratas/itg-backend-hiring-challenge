<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 15.01.2023
  Time: 02:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
    if (session.getAttribute("retailerId") == null) {
        response.sendRedirect("loginRetailer.jsp");
    }
%>
<html>
<head>
    <title>Satıcı Alışveriş Listesi</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<div class="container">
    <div class="d-flex py-3">
        <h3>Tedarik Işlemleri</h3>
    </div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Toplam Fiyat</th>
            <th scope="col">Sipariş Tarihi</th>
            <th scope="col">Detaylar</th>
            <th scope="col">Onay Tarihi</th>
            <th scope="col">BAŞARILI / IPTAL</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${billListRetailer}" var="billListRetailer">
            <tr>
                <td>${billListRetailer.totalPrice} TL</td>
                <td>${billListRetailer.creationDate}</td>
                <td>
                    <form action="bill-detail-retailer" method="POST" style="display: inline">
                        <a href="bill-detail-retailer?id=${billListRetailer.id}" type="submit" class="btn btn-warning"
                           id="btn-detail">Detaylar</a>
                    </form>
                </td>
                <td>${billListRetailer.approvalDate != null ? billListRetailer.approvalDate : "-"}</td>
                <td>
                    <form action="delete-bill" method="POST" style="display: inline">
                        <a href="delete-bill?id=${billListRetailer.id}"
                           type="submit" ${billListRetailer.check == true ? 'class="btn btn-success" style="pointer-events: none"' : 'class="btn btn-danger"'}
                           id="btn-check">${billListRetailer.check == true ? "BAŞARILI" : "IPTAL"}</a>
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
