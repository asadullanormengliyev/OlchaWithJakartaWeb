<%--
  Created by IntelliJ IDEA.
  User: Davron
  Date: 11/12/2024
  Time: 3:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sidebar with JSP Loading</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .sidebar {
            background-color: #f8f9fa;
            height: 100vh;
            padding-top: 20px;
        }
        .sidebar ul {
            list-style-type: none;
            padding: 0;
        }
        .sidebar li {
            padding: 15px;
            cursor: pointer;
            color: #007bff;
        }
        .sidebar li:hover {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <nav class="col-md-3 col-lg-2 sidebar d-flex flex-column align-items-start">
            <ul id="menu" class="w-100">
                <li onclick="loadContent('category.jsp')">Category</li>
                <li onclick="loadContent('product-list.jsp')">Product</li>
                <li onclick="loadContent('cart.jsp')">Cart</li>
                <li onclick="loadContent('order.jsp')">Order</li>
            </ul>
        </nav>

        <!-- Main Content -->
        <main class="col-md-9 col-lg-10 pt-4">
            <div id="table-container"></div>
        </main>
    </div>
</div>

<script>
    function loadContent(page) {
        fetch(page)
            .then(response => response.text())
            .then(data => {
                document.getElementById('table-container').innerHTML = data;
            })
            .catch(error => console.log('Error loading page:', error));
    }
</script>
</body>
</html>


