    // submit the form
    $('#searchform').submit(function(event) {
       var newSearchForm = $(this).serializeArray();
       var submitData = {}

       $(newSearchForm).each(function(i, field) {
           console.log(field.name)
           if(field.name == "start") {
               submitData[field.name] = field.value.toString();
           } else if (field.name == "end") {
               submitData[field.name] = field.value.toString();
               }
             else {
               submitData[field.name] = field.value;
             }
           })
        submitData = JSON.stringify(submitData)
       $.post( {
           url : '/hotel/search',
           data : submitData,
           contentType : "application/JSON",
           success : function(result) {
               showResults(result)
           }
       })
       event.preventDefault();
    })

    function showResults($results) {
       var content = '<table id = "searchResults" class="table table-bordered table-striped table-hover table-condensed">'
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

            $.each($results, function (index, value) {
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
            $("#search").html(content)
            $('#searchResults').DataTable();

    }