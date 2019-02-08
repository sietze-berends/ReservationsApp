$( document ).ready(function() {
    $('#add-reservation-from-search-form').submit(function(event) {
           var newReservationForm = $(this).serializeArray();
           var submitData = {}
           $(newReservationForm).each(function(i, field) {
                submitData[field.name] = field.value
           }
    }

});