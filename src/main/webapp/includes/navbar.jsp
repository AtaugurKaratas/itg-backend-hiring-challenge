<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 12.01.2023
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<meta charset="UTF-8">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Tedarik Zinciri Yonetimi</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto">
                <%
                    if (auth == null) {
                 %>
                <li class="nav-item active"><a class="nav-link" href="retailer-login">Satici Giris</a></li>
                <li class="nav-item active"><a class="nav-link" href="supplier-login">Tedarikci Giris</a></li>
                <% } if (retailerId != null){ %>
                <li class="nav-item active"><a class="nav-link" href="/supply-chain-management-1.0-SNAPSHOT/homePageRetailer.jsp">Urun Arama</a></li>
                <li class="nav-item active"><a class="nav-link" href="/supply-chain-management-1.0-SNAPSHOT/add-product">Urun Ekle</a></li>
                <li class="nav-item active"><a class="nav-link" href="/supply-chain-management-1.0-SNAPSHOT/cart.jsp">Sepet <span class="btn-danger">${cartList.size()}</span></a></li>
                <li class="nav-item active"><a class="nav-link" href="/supply-chain-management-1.0-SNAPSHOT/bill-retailer">Bekleyen Islemler</a></li>
                <% } %>
                <% if (supplierId != null){ %>
                <li class="nav-item active"><a class="nav-link" href="/supply-chain-management-1.0-SNAPSHOT/billDetail">Bekleyen Siparisler</a></li>
                <li class="nav-item active"><a class="nav-link" href="/supply-chain-management-1.0-SNAPSHOT/allProductSupplier.jsp">Urunler</a></li>
                <% } %>
                <% if (auth != null) { %>
                <li class="nav-item active"><a class="nav-link" href="/supply-chain-management-1.0-SNAPSHOT/logout">Logout</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
