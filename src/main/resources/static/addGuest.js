    // open form
    $(document).on('click', '#addGuest', function(){
        console.log("test")
        window.location.href = '/addguest.html';
    });

    // submit the form
    $('#add-guest-form').submit(function(event) {
       var newGuestForm = $(this).serializeArray();
       var newGuest = {}

       $(newGuestForm).each(function(i, field) {
           if (field.name == "dob") {
                   newGuest[field.name] = field.value.toString()
               } else {
                   newGuest[field.name] = field.value
               }
       })
       newGuest = JSON.stringify(newGuest)
       console.log(newGuest)
       $.post( {
           url : '/hotel/guests/add',
           data : newGuest,
           contentType : "application/JSON",
           succes : function(result) {
               if(result.validated) {
                   console.log("Guest added")
                   }
               else {
                   console.log("No guest added")
               }
           }
       })
       event.preventDefault();
    })