<%@ page import="Model.Utente" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Homepage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel = "stylesheet" href="css/Homepage.css" type="text/css">
    <script src="script/event_home.js"type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



</head>
<body class="body">

<div class="jumbotron">
    <div class="container text-center">

        <h1>SmartCooking</h1>
        <div class="text-center"><img src="video/logo3.jpg" height=100 width=100 alt="Logo"></div>

    </div>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="#">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">

                <li><a href="#Pasta" onclick="MyFunction('Antipasti')">Antipasti</a></li>
                <li><a href="#Carne" onclick="MyFunction('Primi')">Primi</a></li>
                <li><a href="#Pesce" onclick="MyFunction('Secondi')">Secondi</a></li>
                <li><a href="#Contorno" onclick="MyFunction('Contorni')">Contorni</a></li>
                <li><a href="#Dolce" onclick="MyFunction('Dolci')">Dolci</a></li>

            </ul>

            <form action="#insegnante" class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" id="keyword" class="form-control" placeholder="Digita">
                </div>
                <button onclick="MyFunction2(document.getElementById('keyword').value)" type="submit" class="btn btn-default">Submit</button>
            </form>
            
            <ul class="nav navbar-nav navbar-right">

                <%Boolean loggedUser = (Boolean) session.getAttribute("isUserLog");
                    if(loggedUser!=null && loggedUser==true){%>
                     <li><a href="utente.jsp">user<span class="glyphicon glyphicon-user"></span>  </a></li>
                   <%}


                    Boolean loggedAdmin = (Boolean) session.getAttribute("isAdminLog");
                    if(loggedAdmin!=null && loggedAdmin==true){%>
                     <li><a href="admin.jsp">admin<span class="glyphicon glyphicon-user"></span>  </a></li>
                    <%}


                    if((loggedUser==null || loggedUser==false)&&(loggedAdmin==null||loggedAdmin==false)){%>
                     <li><a href="login.jsp">login<span class="glyphicon glyphicon-log-in"></span>  </a></li>
                   <%}%>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-4" id="riga1colonna1">

            <div class="panel panel-primary">
                <div class="panel-heading">Colomba di pasqua di Alfonso Pepe</div>
                <div class="panel-body"><video  onplay='checkLogin()' id="video1" class="img-responsive" controls poster = "FotoVideo/2.jpg">
                    <source src="video/2.mp4">
                </video> </div>
                <div class="panel-footer">Gratuito</div>
            </div>

        </div>
        <div class="col-sm-4" id="riga1colonna2">

           <div class="panel panel-primary">
               <div class="panel-heading">Patate alla savoiarda di Luca Pappagallo</div>
               <div class="panel-body"><video  onplay='checkAbbonamento()' id="video2" class="img-responsive"  controls poster = "FotoVideo/10.jpg">
                   <source src="video/10.mp4" type="video/mp4">
               </video> </div>
               <div class="panel-footer">Abbonamento Richiesto</div>
           </div>

       </div>
       <div class="col-sm-4" id="riga1colonna3">

          <div class="panel panel-primary">
              <div class="panel-heading">Cotoletta alla milanese di Max Mariola </div>
              <div class="panel-body"><video  onplay='checkLogin()' class="img-responsive"  controls poster = "FotoVideo/6.jpg">
                  <source src="video/6.mp4" type="video/mp4">
              </video> </div>
              <div class="panel-footer">Gratuito</div>
          </div>

      </div>
  </div>
</div><br>

<div class="container">
  <div class="row">
      <div class="col-sm-4" id="riga2colonna1">

         <div class="panel panel-primary">
             <div class="panel-heading">Spaghetti alla carbonara di Stefano Barbato</div>
             <div class="panel-body"><video  onplay='checkLogin()' class="img-responsive"  controls poster = "FotoVideo/5.jpg">
                 <source src="video/5.mp4" type="video/mp4">
             </video> </div>
             <div class="panel-footer">Gratuito</div>
         </div>

     </div>
     <div class="col-sm-4" id="riga2colonna2">

         <div class="panel panel-primary">
             <div class="panel-heading">Pesce spada con pomodorini di Max Mariola</div>
             <div class="panel-body"><video onplay='checkLogin()'  class="img-responsive"  controls poster = "FotoVideo/7.jpg">
                 <source src="video/7.mp4" type="video/mp4">
             </video> </div>
             <div class="panel-footer">Gratuito</div>
         </div>

     </div>
     <div class="col-sm-4" id="riga2colonna3">

        <div class="panel panel-primary">
            <div class="panel-heading">Pollo alla cacciatora di Sonia Peronaci</div>
            <div class="panel-body"><video onplay='checkLogin()' class="img-responsive"  controls poster = "FotoVideo/4.jpg">
                <source src="video/4.mp4" type="video/mp4">
            </video> </div>
            <div class="panel-footer">Gratuito</div>
        </div>

    </div>
</div>
</div><br>


<div class ="container">
<div class="row">
    <div class="col-sm-4" id="riga3colonna1"></div>
    <div class="col-sm-4" id="riga3colonna2"></div>
    <div class="col-sm-4" id="riga3colonna3"></div>
</div>
</div> <br>

<div class ="container">
<div class="row">
    <div class="col-sm-4" id="riga4colonna1"></div>
    <div class="col-sm-4" id="riga4colonna2"></div>
    <div class="col-sm-4" id="riga4colonna3"></div>
</div>
</div> <br>

<div class ="container">
<div class="row">
    <div class="col-sm-4" id="riga5colonna1"></div>
    <div class="col-sm-4" id="riga5colonna2"></div>
    <div class="col-sm-4" id="riga5colonna3"></div>
</div>
</div> <br>

<div class ="container">
<div class="row">
    <div class="col-sm-4" id="riga6colonna1"></div>
    <div class="col-sm-4" id="riga6colonna2"></div>
    <div class="col-sm-4" id="riga6colonna3"></div>
</div>
</div> <br>

<div class ="container">
<div class="row">
    <div class="col-sm-4" id="riga7colonna1"></div>
    <div class="col-sm-4" id="riga7colonna2"></div>
    <div class="col-sm-4" id="riga7colonna3"></div>
</div>
</div> <br>

<div class ="container">
<div class="row">
    <div class="col-sm-4" id="riga8colonna1"></div>
    <div class="col-sm-4" id="riga8colonna2"></div>
    <div class="col-sm-4" id="riga8colonna3"></div>
</div>
</div> <br><br>



<footer class="container-fluid text-center">
<p>Online Store Copyright</p>
</footer>

<script>
    function checkLogin(){

        var utente = <%=loggedUser%>

            if(utente==null|| utente===false){
                alert("Devi effettuare il login per visualizzare i video");
                window.location.href = "login.jsp";
            }
    }

    function checkAbbonamento(){

        var utente = <%=loggedUser%>

        if(utente==null|| utente===false){
            alert("Devi effettuare il login per visualizzare i video");
            window.location.href = "login.jsp";
            return;
        }

        var abbonamento = <%=((String) session.getAttribute("abbonamento"))%>

        if(abbonamento==null || abbonamento.length==0){
            alert("Devi sottoscrivere l'abbonamento per accedere a questo contenuto");
            window.location.href = "utente.jsp";
        }
    }


</script>

</body>
</html>
