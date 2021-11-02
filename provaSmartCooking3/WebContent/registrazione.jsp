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
    <title>Registrazione</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel = "stylesheet" href="css/registrazione.css" type="text/css">

    <script>

        function validateForm() {

            var email=document.forms["regForm"]["email"].value;
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

            if(!email.match(regex) || email.length==0)
            {
                document.getElementById("emailmsg").innerHTML="Indirizzo email non valido"
                return false;
            }
            else{
                document.getElementById("emailmsg").innerHTML=""
            }


            var password=document.forms["regForm"]["password"].value;
            if (password.length < 8)
            {
                document.getElementById("passwordmsg").innerHTML="Password non valida"
                return false;
            }

            else{
                document.getElementById("passwordmsg").innerHTML=""
            }

            var nome=document.forms["regForm"]["nome"].value;
            var regex1 = /^[A-Za-z]+$/;

            if (nome.length==0 || !nome.match(regex1))
            {
                document.getElementById("nomemsg").innerHTML="Nome non valido"
                return false;
            }

            else{
                document.getElementById("nomemsg").innerHTML=""

            }

            var cognome=document.forms["regForm"]["cognome"].value;
            var regex2 = /^[a-zA-Z\s]*$/;

            if (cognome.length==0 || !cognome.match(regex2))
            {
                document.getElementById("cognomemsg").innerHTML="Cognome non valido"
                return false;
            }

            else{
                document.getElementById("cognomemsg").innerHTML=""

            }

            var dataNascita=document.forms["regForm"]["dataNascita"].value;

            if (dataNascita.length==0)
            {
                document.getElementById("dataNascitamsg").innerHTML="Inserire la data di nascita"
                return false;
            }

            else{
                document.getElementById("dataNascitamsg").innerHTML=""
            }

            var  telefono= document.forms["regForm"]["telefono"].value;
            var regex3 =  /^[0-9]{10}$/;

            
            if (!telefono.match(regex3) || telefono.length==0 )
            {
                document.getElementById("telefonomsg").innerHTML="Numero di telefono non valido"
                return false;
            }

            else{
                document.getElementById("telefonomsg").innerHTML=""
            }

            alert("Registrazione al sito avvenuta con successo");
            return true;

        }

    </script>


</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-5 mx-auto">
            <div id="first">
                <div class="myform form ">
                    <div class="logo mb-3">
                        <div class="col-md-12 text-center">
                            <h2>Registrazione</h2>
                        </div>
                    </div>
                    <form action="Registrazione" method="post" name="regForm" onsubmit="return validateForm()">
                        <div class="form-group">
                            <label>Indirizzo email</label>
                            <input type="email" name="email"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Inserire l'email">
                            <div id="emailmsg" style="color:Red;"></div>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Inserire la password">
                            <div id="passwordmsg" style="color:Red;"></div>
                        </div>

                        <div class="form-group">
                            <label>Nome</label>
                            <input type="text" name="nome" id="nome"  class="form-control" aria-describedby="emailHelp" placeholder="Inserire il nome">
                            <div id="nomemsg" style="color:Red;"></div>
                        </div>

                        <div class="form-group">
                            <label>Cognome</label>
                            <input type="text" name="cognome" id="cognome"  class="form-control" aria-describedby="emailHelp" placeholder="Inserire il cognome">
                            <div id="cognomemsg" style="color:Red;"></div>
                        </div>

                        <div class="form-group">
                            <label>Data Nascita</label>
                            <input type="date" name="dataNascita" id="dataNascita"  class="form-control" aria-describedby="emailHelp">
                            <div id="dataNascitamsg" style="color:Red;"></div>
                        </div>

                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="tel" name="telefono"  placeholder="10 cifre" id="telefono" required class="form-control" aria-describedby="emailHelp" placeholder="Inserire il numero di telefono">
                            <div id="telefonomsg" style="color:Red;"></div>
                        </div>

                        <div class="col-md-12 text-center ">
                            <button id="submitRegistrazione"type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Registrati</button>
                        </div>
                        <div class="col-md-12 ">
                            <div class="login-or">
                                <hr class="hr-or">
                                <span class="span-or">oppure</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <p class="text-center">Hai già un account? <a href="login.jsp" id="signup">Effettua il login qui</a></p>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
