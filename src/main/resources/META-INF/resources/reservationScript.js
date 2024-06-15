function loadTables() {
    const tableSelect = document.getElementById('tableNumber');
    tableSelect.innerHTML = ''; // clear current option
    const restaurantSelect = document.getElementById('restaurant');
    const restaurantId = restaurantSelect.value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    if (restaurantId && date && time) {
        const url = `/reservation/${restaurantId}?date=${encodeURIComponent(date)}&time=${encodeURIComponent(time)}`;
        fetch(url)
            .then(response => response.json())
            .then(AvailableTablesResponse => {
                // console.log("NOT: " + number_of_tables);
                for (let i = 1; i <= AvailableTablesResponse.availableTables; i++) {
                    const option = document.createElement('option');
                    option.value = i;
                    option.textContent = 'Table ' + i;
                    tableSelect.appendChild(option);
                }
            })
            .catch(error => console.error('Error:', error));
    }
}

async function reserveTable() {
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const username = getCookie('username');
    const restaurantId = document.getElementById('restaurant').value;
    const tableId = document.getElementById('tableNumber').value;

    const reservationData = {
        restaurantTable: { id: tableId },
        restaurantUser: { username: username },
        date: date,
        time: time
    };
    console.log('Reservation data:', reservationData);

    try {
        const response = await fetch('/reservation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reservationData)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const responseData = await response.json();
        console.log('Reservation created:', responseData);
        alert('Reserved table ' + tableId + ' in restaurant ID ' + restaurantId + ' on ' + date + ' at ' + time + ' for user ' + username + '.');

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
        alert('Error creating reservation: ' + error.message);
    }

}
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

function changeUser(){
    window.location.href = 'http://localhost:8080/';
}

/////////////////
//    MAIN
/////////////////
document.getElementById('restaurant').addEventListener('change', loadTables);
document.getElementById('date').addEventListener('change', loadTables);
document.getElementById('time').addEventListener('change', loadTables);
if (!getCookie('username')){
    window.location.href = 'http://localhost:8080/';
}
document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('currentUsername').textContent = getCookie('username');
});