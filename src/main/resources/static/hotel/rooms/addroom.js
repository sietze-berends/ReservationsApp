// submit the form
$('#add-room').submit(function(event) {
   var newRoomForm = $(this).serializeArray();
   var newRoom = {}
   $(newRoomForm).each(function(i, field) {
       if(field.name == "roomAttributes") {
           newRoomAttribute = JSON.parse(field.value)
           newRoom[field.name] = newRoomAttribute
       } else {
       newRoom[field.name] = field.value
       }
   })
   $.post( {
       url : '/hotel/allrooms/add',
       data : JSON.stringify(newRoom),
       contentType: "application/json",
       succes : function(result) {
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
   window.location.href = '/hotel/rooms/addroom.html';
})