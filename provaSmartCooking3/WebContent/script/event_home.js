
function MyFunction(categoria){
    var data;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {

            data = xhr.responseText;
            var object=JSON.parse(data);

            $(".panel-primary").remove();
            $(".panel-danger").remove();
            $(".panel-success").remove();

            var num = 0;
            for(x in object){
                var video = object[x];
                var panel;

                if(video.gratuito===false){

                    panel = $(
                        "<div class =\"panel panel-primary\">" +
                        "<div class =\"panel-heading\">"+ video.titolo + "</div>" +
                        "<div class=\"panel-body\">"+
                        "<video class=\"img-responsive\" id='abbonamento' onplay='checkAbbonamento()' controls poster = "+video.urlFoto+">"+
                        "<source src="+video.urlVideo+">"+
                        "</video></div>"+
                        " <div class=\"panel-footer\">Abbonamento richiesto</div>"+
                        "</div>"
                    );
                }

                else{
                    panel = $(
                        "<div class =\"panel panel-primary\">" +
                        "<div class =\"panel-heading\">"+ video.titolo + "</div>" +
                        "<div class=\"panel-body\">"+
                        "<video class=\"img-responsive\" id='gratuito' onplay='checkLogin()' controls poster = "+video.urlFoto+">"+
                        "<source src="+video.urlVideo+">"+
                        "</video></div>"+
                        " <div class=\"panel-footer\">Gratuito</div>"+
                        "</div>"
                    );
                }


                if(num==0) $("#riga1colonna1").append(panel);
                if(num==1) $("#riga1colonna2").append(panel);
                if(num==2) $("#riga1colonna3").append(panel);
                if(num==3) $("#riga2colonna1").append(panel);
                if(num==4) $("#riga2colonna2").append(panel);
                if(num==5) $("#riga2colonna3").append(panel);
                if(num==6) $("#riga3colonna1").append(panel);
                if(num==7) $("#riga3colonna2").append(panel);
                if(num==8) $("#riga3colonna3").append(panel);
                num++;
            }

        }
    }

    var url="./VideoCategoria?val="+categoria+"";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);

}

function MyFunction1(insegnante){

    var data;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {

            data = xhr.responseText;
            var object=JSON.parse(data);

            $(".panel-primary").remove();
            $(".panel-danger").remove();
            $(".panel-success").remove();

            var num = 0;
            for(x in object){
                var video = object[x];
                var panel;

                if(video.gratuito===false){

                    panel = $(
                        "<div class =\"panel panel-primary\">" +
                        "<div class =\"panel-heading\">"+ video.titolo + "</div>" +
                        "<div class=\"panel-body\">"+
                        "<video class=\"img-responsive\" id='abbonamento' onplay='checkAbbonamento()' controls poster = "+video.urlFoto+">"+
                        "<source src="+video.urlVideo+">"+
                        "</video></div>"+
                        " <div class=\"panel-footer\">Abbonamento richiesto</div>"+
                        "</div>"
                    );
                }

                else{
                    panel = $(
                        "<div class =\"panel panel-primary\">" +
                        "<div class =\"panel-heading\">"+ video.titolo + "</div>" +
                        "<div class=\"panel-body\">"+
                        "<video class=\"img-responsive\" id='gratuito' onplay='checkLogin()' controls poster = "+video.urlFoto+">"+
                        "<source src="+video.urlVideo+">"+
                        "</video></div>"+
                        " <div class=\"panel-footer\">Gratuito</div>"+
                        "</div>"
                    );
                }


                if(num==0) $("#riga1colonna1").append(panel);
                if(num==1) $("#riga1colonna2").append(panel);
                if(num==2) $("#riga1colonna3").append(panel);
                if(num==3) $("#riga2colonna1").append(panel);
                if(num==4) $("#riga2colonna2").append(panel);
                if(num==5) $("#riga2colonna3").append(panel);
                if(num==6) $("#riga3colonna1").append(panel);
                if(num==7) $("#riga3colonna2").append(panel);
                if(num==8) $("#riga3colonna3").append(panel);
                num++;
            }

        }
    }

    var url="./VideoInsegnante?val="+insegnante+"";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);

}


function MyFunction2(keyword){

    var data;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status==200) {

            data = xhr.responseText;
            var object=JSON.parse(data);

            $(".panel-primary").remove();
            $(".panel-danger").remove();
            $(".panel-success").remove();

            var num = 0;
            
            if(data=="[]"){
            	alert("Nessun risultato trovato");
            }
            
            for(x in object){
                var video = object[x];
                var panel;

                if(video.gratuito===false){

                    panel = $(
                        "<div class =\"panel panel-primary\">" +
                        "<div class =\"panel-heading\">"+ video.titolo + "</div>" +
                        "<div class=\"panel-body\">"+
                        "<video class=\"img-responsive\" id='abbonamento' onplay='checkAbbonamento()' controls poster = "+video.urlFoto+">"+
                        "<source src="+video.urlVideo+">"+
                        "</video></div>"+
                        " <div class=\"panel-footer\">Abbonamento richiesto</div>"+
                        "</div>"
                    );
                }

                else{
                    panel = $(
                        "<div class =\"panel panel-primary\">" +
                        "<div class =\"panel-heading\">"+ video.titolo + "</div>" +
                        "<div class=\"panel-body\">"+
                        "<video class=\"img-responsive\" id='gratuito' onplay='checkLogin()' controls poster = "+video.urlFoto+">"+
                        "<source src="+video.urlVideo+">"+
                        "</video></div>"+
                        " <div class=\"panel-footer\">Gratuito</div>"+
                        "</div>"
                    );
                }


                if(num==0) $("#riga1colonna1").append(panel);
                if(num==1) $("#riga1colonna2").append(panel);
                if(num==2) $("#riga1colonna3").append(panel);
                if(num==3) $("#riga2colonna1").append(panel);
                if(num==4) $("#riga2colonna2").append(panel);
                if(num==5) $("#riga2colonna3").append(panel);
                if(num==6) $("#riga3colonna1").append(panel);
                if(num==7) $("#riga3colonna2").append(panel);
                if(num==8) $("#riga3colonna3").append(panel);
                num++;
            }

        }
    }

    var url="./VideoKeyword?val="+keyword+"";
    xhr.open("GET", url, true);
    xhr.setRequestHeader("connection", null);
    xhr.send(null);

}

















