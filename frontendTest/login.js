function handleClick() {
    location.href = 'register.html';
}

function handleFormSubmit(form) {
    console.log('Logging in:');

    const formDataObj = {}; // Delcare an object

    // Loop through form elements and add them to object
    for (let element of form.elements) {
        if (element.id != '' || element.value != '') {
            formDataObj[element.id] = element.value;
        }
    }

    console.log(formDataObj);

    const xhr = new XMLHttpRequest();
    xhr.onload = () => {
        if (xhr.status >= 200 && xhr.status <= 299) {
            console.log('Response: ' + xhr.response);
            console.log('Logged in');
            location.href = 'user.html';
        } else {
            console.log('Request failed: ' + xhr.response);
        }
    }
    xhr.open('GET', `https://us-central1-qac-sandbox-c347f.cloudfunctions.net/login?username=${formDataObj.username}&password=${formDataObj.password}`);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(formDataObj);

    // // Destructuring using 'spread' operator
    // const{firstName, ...rest} = formDataObj;
    // console.log(firstName);
    // console.log('Rest: ', rest);

    return false;
}