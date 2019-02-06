    // submit the form
    $("#confirmNewGuest").click(function() {
       var newGuestForm = $(this).serializeArray();
       var newGuest = {}

       $(newGuestForm).each(function(i, field) {
           if (field.name == "dateOfBirth") {
                   newGuest[field.name] = field.value.toString()
               } else {
                   newGuest[field.name] = field.value
               }
       });

       newGuest = JSON.stringify(newGuest);
       console.log(newGuest);
       $( "#add-guest" ).submit();

       $.post( {
           url : '/hotel/allguests/add',
           data : JSON.stringify(newGuest),
           contentType : "application/json",
           success : function(result) {
               if(result.validated) {
                   console.log("Guest added")
                   }
               else {
                   console.log("No guest added")
               }
           }
       });

    });