function goToNextPage() {
    const username = document.getElementById('username').value;
    if (username) {
        document.cookie = `username=${encodeURIComponent(username)};path=/;`;
        window.location.href = 'http://localhost:8080/reservation';
    } else {
        alert('Please enter your username.');
    }
}