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

function reserveTable() {
    const restaurant = document.getElementById('restaurant').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const table = document.getElementById('tableNumber').value;
    const username = getCookie('username');

    alert('Reserved table ' + table + ' in restaurant ID ' + restaurant + ' on ' + date + ' at ' + time);
}
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}


/////////////////
//    MAIN
/////////////////
document.getElementById('restaurant').addEventListener('change', loadTables);
document.getElementById('date').addEventListener('change', loadTables);
document.getElementById('time').addEventListener('change', loadTables);


// Load tables on first load
// window.onload = loadTables;