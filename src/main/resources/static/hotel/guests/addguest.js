// submit the form
$("#add-guest").submit(function () {
    var newGuestForm = $(this).serializeArray();
    var newGuest = {}
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
    $.post( {
        url : "/hotel/allguests/add",
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


// $(document).ready(function(){
//     // click on button submit
//     $("#submit").on('click', function(){
//         // send ajax
//         $.ajax({
//             url: '/hotel/allguests/add', // url where to submit the request
//             type : "POST", // type of action POST || GET
//             dataType : 'json', // data type
//             data : $("#add-guest").serialize(), // post data || get data
//             success : function(result) {
//                 // you can see the result from the console
//                 // tab of the developer tools
//                 console.log(result);
//             },
//             error: function(xhr, resp, text) {
//                 console.log(xhr, resp, text);
//             }
//         })
//     });
// });