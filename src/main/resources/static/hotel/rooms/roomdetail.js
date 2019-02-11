$(document).ready(function () {

    var url_string = window.location.href
    var url = new URL(url_string);
    var roomNr = url.searchParams.get("roomNr")

    $('#roomNr').val(roomNr)

    console.log(roomNr);

    $.ajax({
        type: 'get',
        url: 'hotel/allrooms/' + roomNr,
        success: function (result) {
            room = result;
            console.log(room);
            fillRoomDetail(room);
        }
    });
});

function fillRoomDetail($room) {
    var content = '<table id = "roomDetail" class="table table-bordered table-striped table-hover table-condensed">'
    content += '<thead id = "thead">'
    content += '<tr> <th> Room number </th>'
    content += '<th> Room type </th>'
    content += '<th> Room price </th>'
    content += '<th> Single beds </th>'
    content += '<th> Double beds </th>'
    content += '<th> Baby beds </th>'
    content += '<th> Capacity </th>'
    content += '<th> Clean </th>'
    content += '<th> Disabled-friendly</th>'
    content += '<th> Child-friendly</th>'
    content += '</thead>'
    content += '<tbody id = tableBody>'
    console.log($room);

    content += '<tr>';
    content += '<td>' + room.roomNr + '</td>';
    content += '<td>' + room.roomType + '</td>';
    content += '<td>' + room.price + '</td>';
    content += "<td>" + room.singleBeds + "</td>"
    content += "<td>" + room.doubleBeds + "</td>"
    content += "<td>" + room.babyBeds + "</td>"
    content += "<td>" + room.capacityRoom + "</td>"
    if (room.clean) {
                    content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
                    } else {
                    content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                    }
                if (room.disabledFriendly) {
                    content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
                } else {
                    content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                    }
                if (room.childFriendly) {
                    content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
                    } else {
                    content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                    }
                content += "</tr>";


    content += '</tbody> </table> <div class = "row"></div>';
    content += '<input id="updateRoom" type="button" value="Update room"/>';
    content += '<input id="deleteRoom" type="button" value="Delete room" onClick = deleteRoom(room.roomNr) />';
    $("#roomDetailDiv").html(content);

}

function deleteRoom(roomNr) {

    console.log("reaches delete");
    console.log(roomNr);
    var id = roomNr;
        jQuery.ajax({
            url: 'hotel/allrooms/' + id + '/delete',
            type: 'DELETE',
            success: function() {
                console.log("deleted!!!!")

                window.location.href = '/hotel/rooms/rooms.html'
            }
        });
        // build redirect link
};

