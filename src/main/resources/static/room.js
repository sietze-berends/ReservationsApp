     $('#showAllRooms').click(function() {
        var rooms;
        $.ajax({
           type:'get',
           url: 'hotel/rooms',
           success: function(result) {
               $('#showAllRooms').hide();
               $('#showAllGuests').hide();
               rooms = result;
               fillRooms(rooms);
           }
        })
     })

     function fillRooms($rooms) {
        var content = '<h2> Rooms: </h2> <div class = "row"></div>'
        content += '<table id = "roomsTable" class="table table-bordered table-striped table-hover table-condensed">'
        content += '<tbody id = tableBody>'
        content += '<tr> <th> Room number </th>'
        content += '<th> Single beds </th>'
        content += '<th> Double beds </th>'
        content += '<th> Baby beds </th>'
        content += '<th> Capacity </th>'
        content += '<th> Clean </th>'
        content += '<th> Disabled-friendly</th>'

        $.each($rooms, function (index, value) {
            content += "<tr>"
            content += '<td>' + value.roomId + '</td>';
            content += "<td>" + value.singleBeds + "</td>"
            content += "<td>" + value.doubleBeds + "</td>"
            content += "<td>" + value.babyBeds + "</td>"
            content += "<td>" + value.capacityRoom + "</td>"
            console.log("Room: " + value.roomId)
            if (value.clean) {
                content += '<td> Yes </td>'
                } else {
                content += '<td> No </td>'
                }
            if (value.roomAttributes[0].roomAttributeId == "Disabled") {
                content += '<td> Yes </td>'
            } else {
                content += '<td> No </td>'
                }
            content += "</tr>";
        })
        content += '</tbody> </table> <div class = "row"></div>'
        $("#roomInfo").html(content)
     }