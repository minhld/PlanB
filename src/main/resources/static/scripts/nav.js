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
    $.post('/api/sendMessage', {
            'message': 'a hello message'
        },
        function (data, status) {
            alert('hi ' + data);
        }
    );
}

function receiveMessage() {

}