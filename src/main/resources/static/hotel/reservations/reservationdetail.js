$(document).ready(function () {
    console.log("In de reservationdetail javaschript file");
    var url_string = window.location.href;
    var url = new URL(url_string);
    var id = url.searchParams.get("reservationNumber");

    $('#reservationNumber').val(id)

    console.log(id);

    $.ajax({
        type: 'get',
        url: 'hotel/allreservations/' + id,
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
    content += "<td>" + reservation.id + "</td>";
    content += '<td>'
                var $rooms = reservation.roomList
console.log($rooms)
                $.each($rooms, function (index, value) {
                    content += + value.roomNr
                    if (!(index == $rooms.length -1)) {
                        content += "/"
                    }
                })

                content += "</td>"
    content += "<td>" + reservation.booker["firstName"] + " " + reservation.booker["lastName"] + "</td>"
    content += "<td>" + reservation.totalGuests + "</td>"
    content += "<td>" + reservation.startStr + "</td>"
    content += "<td>" + reservation.endStr + "</td>"

            if (reservation.checkedIn) {
                content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
                } else {
                content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                }

    content += "</tr>"
    content += '</tbody> </table> <div class = "row"></div>';
    content += '<input id="updateReservation" type="button" value="Update reservation"/>';
    content += '<input id="deleteReservation" type="button" value="Delete reservation" onClick = deleteReservation(reservation.id) />';
    $("#reservationDetailDiv").html(content);

}

function deleteReservation(reservationNumber) {

    if(confirm('Are you sure you want to delete this room?')){
    var id = reservationNumber;
        jQuery.ajax({
            url: 'hotel/allreservations/' + id + '/delete',
            type: 'DELETE',
            success: function() {

            }
        });
        window.location.href = '/hotel/reservations/reservations.html'
        }else{
        window.location.href = '/hotel/reservations/reservations.html'
        }
        // build redirect link
};

