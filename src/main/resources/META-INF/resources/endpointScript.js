function goToNextPage() {
    const username = document.getElementById('username').value;
    if (username) {
        alert("Good username: " + username);
    } else {
        alert('Please enter your username.');
    }
}