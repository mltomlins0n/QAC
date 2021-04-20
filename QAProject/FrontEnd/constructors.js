makeRequest("GET", teamURL)
    .then((data) => {
        console.log("Response from API: ", data);
        generateTableContent(teamTable, data);
        generateTable(teamTable, data);
        sortTable(teamTable);
    });