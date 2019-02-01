$( document ).ready(function() {
    var $guests

    $.ajax({
       type:'get',
       url: '../hotel/guests',
       success: function(result) {
           $guests = result;
         $.each($guests, function (index, value) {
            $("#bookers").append('<option value = "' + value.firstName + ' ' + value.lastName + '">')
            console.log('<option value = "' + value.firstName + ' ' + value.lastName + '">')
         })
       }
    })

    var url_string = window.location.href
    var url = new URL(url_string);
    var rooms = url.searchParams.get("rooms")
    var start = url.searchParams.get("start")
    var end = url.searchParams.get("end")
    var guests = url.searchParams.get("guests")

    $('#rooms').val(rooms)
    $('#from').val(start)
    $('#to').val(end)
    $('#guests').val(guests)

    $('#add-reservation-from-search-form').submit(function(event) {
       var newReservationForm = $(this).serializeArray();
       var submitData = {}
       $(newReservationForm).each(function(i, field) {
            submitData[field.name] = field.value
       })
       submitData = JSON.stringify(submitData)
       $.post ( {
           url : '../hotel/reservations/add',
           data : submitData,
           contentType : 'application/JSON',
           success : function(response) {
               window.location.href('/hotel/reservations/reservations.html')
           }
       })
       window.location.href('/hotel/reservations/reservations.html')
    })
});
