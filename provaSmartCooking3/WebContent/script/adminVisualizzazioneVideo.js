
$(document).ready(function () {

    $.getJSON("VisualizzazioneListaVideo", function (object, status){

        var a = 0;
        for(x in object){


            var x ="<tr> <form action=\"RemoveVideoAdmin\" method=\"post\" id=\"a"+a+"\"></form>"+
            "<form action=\"ModifyVideoAdmin\" method=\"post\" id=\"b"+ a +"\"></form>" +
                "<td>" + object[x].idVideo + "</td>" +
                "<td>" + object[x].titolo + "<input type=\"hidden\" form=\"a"+ a +"\" name=\"titolo\" value=\"" + object[x].titolo + "\"/> </td>"+
                "<input type=\"hidden\" form=\"b" + a + "\" name=\"titolo\" value=\"" + object[x].titolo + "\"/> </td>" +
                "<td>" + object[x].categoria + "</td>" +
                "<td>" + object[x].gratuito + "</td>"+
                "<td><input type=\"image\" id=\"xButton\" form=\"a"+a+"\" src='video/Foto/x.png' alt=\"AVB\" class='x'> </td>"+
                "<td><input type=\"image\" id=\"gearButton\" form=\"b"+a+"\" src='video/Foto/gear.png' alt=\"AVB\" class='x'> </td>"+
                "</tr>"
            /* "<td>"  + object[x].insegnante.nome + "" + object[x].insegnante.cognome + "</td>" +
             "<td>"  + object[x].admin.email + "</td>";*/

            $(".tbodyAdminVideo").append(x);
            a++;

        }
    })

})