<%--
  Created by IntelliJ IDEA.
  User: luisi
  Date: 12/01/2021
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel = "stylesheet" href="css/login.css" type="text/css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-5 mx-auto">
            <div id="first">
                <div class="myform form ">
                    <div class="logo mb-3">
                        <div class="col-md-12 text-center">
                            <h2>Login</h2>
                        </div>
                    </div>
                    <form action="Login" method="post" name="login">
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" name="email"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Inserire l' email">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Inserire la Password">
                        </div>

                        <div class="col-md-12 text-center ">
                            <button id="loginsubmit" type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
                        </div>
                        <div class="col-md-12 ">
                            <div class="login-or">
                                <hr class="hr-or">
                                <span class="span-or">oppure</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <p class="text-center">Non hai ancora un account? <a href="registrazione.jsp" id="signup">Registrati qui</a></p>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
