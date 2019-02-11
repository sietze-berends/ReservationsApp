$(document).ready(function () {

    var url_string = window.location.href
    var url = new URL(url_string);
    var guestId = url.searchParams.get("guestId")

    $('#guestId').val(guestId)

    console.log(guestId);

    $.ajax({
        type: 'get',
        url: 'hotel/allguests/' + guestId,
        success: function (result) {
            guest = result;
            console.log(guest);
            fillGuestDetail(guest);
        }
    });
});

function fillGuestDetail($guest) {
    var content = '<table id = "guestDetail" class="table table-bordered table-striped table-hover table-condensed">';
    content += '<thead id = tableHeader>';
    content += '<tr> <th> Guest number </th>';
    content += '<th> Name </th>';
    content += '<th> Birthday </th>';
    content += '<th> E-mail </th>';
    content += '<th> Nationality </th>';
    content += '</thead>';
    content += '<tbody id = "tablebody">';
    console.log($guest);

    content += "<tr>";
    content += "<td>" + guest.guestId + "</td>";
    content += '<td>' + guest.firstName + " " + guest.lastName + '</td>';
    content += "<td>" + guest.dateOfBirth + "</td>";
    content += "<td>" + guest.email + "</td>";
    content += "<td>" + guest.nationality + "</td>";
    content += "</tr>";

    content += '</tbody> </table> <div class = "row"></div>';
    content += '<input id="updateGuest" type="button" value="Update guest"/>';
    content += '<input id="deleteGuest" type="button" value="Delete guest" onClick = deleteGuest(guest.guestId) />';
    $("#guestDetailDiv").html(content);

}

// function that deletes guest on click, and small warning pop up
function deleteGuest(guestId) {

    if (confirm('Are you sure you want to delete this guest?')) {
        var id = guestId;
        jQuery.ajax({
            url: 'hotel/allguests/' + id + '/delete',
            type: 'DELETE',
            success: function() {

            }
        });
        window.location.href = '/hotel/guests/guests.html';
    } else {
        // window.location.href = '/hotel/guests/guests.html';
    }
}


