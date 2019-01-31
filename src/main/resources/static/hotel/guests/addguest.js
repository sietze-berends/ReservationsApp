    // submit the form
    $('#add-guest-form').submit(function(event) {
       var newGuestForm = $(this).serializeArray();
       var newGuest = {}

       $(newGuestForm).each(function(i, field) {
           if (field.name == "dateOfBirth") {
                   newGuest[field.name] = field.value.toString()
               } else {
                   newGuest[field.name] = field.value
               }
       })
       newGuest = JSON.stringify(newGuest)
       console.log(newGuest)
       $.post( {
           url : '/hotel/guests/add ',
           data : newGuest,
           contentType : "application/JSON",
           success : function(result) {
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