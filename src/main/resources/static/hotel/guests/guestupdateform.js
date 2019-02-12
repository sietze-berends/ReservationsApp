$(document).ready(function () {

    var url_string = window.location.href
    var url = new URL(url_string);
    var guestId = url.searchParams.get("guestId")

    $('#guestId').val(guestId)

    console.log(guestId);

    $.ajax({
        type: 'get',
        url: 'hotel/allguests/' + guestId,
        success: function (result) {
            guest = result;
            console.log(guest);
            // fillGuestUpdate(guest);
        }
    });
});