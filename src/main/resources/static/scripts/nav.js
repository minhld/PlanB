function goHome() {
    window.location.href = 'main';
}

function goRN() {
    window.location.href = 'rn';
}

function goDB() {
    window.location.href = 'db';
}

function sendMessage() {
    var msg = $('#kafkaMessage').val();
    $.ajax({
        type: "post",
        url: "/api/sendMessage",
        data: JSON.stringify({
            message: msg
        }),
        headers: {
            'Content-Type': 'application/json'
        },
        success: function (data) {
            console.log(JSON.stringify(data));
        },
        error: function (request, status, error) {
            console.error(status + ': ' + request.responseJSON.message);
        }
    });
}

function receiveMessage() {

}