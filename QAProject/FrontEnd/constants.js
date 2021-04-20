const API_PORT = 9000;
const driverURL = `http://35.228.126.86:${API_PORT}/drivers`;
const teamURL = `http://35.228.126.86:${API_PORT}/teams`;
const driverTable = document.getElementById("driverTable");
const teamTable = document.getElementById("teamTable");

function makeRequest(requestType, url, objToSend) {
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.onload = () => {
            if (xhr.status >= 200 || xhr.status <= 299) {
                const data = JSON.parse(xhr.response); // convert response to an object
                resolve(data);
            } else {
                reject("Request failed" + reason);
            }
        };
        xhr.open(requestType, url);
        if (requestType === "POST" || requestType === "PUT" ||
            requestType === "DELETE") {
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(JSON.stringify(objToSend));
            console.log("Data sent: ", objToSend);
        } else {
            xhr.send();
        }
    });
}