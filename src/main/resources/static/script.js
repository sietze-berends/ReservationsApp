$( document ).ready(function() {

     $('#goToHotel').click(function() {
        window.location.href = "/hotel.html";
        })

     $('#showAllRooms').click(function() {
        var rooms;
        $.ajax({
           type:"get",
           url: "hotel/rooms",
           success: function(result) {
               $("#showAllRooms").hide();
               rooms = result;
               fillRooms(rooms);
           }
        })
     })

     function fillRooms($rooms) {
        var content = "<p> Rooms: <table class=\"table table-condensed\" \"table table-bordered\">"
        content += "<tr> <th> Room number </th> <th> Single beds </th> <th> Double beds </th>";
        $.each($rooms, function (index, value) {
            content += "<tr>"
            content += "<td>" + value.roomId + "</td>";
            content += "<td>" + value.singleBeds + "</td>"
            content += "<td>" + value.doubleBeds + "</td>"
            content += "</tr>";
        })
        content += "</table></p>"
        $("#roomInfo").html(content)
     }
});