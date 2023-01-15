<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 14.01.2023
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
    if(session.getAttribute("supplierId") == null){
        response.sendRedirect("loginSupplier.jsp");
    }
    int billId = (int) session.getAttribute("billId");
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
        <h3>${billId} Numaralı Tedarik Işlemi</h3>
    </div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Ürün Adı</th>
            <th scope="col">Adeti</th>
            <th scope="col">Toplam Fiyat</th>
            <th scope="col">ONAY - IPTAL</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cartListById}" var="cartListById">
            <tr>
                <td>${cartListById.name}</td>
                <td>${cartListById.quantity} TL</td>
                <td>${cartListById.price}</td>
                <td>
                    <form action="" method="POST" style="display: inline">
                        <button type="submit" class="btn btn-warning" id="btn-check">Işlemi Onayla</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="confirm-bill" method="POST" style="display: inline">
        <a href="confirm-bill?id=${billId}" class="btn btn-warning">Işlemi Onayla</a>
    </form>
</div>
<script>

</script>
<%@include file="includes/footer.jsp" %>
</body>
</html>
