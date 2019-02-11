var $submitData = {}

// submit the form
$('#searchform').submit(function (event) {
    var newSearchForm = $(this).serializeArray();
//       var submitData = {}

    $(newSearchForm).each(function (i, field) {
        if (field.name == "start") {
            $submitData[field.name] = field.value.toString();
        } else if (field.name == "end") {
            $submitData[field.name] = field.value.toString();
        } else {
            $submitData[field.name] = field.value;
        }
    })
    $submitData = JSON.stringify($submitData)
    $.post({
        url: '/hotel/search',
        data: $submitData,
        contentType: "application/JSON",
        success: function (result) {
            showResults(result)
        }
    })
    event.preventDefault()
    return false;
})

function showResults($results) {



    var content = '<table id = "searchResults" name = "Suggestion" class="table table-bordered table-striped table-hover table-condensed compact wrap">'
    content += '<thead id = "thead">'
    content += '<tr> <th> Room number </th>'
    content += '<th> Price </th>'
    content += '<th> Single beds </th>'
    content += '<th> Double beds </th>'
    content += '<th> Baby beds </th>'
    content += '<th> Capacity </th>'
    content += '<th> Clean </th>'
    content += '<th> Disabled-friendly</th>'
    content += '<th> Child-friendly</th>'
    content += '</thead>'
    content += '<tbody id = tableBody>'

    $.each($results, function (index, value) {
        content += "<tr id = row " + index + ">"
        content += '<td id = roomId>' + value.roomNr + '</td>'
        content += '<td id = price> &yen ' + value.price + '</td>'
        content += "<td>" + value.singleBeds + "</td>"
        content += "<td>" + value.doubleBeds + "</td>"
        content += "<td>" + value.babyBeds + "</td>"
        content += "<td>" + value.capacityRoom + "</td>"

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

    content += '</tbody> </table> <br> <input id="bookNow" type="button" value="Book now!"/>'
    content += '<div class = "row"></div>'
    $("#search").html(content)
    $('#searchResults').DataTable();
}

// open form
$(document).on('click', '#bookNow', function () {
    var dataRooms = []
    var rooms = $('#searchResults > tbody > tr > #roomId')

    $.each(rooms, function (index, value) {
        dataRooms[index] = value.textContent
    })
    dataStart = JSON.parse($submitData).start
    dataEnd = JSON.parse($submitData).end
    dataGuests = JSON.parse($submitData).amountOfPersons
    dataRooms = dataRooms.toString()
    window.location.href = '/hotel/reservations/addreservationfromsearch.html?rooms=' + encodeURIComponent(dataRooms) + '&start=' + encodeURIComponent(dataStart) + '&end=' + encodeURIComponent(dataEnd) + '&guests=' + encodeURIComponent(dataGuests)
});
