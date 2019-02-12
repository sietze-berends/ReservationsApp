$( document ).ready(function() {
    var reservations;
    $.ajax({
       type:'get',
       url: '../hotel/allreservations/',
       success: function(result) {
           reservations = result;
           fillReservations(reservations);
           }
       })
    });

    // open form
    $(document).on('click', '#addReservation', function(){
        window.location.href = '/hotel/reservations/addreservation.html';
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
            content += "<td style='cursor: pointer;' id='reservationNumber' onClick = showSingleReservation()>" + value.reservationNumber + "</td>";
            content += '<td>'
            var $rooms = value.roomList

            $.each($rooms, function (index, value) {
                content += + value.roomNr
                if (!(index == $rooms.length -1)) {
                    content += "/"
                }
            })

            content += "</td>"
            content += "<td>" + value.booker["firstName"] + " " + value.booker["lastName"] + "</td>"
            content += "<td>" + value.totalGuests + "</td>"
            content += "<td>" + value.startStr + "</td>"
            content += "<td>" + value.endStr + "</td>"

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


function showSingleReservation(){
    var tbl = document.getElementById("allReservations");

    if (tbl != null) {
        for (var i = 0; i < tbl.rows.length; i++) {
            for (var j = 0; j < tbl.rows[i].cells.length; j++)
                tbl.rows[i].cells[j].onclick = function () { getval(this); };
        }
    }

    function getval(cel) {
        var reservationNumber = cel.innerHTML;
        window.location.href = '/hotel/reservations/reservationdetail.html?reservationNumber=' + encodeURIComponent(reservationNumber);

    }



}