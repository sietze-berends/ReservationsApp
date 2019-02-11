// als het document geladen is
$( document ).ready(function() {
    var rooms;
    //
    $.ajax({
       type:'get',
       url: 'hotel/allrooms',
       success: function(result) {
           rooms = result;
           fillRooms(rooms);
           }
       })

        // open form
        $(document).on('click', '#addRoom', function(){
            window.location.href = '/hotel/rooms/addroom.html';
        });
    });

     function fillRooms($rooms) {
        var content = '<input id="addRoom" type="button" value="Add room"/>'
        content += '<table id = "allRooms" class="table table-bordered table-striped table-hover table-condensed">'
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
        content += '<th> Available today </th>'
        content += '</thead>'
        content += '<tbody id = tableBody>'
        $.each($rooms, function (index, value) {
            content += "<tr>"
            content += "<td style='cursor: pointer;' id='roomId' onClick = showSingleRoom()>" + value.roomNr + "</td>";
            content += '<td>' + value.roomType + '</td>';
            content += '<td> &yen ' + value.price + '</td>';
            content += "<td>" + value.singleBeds + "</td>"
            content += "<td>" + value.doubleBeds + "</td>"
            content += "<td>" + value.babyBeds + "</td>"
            content += "<td>" + value.capacityRoom + "</td>"
            content += "<td id = 'availableToday'></td>

            if (value.clean) {
                content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
                } else {
                content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                }
            if (value.disabledFriendly) {
                content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
            } else {
                content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                }
            if (value.childFriendly) {
                content += '<td data-sort="1"> <span class="glyphicon glyphicon-ok"></span> </td>'
                } else {
                content += '<td data-sort="2"> <span class="glyphicon glyphicon-remove"></span> </td>'
                }
            content += "</tr>";
        })
        content += '</tbody> </table> <div class = "row"></div>'
        $('#allRoomsDiv').html(content)
        $('#allRooms').DataTable();
        fillAvailability()
     }

     function showSingleRoom(){
     console.log('showSingleRoom')
         var tbl = document.getElementById("allRooms");

         if (tbl != null) {
             for (var i = 0; i < tbl.rows.length; i++) {
                 for (var j = 0; j < tbl.rows[i].cells.length; j++)
                     tbl.rows[i].cells[j].onclick = function () { getval(this); };
             }
         }

         function getval(cel) {
             var roomNr = cel.innerHTML;
             // window.location.href = '/hotel/allguests/' + (cel.innerHTML);
             window.location.href = '/hotel/rooms/roomdetail.html?roomNr=' + encodeURIComponent(roomNr);

         }



     }