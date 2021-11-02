

$(document).ready(function () {
    $.getJSON("VisualizzazioneListaUtenti", function (object, status){



        for(x in object){


            var x ="<tr>"+
                "<td>" + object[x].nome + "</td>" +
                "<td>" + object[x].cognome + "</td>" +
                "<td>" + object[x].email + "</td>"+
                    "</tr>";

            $(".tbodyAdmin").append(x);

        }
    })



})