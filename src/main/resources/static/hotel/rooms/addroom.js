// submit the form
$('#add-room-form').submit(function(event) {
   var newRoomForm = $(this).serializeArray();
   var newRoom = {}

   $(newRoomForm).each(function(i, field) {
       newRoom[field.name] = field.value
   })
    console.log(newRoom)
   $.post( {
       url : '/hotel/room/add',
       data : newRoom,
       succes : function(result) {
           if(result.validated) {
               console.log("Room added")
               }
           else {
               console.log("No room added")
           }
       }
   })
   event.preventDefault();
})