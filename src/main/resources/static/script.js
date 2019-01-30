$( document ).ready(function() {

     $('#goToHotel').click(function() {
        window.location.href = '/hotel.html';
        })

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

      $('#showAllGuests').click(function() {
         var guests;
         $.ajax({
            type:'get',
            url: 'hotel/guests',
            success: function(result) {
                $('#showAllRooms').hide();
                $('#showAllGuests').hide();
                guests = result;
                fillGuests(guests);
            }
         })
      })

     function fillGuests($guests) {
             var content = '<h2> Guests: </h2> <div class = "row"></div>'
             content += '<table id = "guestsTable" class="table table-bordered table-striped table-hover table-condensed">'
             content += '<tbody id = tableBody>'
             content += '<tr> <th> Guest number </th>'
             content += '<th> Name </th>'
             content += '<th> Birthday </th>'
             content += '<th> E-mail </th>'
             content += '<th> Nationality </th>'

             $.each($guests, function (index, value) {
                 content += "<tr>"
                 content += "<td>" + value.guestId + "</td>"
                 content += '<td>' + value.firstName + " " + value.lastName + '</td>';
                 content += "<td>" + value.dateOfBirth + "</td>"
                 content += "<td>" + value.email + "</td>"
                 content += "<td>" + value.nationality + "</td>"

                 content += "</tr>";
             })
             content += '</tbody> </table> <div class = "row"></div>'
             $("#guestInfo").html(content)
          }

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

        $.each($rooms, function (index, value) {
            content += "<tr>"
            content += '<td>' + value.roomId + '</td>';
            content += "<td>" + value.singleBeds + "</td>"
            content += "<td>" + value.doubleBeds + "</td>"
            content += "<td>" + value.babyBeds + "</td>"
            content += "<td>" + value.capacityRoom + "</td>"
            if (value.clean) {
                content += '<td> <span class="glyphicon glyphicon-ok"></span></td>'
                }
            content += "</tr>";
        })
        content += '</tbody> </table> <div class = "row"></div>'
        $("#roomInfo").html(content)
     }

     function getRoomForm($room) {
        alert(room)
        }

     $('#roomsInfo #tableBody').on('click', 'tr', function() {
        var $item = $(this).closest("tr")
        console.log($item)
        getRoom(this.roomId)
        })

     function getRoom($roomNumber) {
        $.ajax({
            type:'get',
            url:'hotel/room/' + $roomNumber,
            succes: function(result) {
                console.log(result)
                room = result;
                getRoomForm(room);
            }
        })
     }
});