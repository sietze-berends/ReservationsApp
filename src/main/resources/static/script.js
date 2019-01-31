$( document ).ready(function() {
     // load the navbar
     $('#navbar').load('navbar.html')

     // some click events for buttons
     $('#goToHotel').click(function() {
        window.location.href = '/hotel.html';
        })
     $('#showAllRooms').click(function() {
        window.location.href = '/hotel/rooms/rooms.html'
     })
     $('#showAllGuests').click(function() {
             window.location.href = '/hotel/guests/guests.html'
     })
});


