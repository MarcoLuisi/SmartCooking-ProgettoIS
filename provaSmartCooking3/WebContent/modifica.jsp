
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.*, DAO.*" %>

<%//check if the admin is registered
    Boolean logged = (Boolean) session.getAttribute("isAdminLog");
    if((logged == null) || !logged.booleanValue()){
        response.sendRedirect("login.jsp");
    }%>

<jsp:useBean id="session_video" class="Model.Video" ></jsp:useBean>

<html>
<head>
    <title>Modifica</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel = "stylesheet" href="css/admin.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="script/adminVisualizzazioneUtenti.js"type="text/javascript"></script>
    <script src="script/adminVisualizzazioneVideo.js"type="text/javascript"></script>
    <script>

        function validateForm() {

		   
        	
            var titolo=document.forms["regForm"]["titolo"].value;
            var regex2 = /^[a-zA-Z\s]*$/;

            if (titolo.length==0 || !titolo.match(regex2))
            {
                document.getElementById("titolomsg").innerHTML="Titolo non valido"
                return false;
            }

            else{
                document.getElementById("titolomsg").innerHTML=""
            }

            /*
            var file = document.forms["regForm"]["file"].value;
            if(file == ''){
                document.getElementById("filemsg").innerHTML="Nessun Video Caricato"
                return false;
            }
            else{
                document.getElementById("filemsg").innerHTML=""
            }*/


            alert("Modifica avvenuta con successo");
            return true;
        }

    </script>

</head>
<body>

<% VideoRepositoryImpl videoRepository = new VideoRepositoryImpl(); %>
<% String titolo = request.getParameter("titolo");%>
<% Video v = videoRepository.getVideo(titolo); %> 
<% boolean gratuito = v.isGratuito(); %>
<% String categoria = v.getCategoria(); %>
<% int idinsegnante = v.getIdinsegnante(); %>


<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1>${admin.email} </h1></div>

        <div class="text-right"><a href="index.jsp"><img src="video/logo3.jpg" height=100 width=100 alt="Logo"></a></div>
        <div id="below" class="text-right">

            <a href="Logout"> <span class="glyphicon glyphicon-log-out"></span> </a> </div>


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
                <li class="active"><a data-toggle="tab" href="#home">Modifica Video</a></li>

                <!-- <li><a data-toggle="tab" href="#messages">Lista Video</a></li>

                <li><a data-toggle="tab" href="#settings">Lista Utenti</a></li> -->

            </ul>


            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <form class="form" action="UpdateVideoAdmin" onsubmit="return validateForm()" method="post" name = "regForm" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Titolo</h4></label>
                                <input type="text" id="titolo" name="titolo"  class="form-control" aria-describedby="emailHelp" value="${product.titolo}">
                                <div id="titolomsg" style="color:Red;"></div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label><h4>Tipologia</h4></label>
                                <select name="tipologia" class="form-control" id="sel0">
                                
                                
                                <%
                    if(gratuito==true){%>
                      <option selected = "selected" value="true">Gratuito</option>
                                    <option value="false">Non Gratuito</option>
                   <%}
                             
                    if(gratuito==false){%>
                    <option value="true">Gratuito</option>
                                    <option value="false" selected = "selected">Non Gratuito</option>
                  <%}%>
                                 
                                </select>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Categoria</h4></label>
                                <select name="categoria" class="form-control" id="sel1">
                                
                                   
                                <%
                    if(categoria.equals("Antipasti")){%>
                         <option value="Antipasti" selected = "selected">Antipasti</option>
                                    <option value="Primi">Primi</option>
                                    <option value="Secondi">Secondi</option>
                                    <option value="Dolci">Dolci</option>
                                    <option value="Contorni">Contorni</option>
                   <%}
                                
                                if(categoria.equals("Primi")){%>
                                  <option value="Antipasti">Antipasti</option>
                                    <option value="Primi" selected = "selected">Primi</option>
                                    <option value="Secondi">Secondi</option>
                                    <option value="Dolci">Dolci</option>
                                    <option value="Contorni">Contorni</option>
                             <%}
                                
                                if(categoria.equals("Secondi")){%>
                                
                                   <option value="Antipasti">Antipasti</option>
                                    <option value="Primi">Primi</option>
                                    <option value="Secondi" selected ="selected">Secondi</option>
                                    <option value="Dolci">Dolci</option>
                                    <option value="Contorni">Contorni</option>
                             <%}

                                
                                if(categoria.equals("Dolci")){%>
                                   <option value="Antipasti">Antipasti</option>
                                    <option value="Primi">Primi</option>
                                    <option value="Secondi">Secondi</option>
                                    <option value="Dolci" selected = "selected">Dolci</option>
                                    <option value="Contorni">Contorni</option>
                             <%}
                                
                                if(categoria.equals("Contorni")){%>
                             
                                <option value="Antipasti">Antipasti</option>
                                    <option value="Primi">Primi</option>
                                    <option value="Secondi">Secondi</option>
                                    <option value="Dolci">Dolci</option>
                                    <option value="Contorni" selected ="selected">Contorni</option>
                              <%}%>

                                
                                 
                                </select>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Insegnante</h4></label>
                                <select name="idInsegnante" class="form-control" id="sel2">
                                
                                
                                      
                                <%
                    if(idinsegnante==1){%>
                    
                     <option value="1" selected = "selected">Alfonso Pepe</option>
                                <option value="2">Benedetta Rossi</option>
                                <option value="3">Sonia Peronaci</option>
                                <option value="4">Stefano Barbato</option>
                                <option value="5">Max Mariola</option>
                                <option value="6">Luca Pappagallo</option>
                        
                   <%}
                                
                                if(idinsegnante==2){%>
                                   <option value="1" >Alfonso Pepe</option>
                                <option value="2" selected = "selected">Benedetta Rossi</option>
                                <option value="3">Sonia Peronaci</option>
                                <option value="4">Stefano Barbato</option>
                                <option value="5">Max Mariola</option>
                                <option value="6">Luca Pappagallo</option>
                        
                             <%}
                                
                                if(idinsegnante==3){%>
                                  <option value="1" >Alfonso Pepe</option>
                                <option value="2">Benedetta Rossi</option>
                                <option value="3" selected="selected">Sonia Peronaci</option>
                                <option value="4">Stefano Barbato</option>
                                <option value="5">Max Mariola</option>
                                <option value="6">Luca Pappagallo</option>
                             <%}

                                
                                if(idinsegnante==4){%>
                                     <option value="1" >Alfonso Pepe</option>
                                <option value="2">Benedetta Rossi</option>
                                <option value="3" >Sonia Peronaci</option>
                                <option value="4" selected ="selected">Stefano Barbato</option>
                                <option value="5">Max Mariola</option>
                                <option value="6">Luca Pappagallo</option>
                             <%}
                                
                                if(idinsegnante==5){%>
                                 <option value="1" >Alfonso Pepe</option>
                                <option value="2">Benedetta Rossi</option>
                                <option value="3" >Sonia Peronaci</option>
                                <option value="4">Stefano Barbato</option>
                                <option value="5" selected ="selected">Max Mariola</option>
                                <option value="6">Luca Pappagallo</option>
                          <%}
                                
                                if(idinsegnante==6){%>
                             
                                <option value="1" >Alfonso Pepe</option>
                                <option value="2">Benedetta Rossi</option>
                                <option value="3" >Sonia Peronaci</option>
                                <option value="4">Stefano Barbato</option>
                                <option value="5">Max Mariola</option>
                                <option value="6" selected ="selected">Luca Pappagallo</option>
                              <%}%>
                                
                                
                      
                                </select>
                            </div>
                        </div>

						<!-- 
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>File</h4></label>
                                <input type="file" class="form-control" name="file" id="file" accept="video/mp4">
                                <div id="filemsg" style="color:Red;"></div>
                            </div>
                        </div> -->


                        <!--
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
                        </div>-->
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
                        <input type ="hidden" id="email" name="email" value="${admin.email}">
                          <input type ="hidden" id="idVideo" name="idVideo" value="${product.idVideo}">
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button id="submitCaricamento" class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Carica Video</button>
                                <!--<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>-->
                            </div>
                        </div>
                    </form>

                    <hr>

                </div>
                <!-- div class="tab-pane" id="messages">
                    <hr>
                    <table class="table table-condensed">
                        <thead class="thead">
                        <tr>
                            <th>Id Video</th>
                            <th>Titolo</th>
                            <th>Categoria</th>
                            <th>Gratuito</th>
                            <th>Elimina</th>
                            <th>Modifica</th>

                        </tr>
                        </thead>
                        <tbody class="tbodyAdminVideo">
                        </tbody>
                    </table>

                </div><!--/tab-pane-->

               <!--  <div class="tab-pane" id="settings">
                    <hr>
                    <table class="table table-condensed">
                        <thead class="thead">
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Email</th>
                        </tr>
                        </thead>
                        <tbody class="tbodyAdmin">
                        </tbody>
                    </table>

                </div>-->


            </div><!--/tab-pane-->
        </div><!--/tab-content-->

    </div><!--/col-9-->
</div><!--/row-->

</body>
</html>
