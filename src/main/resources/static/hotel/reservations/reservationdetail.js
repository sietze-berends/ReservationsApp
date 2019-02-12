$(document).ready(function () {
    console.log("In de reservationdetail javaschript file");
    var url_string = window.location.href;
    var url = new URL(url_string);
    var reservationNumber = url.searchParams.get("reservationNumber");

    $('#reservationNumber').val(reservationNumber)

    console.log(reservationNumber);

    $.ajax({
        type: 'get',
        url: 'hotel/allreservations/' + reservationNumber,
        success: function (result) {
            reservation = result;
            console.log(reservation);
            fillReservationDetail(reservation);
        }
    });
});

function fillReservationDetail($reservation) {
    var content = '<table id = "reservationDetail" class="table table-bordered table-striped table-hover table-condensed">';
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
    console.log($reservation);


    content += "<tr>";
    content += "<td>" + reservation.reservationNumber + "</td>";
    content += '<td>'
                var $rooms = reservation.roomList

                $.each($rooms, function (index, value) {
                    content += + reservation.roomNr
                    if (!(index == $rooms.length -1)) {
                        content += "/"
                    }
                })

                content += "</td>"
    content += "<td>" + reservation.booker["firstName"] + " " + reservation.booker["lastName"] + "</td>"
    content += "<td>" + reservation.totalGuests + "</td>"
    content += "<td>" + reservation.startStr + "</td>"
    content += "<td>" + reservation.endStr + "</td>"
    content += "</tr>"
    content += '</tbody> </table> <div class = "row"></div>';
    content += '<input id="updateReservation" type="button" value="Update reservation"/>';
    content += '<input id="deleteReservation" type="button" value="Delete reservation" onClick = deleteReservation(reservation.reservationNumber) />';
    $("#reservationDetailDiv").html(content);

}

function deleteReservation(reservationNumber) {

    console.log("reaches delete");
    console.log(reservationNumber);
    var id = reservationNumber;
        jQuery.ajax({
            url: 'hotel/allreservations/' + id + '/delete',
            type: 'DELETE',
            success: function() {
                console.log("deleted!!!!")
                //window.location.href = '/hotel/guests/guests.html'
            }
        });
        // build redirect link
};

