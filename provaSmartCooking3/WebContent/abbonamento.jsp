<%--
  Created by IntelliJ IDEA.
  User: luisi
  Date: 14/01/2021
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%//check if the user is registered 
    Boolean logged = (Boolean) session.getAttribute("isUserLog");
    if((logged == null) || !logged.booleanValue()){
        response.sendRedirect("login.jsp");
    }%>
    
    
<%//check if the user has already
String abbonamento = (String) session.getAttribute("abbonamento");
if(abbonamento!=null && abbonamento.length()!=0){
    response.sendRedirect("utente.jsp");
}%>

<jsp:useBean id="session_user" class="Model.Utente" ></jsp:useBean>

<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel = "stylesheet" href="css/registrazione.css" type="text/css">
    <title>Title</title>
</head>
<body>



<div class="container">
    <div class="row">
        <div class="col-md-5 mx-auto">
            <div id="first">
                <div class="myform form ">
                    <div class="logo mb-3">
                        <div class="col-md-12 text-center">
                            <h2>Abbonamento</h2>
                        </div>
                    </div>
                    <form action="Abbonamento" method="post" name="regForm" onsubmit="alert('Abbonamento sottoscritto con successo')">

                        <div class="radio">
                            <label><input type="radio" name="durata" value="mensile" checked="checked">Mensile-Prezzo:3.50</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="durata" value="annuale">Annuale-Prezzo:12.50</label>
                        </div>

                        <input type="hidden" id="email" name="email" value="${user.email}">

                        <div class="col-md-12 text-center ">
                            <button id="abbonamentoSubmit" type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">SOTTOSCRIVI</button>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
