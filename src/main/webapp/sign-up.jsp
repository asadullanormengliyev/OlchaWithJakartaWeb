<%--
  Created by IntelliJ IDEA.
  User: Davron
  Date: 11/11/2024
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>Sign-Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center" style="height: 100vh;">

<form action="/sign-up" method="post" class="bg-white p-4 rounded shadow" style="width: 100%; max-width: 400px;">
    <h2 class="text-center mb-4">Sign Up</h2>

    <div class="mb-3">
        <label for="name" class="form-label">Full Name</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Full Name" required>
    </div>

    <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
    </div>

    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
    </div>

    <div class="mb-3">
        <label for="role" class="form-label">Select Role</label>
        <select id="role" name="role" class="form-select" required>
            <option value="admin">Admin</option>
            <option value="user">User</option>
        </select>
    </div>

    <div class="d-grid">
        <button type="submit" class="btn btn-success">Register</button>
    </div>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>



