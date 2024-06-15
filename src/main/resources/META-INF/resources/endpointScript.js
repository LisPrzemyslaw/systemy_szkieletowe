async function goToNextPage() {
    const username = document.getElementById('username').value;
    if (username) {
        document.cookie = `username=${encodeURIComponent(username)};path=/;`;
        const userData = {
            username: username
        };
        try {
            const response = await fetch('/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userData)
            });
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }

            const responseData = await response.json();
            window.location.href = 'http://localhost:8080/reservation';


        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
            alert('Error creating user: ' + error.message);
        }
    } else {
        alert('Please enter your username.');
    }
}