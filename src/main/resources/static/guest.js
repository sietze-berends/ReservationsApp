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