document.addEventListener('DOMContentLoaded', function () {
    var welcomeMessage = document.getElementById('welcomeMessage');

    // Check if the user is logged in
    fetch('main', { method: 'GET', credentials: 'same-origin' })
        .then(function (response) {
            if (response.status === 200) {
                return response.text();
            } else {
                window.location.href = 'login.html';
            }
        })
        .then(function (data) {
            welcomeMessage.innerText = data;
        });
});
