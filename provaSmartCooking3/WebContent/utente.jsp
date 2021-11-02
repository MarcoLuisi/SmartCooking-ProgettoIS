<%--
  Created by IntelliJ IDEA.
  User: luisi
  Date: 13/01/2021
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.*, DAO.*" %>

<%//check if the user is registered
    Boolean logged = (Boolean) session.getAttribute("isUserLog");
    if((logged == null) || !logged.booleanValue()){
        response.sendRedirect("login.jsp");
    }%>

<jsp:useBean id="session_user" class="Model.Utente" ></jsp:useBean>

<html>
<head>
    <title>Area utente</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel = "stylesheet" href="css/Utente.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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

            alert("Modficia dei dati avvenuta con successo");
            return true;

        }

    </script>

</head>
<body>

<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1>${user.nome} ${user.cognome} </h1></div>

        <div class="text-right"><a href="index.jsp"><img src="video/logo3.jpg" id="imageLogo" height=100 width=100 alt="Logo"></a></div>
        <div id="below" class="text-right">
            <a href="abbonamento.jsp"> abbonati <span class="glyphicon glyphicon-euro"></span> </a>
            <a href="Logout">logout <span class="glyphicon glyphicon-log-out"></span> </a> </div>




    </div>
    <div class="row">
        <div class="col-sm-3"><!--left col-->



            <div class="text-center">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
                <!--
                <h6>Upload a different photo...</h6>
                <input type="file" class="text-center center-block file-upload">
                -->
            </div>
            <!--</hr><br>-->


            <!--
            <div class="panel panel-default">
                <div class="panel-heading">Website <i class="fa fa-link fa-1x"></i></div>
                <div class="panel-body"><a href="http://bootnipets.com">bootnipets.com</a></div>
            </div>-->



            <!--
            <ul class="list-group">
                <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span> 125</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> 13</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span> 37</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span> 78</li>
            </ul>-->

            <!--
            <div class="panel panel-default">
                <div class="panel-heading">Social Media</div>
                <div class="panel-body">
                    <i class="fa fa-facebook fa-2x"></i> <i class="fa fa-github fa-2x"></i> <i class="fa fa-twitter fa-2x"></i> <i class="fa fa-pinterest fa-2x"></i> <i class="fa fa-google-plus fa-2x"></i>
                </div>
            </div>
            -->

        </div><!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Home</a></li>

                <li><a data-toggle="tab" href="#messages">Abbonamento</a></li>
                <!--
                <li><a data-toggle="tab" href="#settings">Menu 2</a></li>
                -->
            </ul>


            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <form class="form" action="ModificaDatiUtente" onsubmit="return validateForm()" method="post" name = "regForm" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-6">
                               
                                <input type="hidden" id="email" name="email" value ="${user.email}" class="form-control" aria-describedby="emailHelp" placeholder="Inserire l'email">
                               
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Password</h4></label>
                                <input type="password" name="password" value="${user.password}"  class="form-control" aria-describedby="emailHelp" placeholder="Inserire la password">
                                <div id="passwordmsg" style="color:Red;"></div>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Nome</h4></label>
                                <input type="text" name="nome"  value="${user.nome}" id="nome"  class="form-control" aria-describedby="emailHelp" placeholder="Inserire il nome">
                                <div id="nomemsg" style="color:Red;"></div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label><h4>Cognome</h4></label>
                                <input type="text" name="cognome" value="${user.cognome}" id="cognome"  class="form-control" aria-describedby="emailHelp" placeholder="Inserire il cognome">
                                <div id="cognomemsg" style="color:Red;"></div>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Data Nascita</h4></label>
                                <input type="date" name="dataNascita" value="${user.dataNascita}" id="dataNascita"  class="form-control" aria-describedby="emailHelp">
                                <div id="dataNascitamsg" style="color:Red;"></div>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Telefono</h4></label>
                                <input type="text" name="telefono" value="${user.telefono}" id="telefono"  class="form-control" aria-describedby="emailHelp" placeholder="Inserire il numero di telefono">
                                <div id="telefonomsg" style="color:Red;"></div>
                            </div>
                        </div>
                        <!--
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4></label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="password" title="enter your password.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password2"><h4>Verify</h4></label>
                                <input type="password" class="form-control" name="password2" id="password2" placeholder="password2" title="enter your password2.">
                            </div>
                        </div>
                        -->
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Modifica</button>
                                <!--<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>-->
                            </div>
                        </div>
                    </form>

                    <hr>

                </div>
                <div class="tab-pane" id="messages">

                    <h2></h2>

                    <hr>
                    <!--<form class="form" action="##" method="post" id="registrationForm">-->
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Inizio Abbonamento</h4></label>
                                <input type="text" class="form-control"  value="${user.inizioAbbonamento}" name="inizioAbbonamento" id="inizioAbbonamento" readonly>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Fine Abbonamento</h4></label>
                                <input type="text" class="form-control" name="fineAbbonamento" value="${user.fineAbbonamento}"id="fineAbbonamento" readonly >
                            </div>
                        </div>

                        <!--
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone"><h4>Phone</h4></label>
                                <input type="text" class="form-control" name="phone" id="phone" placeholder="enter phone" title="enter your phone number if any.">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile"><h4>Mobile</h4></label>
                                <input type="text" class="form-control" name="mobile" id="mobile" placeholder="enter mobile number" title="enter your mobile number if any.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Email</h4></label>
                                <input type="email" class="form-control" name="email" id="email" placeholder="you@email.com" title="enter your email.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Location</h4></label>
                                <input type="email" class="form-control" id="location" placeholder="somewhere" title="enter a location">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4></label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="password" title="enter your password.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password2"><h4>Verify</h4></label>
                                <input type="password" class="form-control" name="password2" id="password2" placeholder="password2" title="enter your password2.">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                                <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
                            </div>
                        </div>
                    </form>-->

                </div><!--/tab-pane-->
                <!--
                <div class="tab-pane" id="settings">


                    <hr>
                    <form class="form" action="##" method="post" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="first_name"><h4>First name</h4></label>
                                <input type="text" class="form-control" name="first_name" id="first_name" placeholder="first name" title="enter your first name if any.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="last_name"><h4>Last name</h4></label>
                                <input type="text" class="form-control" name="last_name" id="last_name" placeholder="last name" title="enter your last name if any.">
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone"><h4>Phone</h4></label>
                                <input type="text" class="form-control" name="phone" id="phone" placeholder="enter phone" title="enter your phone number if any.">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile"><h4>Mobile</h4></label>
                                <input type="text" class="form-control" name="mobile" id="mobile" placeholder="enter mobile number" title="enter your mobile number if any.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Email</h4></label>
                                <input type="email" class="form-control" name="email" id="email" placeholder="you@email.com" title="enter your email.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Location</h4></label>
                                <input type="email" class="form-control" id="location" placeholder="somewhere" title="enter a location">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4></label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="password" title="enter your password.">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password2"><h4>Verify</h4></label>
                                <input type="password" class="form-control" name="password2" id="password2" placeholder="password2" title="enter your password2.">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success pull-right" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                                <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
                            </div>
                        </div>
                    </form>
                </div>-->


            </div><!--/tab-pane-->
        </div><!--/tab-content-->

    </div><!--/col-9-->
</div><!--/row-->

</body>
</html>
