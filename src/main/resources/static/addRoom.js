$('#addRoom').click(function() {
     // form to add room
     window.location.href = '/addRoom.html';
     })

// open form    
$(document).on('click', '#addRoom', function()){
    console.log("test")
    window.location.href = '/addRoom.html';
};

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