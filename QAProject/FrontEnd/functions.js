// generate table structure and headers
function generateTable(table, data) {
    let tableHeaders = Object.keys(data[0]);
    // thead defined in html, so just return it
    tHead = table.createTHead();
    let row = tHead.insertRow();
    for (let key of tableHeaders) {
        // Excludes ID field from table
        //if (!(key.match("id"))) {
        let th = document.createElement("th");
        let thValue = document.createTextNode(key.toUpperCase());
        th.appendChild(thValue);
        row.appendChild(th);
        //}
    }
}

// Populate table from API
function generateTableContent(table, data) {
    for (let element of data) {
        let row = table.insertRow();
        for (let key in element) {
            // Excludes ID field from table
            //if (!(key.match("id"))) {
            let cell = row.insertCell();
            let cellText = document.createTextNode(element[key]);
            let tagName = document.createAttribute("name");
            tagName.value = key;
            cell.setAttributeNode(tagName);
            cell.appendChild(cellText);
            //}
        }
    }
}

// Sort data by points in descending order
function sortTable(table) {
    let rows, switching, i, thisRow, nextRow, shoudldSwitch;
    switching = true;
    // Loop until all switching is done
    while (switching) {
        switching = false;
        rows = table.rows;

        for (i = 1; i < rows.length - 1; i++) {
            shoudldSwitch = false;

            // Get the current row and the next row
            // Specifiy the tag name to sort by
            thisRow = rows[i].getElementsByTagName("TD")["points"];
            nextRow = rows[i + 1].getElementsByTagName("TD")["points"];

            // A lower points value should switch (go below) a higher one
            if (Number(thisRow.innerHTML) < Number(nextRow.innerHTML)) {
                shoudldSwitch = true;
                break;
            }
        }
        if (shoudldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}

function addDriver(form) {
    console.log("Form: " + JSON.stringify(form));
    let formObject = {};
    for (let element of form.elements) {
        if (element.value) {
            formObject[element.id] = element.value;
        }
    }
    JSON.stringify(formObject);
    console.log("Form object sent: ", formObject);
    makeRequest("POST", driverURL, formObject);
    window.location.reload(true);
}

function updateDriver(form) {
    let formObject = {};
    let updateID = 0;
    for (let element of form.elements) {
        if (element.value) {
            if (element.id === "id") {
                updateID = element.value;
                console.log("Update ID: ", updateID);
            } else {
                formObject[element.id] = element.value;
            }
        }
    }
    // console.log("Form object sent: ", formObject);
    // console.log(`${driverURL}/${updateID}`);
    JSON.stringify(formObject);
    makeRequest("POST", `${driverURL}/${updateID}`, formObject);
    window.location.reload(true);
}

function deleteDriver(id) {
    makeRequest("DELETE", `${driverURL}/${id.value}`);
    window.location.reload(true);
}

function addTeam(form) {
    console.log("Form: ", JSON.stringify(form));
    let formObject = {};
    for (let element of form.elements) {
        if (element.value) {
            formObject[element.id] = element.value;
        }
    }
    JSON.stringify(formObject);
    console.log(formObject);
    makeRequest("POST", teamURL, formObject);
    window.location.reload(true);
}

function updateTeam(form) {
    let formObject = {};
    let updateID = 0;
    for (let element of form.elements) {
        if (element.id === "id") {
            updateID = element.value;
            console.log("Update ID: ", updateID);
        }
        else if (element.value) {
            formObject[element.id] = element.value;
        }
    }
    // console.log("Form object sent: ", formObject);
    // console.log(`${teamURL}/${updateID}`);
    JSON.stringify(formObject);
    makeRequest("POST", `${teamURL}/${updateID}`, formObject);
    window.location.reload(true);
}

function deleteTeam(id) {
    makeRequest("DELETE", `${teamURL}/${id.value}`);
    window.location.reload(true);
}