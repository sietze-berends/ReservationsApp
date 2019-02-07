// submit the form
$("#add-guest").submit(function () {

    var newGuestForm = $(this).serializeArray();
    var newGuest = {};
    console.log(newGuestForm);
    event.preventDefault();
    $(newGuestForm).each(function(i, field) {
        if (field.name == "dateOfBirth") {
                newGuest[field.name] = field.value.toString()
            } else {
                newGuest[field.name] = field.value
            }
    });

    console.log(newGuest);
    $.ajax({
        type: "POST",
        url : "hotel/allguests/add",
        data : JSON.stringify(newGuest),
        contentType: "application/json; charset=utf-8", // this
        dataType: "json", // and this
        success : function(result) {
            if(result.validated) {
                console.log("Guest added")
            }
            else {
                console.log("No guest added")
            }
        }
    });
    window.location.href = '/hotel/guests/guests.html';
});