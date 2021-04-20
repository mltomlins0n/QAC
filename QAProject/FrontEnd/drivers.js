makeRequest("GET", driverURL)
    .then(data => {
        console.log("Response from API: ", data);
        generateTableContent(driverTable, data);
        generateTable(driverTable, data);
        sortTable(driverTable);
    });