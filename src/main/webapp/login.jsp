<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">

    <form method="POST" action="rest/login" class="form-signin">

        <input id="requestURI" type="hidden" value="/" name="requestURI"/>

        <h2 class="form-signin-heading" >oh shit not you again</h2>

        <label for="username" class="sr-only">Login</label>
        <input class="form-control" id="username" required="required" type="text" name="username"/>

        <label for="password" class="sr-only">Password</label>
        <input class="form-control" id="password" required="required" type="password" name="password"/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div>
</body>
</html>
