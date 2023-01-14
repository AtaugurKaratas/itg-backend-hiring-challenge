<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 13.01.2023
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
  String auth = (String) session.getAttribute("auth");
  if(session.getAttribute("retailerId") == null){
    response.sendRedirect("loginRetailer.jsp");
  }
%>
<html>
<head>
  <title>Sepet Sayfası</title>
  <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<div class="container">
  <div class="d-flex py-3">
    <h3>Toplam Fiyat</h3>
    <a class="mx-3 btn btn-primary" href="#">Sepeti Boşalt</a>
  </div>
  <table class="table table-light">
    <thead>
      <tr>
        <th scope="col">Ürün Adı</th>
        <th scope="col">Fiyatı</th>
        <th scope="col">Satın Al</th>
        <th scope="col">Iptal Et</th>
      </tr>
    </thead>
      <tbody>
        <tr>
          <td>Ürün Adı</td>
          <td>45 TL</td>
          <td>
            <form action="" method="POST" class="form-inline">
              <input type="hidden" name="id" value="1" class="form-input">
              <div class="form-group d-flex justify-content-between">
                <a class="btn btn-sm btn-warning" href="#"><i class="fas fa-solid fa-plus"></i></a>
                <input type="text" name="quantity" class="form-control" value="1" readonly>
                <a class="btn btn-sm btn-warning" href="#"><i class="fas fa-solid fa-minus"></i></a>
              </div>
            </form>
          </td>
          <td>
            <a class="btn btn-small btn-danger" href="#">Kaldır</a>
          </td>
        </tr>
      </tbody>
  </table>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>