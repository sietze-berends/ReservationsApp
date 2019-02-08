$( document ).ready(function() {
    console.log("ready");
    var guestDetail;
    $.ajax({
        type:'get',
        url: 'hotel/allguests/{id}',
        success: function(result) {
            guestDetail = result;
            fillGuest(guestDetail);
        }
    });
});

function fillGuest($guestDetail) {
    var content = '<input id="addGuest" type="button" value="Add guest"/>'
    content += '<table id = "allGuests" class="table table-bordered table-striped table-hover table-condensed">';
    content += '<thead id = tableHeader>';
    content += '<tr> <th> Guest number </th>';
    content += '<th> Name </th>';
    content += '<th> Birthday </th>';
    content += '<th> E-mail </th>';
    content += '<th> Nationality </th>';
    content += '</thead>';
    content += '<tbody id = "tablebody">';
    console.log($guests);

    $.each($guests, function (index, value) {
        content += "<tr>";
        console.log(value);
        content += "<td>" + value.guestId + "</td>";
        content += '<td>' + value.firstName + " " + value.lastName + '</td>';
        content += "<td>" + value.dateOfBirth + "</td>";
        content += "<td>" + value.email + "</td>";
        content += "<td>" + value.nationality + "</td>";

        content += "</tr>";
    });
    content += '</tbody> </table> <div class = "row"></div>';
    $("#allGuestsDiv").html(content);
    $('#allGuests').DataTable();
}