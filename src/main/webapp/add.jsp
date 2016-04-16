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

    <form method="POST" action="rest/create" class="form-signin">
        <label for="username" class="sr-only">User Name</label>
        <input class="form-control" id="username" required="required" type="text" name="j_username"/>

        <label for="password" class="sr-only">Password</label>
        <input class="form-control" id="password" required="required" type="password" name="j_password"/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
    </form>

</div>
</body>
</html>
