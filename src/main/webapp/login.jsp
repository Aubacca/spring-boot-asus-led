<%--
  Created by IntelliJ IDEA.
  User: pro
  Date: 11-Jun-19
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Asus Led - Login</title>
    <link rel='stylesheet' href='./webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <meta charset="UTF-8">
</head>
<body>
<div class="container align-content-center">
    <h1>App Asus Login Page</h1>

    <div class="container">
        <div class="alert alert-danger">
            ${SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
        <form action="login" method="post">
            <div class="row">
                <div class="offset-2 col-md-2">
                    <label for="username">UserId:</label>
                </div>
                <div class="col-md-4">
                    <input class="w-100" name="username" id="username" placeholder="User ID"/>
                </div>
            </div>
            <div class="row">
                <div class="offset-2 col-md-2">
                    <label class="text-right" for="password">Password:</label>
                </div>
                <div class="col-md-4">
                    <input class="w-100" name="password" id="password" type="password" placeholder="User password"/>
                </div>
            </div>
            <div class="row">
                <div class="offset-4 col-md-4">
                    <button class="btn btn-primary btn-block" type="submit">Login</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
