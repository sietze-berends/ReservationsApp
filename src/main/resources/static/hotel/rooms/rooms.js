$( document ).ready(function() {
    var rooms;
    $.ajax({
       type:'get',
       url: '../hotel/rooms',
       success: function(result) {
           rooms = result;
           fillRooms(rooms);
           }
       })
    });

     function fillRooms($rooms) {
        var content = '<input id="addRoom" type="button" value="Add room"/>'
        content += '<table id = "allRooms" class="table table-bordered table-striped table-hover table-condensed">'
        content += '<thead id = "thead">'
        content += '<tr> <th> Room number </th>'
        content += '<th> Single beds </th>'
        content += '<th> Double beds </th>'
        content += '<th> Baby beds </th>'
        content += '<th> Capacity </th>'
        content += '<th> Clean </th>'
        content += '<th> Disabled-friendly</th>'
        content += '</thead>'
        content += '<tbody id = tableBody>'

        $.each($rooms, function (index, value) {
            content += "<tr>"
            content += '<td>' + value.roomId + '</td>';
            content += "<td>" + value.singleBeds + "</td>"
            content += "<td>" + value.doubleBeds + "</td>"
            content += "<td>" + value.babyBeds + "</td>"
            content += "<td>" + value.capacityRoom + "</td>"

            if (value.clean) {
                content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
                } else {
                content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                }
            if (value.roomAttributes[0].roomAttributeId == "Disabled") {
                content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
            } else {
                content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                }
            content += "</tr>";
        })
        content += '</tbody> </table> <div class = "row"></div>'
        $("#allRoomsDiv").html(content)
        $('#allRooms').DataTable();
     }