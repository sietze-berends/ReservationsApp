// submit the form
$('#add-room').submit(function() {
   var newRoomForm = $(this).serializeArray();
   var newRoom = {};
   $(newRoomForm).each(function(i, field) {
       newRoom[field.name] = field.value
   })
   $.post( {
       url : '/hotel/allrooms/add',
       data : JSON.stringify(newRoom),
       contentType : "application/json",
    })
    window.location.href = 'hotel/rooms/rooms.html'
    return false
});