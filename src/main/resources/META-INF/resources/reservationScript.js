function loadTables() {
    const tableSelect = document.getElementById('tableNumber');
    tableSelect.innerHTML = ''; // clear current option
    const restaurantSelect = document.getElementById('restaurant');
    const restaurantId = restaurantSelect.value;
    const url = "http://localhost:8080/reservation/" + restaurantId;
    fetch(url)
        .then(response => response.json())
        .then(restaurant => {
            for (let i = 1; i <= restaurant.number_of_tables; i++) {
                const option = document.createElement('option');
                option.value = i;
                option.textContent = 'Table ' + i;
                tableSelect.appendChild(option);
            }
        })
        .catch(error => console.error('Error:', error));


    // Assuming each restaurant has 10 tables for example purposes

}

function reserveTable() {
    const restaurant = document.getElementById('restaurant').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const table = document.getElementById('tableNumber').value;
    alert('Reserved table ' + table + ' in restaurant ID ' + restaurant + ' on ' + date + ' at ' + time);
}

/////////////////
//    MAIN
/////////////////
document.getElementById('restaurant').addEventListener('change', loadTables);
document.getElementById('date').addEventListener('change', loadTables);


// Load tables on first load
window.onload = loadTables;