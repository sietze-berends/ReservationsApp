$( document ).ready(function() {
    var $guests

    $.ajax({
       type:'get',
       url: '../hotel/allguests',
       success: function(result) {
           $guests = result;
         $.each($guests, function (index, value) {
            $("#bookers").append('<option value = "' + value.firstName + ' ' + value.lastName + ' - ' + value.email + '">')
         })
       }
    })

    $('#add-reservation-from-search-form').submit(function(event) {
           var newReservationForm = $(this).serializeArray();
           var submitData = {}
           $(newReservationForm).each(function(i, field) {
                submitData[field.name] = field.value
           })
            console.log(submitData)
        $.ajax({
            type:'post',
            url: '../hotel/allreservations/add',
            data : JSON.stringify(submitData),
            contentType : "application/json"
            })
        window.location.href = 'hotel/reservations/reservations.html'
        return false
        })
});