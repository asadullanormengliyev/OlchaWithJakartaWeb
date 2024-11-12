<%--
  Created by IntelliJ IDEA.
  User: Davron
  Date: 11/12/2024
  Time: 4:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/list">
<div class="card">
    <div class="card-header bg-primary text-white">
        <h5>Category</h5>
    </div>
    <div class="card-body">
        <table class="table table-hover table-striped">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Color</th>
                <th>Price</th>
                <th>Active</th>
            </tr>
            </thead>
            <tbody>
<%--            <jsp:useBean id="productList" scope="request" type="java.util.List"/>--%>
            <c:forEach items="${productList}" var="product">

                <tr>
                    <td>${product.getId()}</td>
                    <td>${product.getName()}</td>
                    <td>${user.getColor()}</td>
                    <td>${user.getPrice()}</td>
                    <td>${user.getActive()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</form>

