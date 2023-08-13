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
            alert(data);
        },
        error: function (request, status, error) {
            alert('error ' + request + ' ' + status + ' ' + error);
        }
    });
}

function receiveMessage() {

}