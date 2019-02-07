// submit the form
$('#add-room').submit(function(event) {
   var newRoomForm = $(this).serializeArray();
   var newRoom = {};
   $(newRoomForm).each(function(i, field) {
       newRoom[field.name] = field.value
   })
   console.log(JSON.stringify*(newRoom))
   });

   $.post( {
       url : '/hotel/allrooms/add',
       data : JSON.stringify(newRoom),
       contentType: "application/json",
       success : function(result) {
           if(result.validated) {
               console.log("Room added")
               window.location.assign('hotel/rooms/rooms.html')
               }
           else {
               console.log("No room added")
               window.location.assign('hotel/rooms/rooms.html')
           }
       }
   })
   window.location.href = '/hotel/rooms/rooms.html'
}
