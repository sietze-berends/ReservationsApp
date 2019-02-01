$( document ).ready(function() {
    var reservations;
    $.ajax({
       type:'get',
       url: '../hotel/reservations',
       success: function(result) {
           reservations = result;
           fillReservations(reservations);
           }
       })
    });

     function fillReservations($reservations) {
        var content = '<input id="addReservation" type="button" value="Add reservation"/>'
        content += '<table id = "allReservations" class="table table-bordered table-striped table-hover table-condensed">'
        content += '<thead id = "thead">'
        content += '<tr> <th> Reservation number </th>'
        content += '<th> Rooms </th>'
        content += '<th> Booker </th>'
        content += '<th> Nr. of Guests </th>'
        content += '<th> Check-in-time </th>'
        content += '<th> Check-out-time </th>'
        content += '<th> Checked-in </th>'
        content += '</thead>'
        content += '<tbody id = tableBody>'

        $.each($reservations, function (index, value) {
            content += "<tr>"
            content += '<td>' + value.reservationNumber + '</td>';
            content += '<td>'
            var $rooms = value.roomList

            $.each($rooms, function (index, value) {
                content += + value.roomId
                console.log(index)
                console.log($rooms.length)
                if (!(index == $rooms.length -1)) {
                    content += "/"
                }
            })

            content += "</td>"
            content += "<td>" + value.booker["firstName"] + " " + value.booker["lastName"] + "</td>"
            content += "<td>" + value.totalGuests + "</td>"
            var startStr = JSON.stringify(value.start)
            var startDate = new Date(value.start)
            var endStr = JSON.stringify(value.end)
            var endDate = new Date(value.end)
            content += "<td>" + startDate + "</td>"
            content += "<td>" + endStr + "</td>"

            if (value.checkedIn) {
                content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
                } else {
                content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                }
            content += "</tr>";
        })
        content += '</tbody> </table> <div class = "row"></div>'
        $("#allReservationsDiv").html(content)
        $('#allReservations').DataTable();
     }