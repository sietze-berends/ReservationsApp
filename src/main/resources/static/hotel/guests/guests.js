$( document ).ready(function() {
    console.log("ready");
    var guests;
    $.ajax({
        type:'get',
        url: 'hotel/allguests',
        success: function(result) {
            guests = result;
            fillGuests(guests);
        }
    });

    // open form
    $(document).on('click', '#addGuest', function(){
        window.location.href = '/hotel/guests/addguest.html';
    });
});

function fillGuests($guests) {
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
                 content += "<tr id = 'guestRow'>";
                 console.log(value);
                 content += "<td style='cursor: pointer;' id='guestId' onClick = showSingleGuest()>" + value.guestId + "</td>";
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

function showSingleGuest(){
    var tbl = document.getElementById("allGuests");

    if (tbl != null) {
        for (var i = 0; i < tbl.rows.length; i++) {
            for (var j = 0; j < tbl.rows[i].cells.length; j++)
                tbl.rows[i].cells[j].onclick = function () { getval(this); };
        }
    }

    function getval(cel) {
        var guestId = cel.innerHTML;
        // window.location.href = '/hotel/allguests/' + (cel.innerHTML);
        window.location.href = '/hotel/guests/guestdetail.html?guestId=' + encodeURIComponent(guestId);

    }



}


