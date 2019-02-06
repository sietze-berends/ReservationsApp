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
   console.log(newRoom)
//   event.preventDefault()
//   console.log(JSON.stringify(newRoom))
//   $.post( {
//       url : '/hotel/allrooms/add',
//       data : JSON.stringify(newRoom),
//       contentType: "application/json",
//       succes : function(result) {
//           if(result.validated) {
//               console.log("Room added")
//               }
//           else {
//               console.log("No room added")
//           }
//       }
//   })
})