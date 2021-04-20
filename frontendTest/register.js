function handleClick(button) {
    location.href = 'login.html';
}

function handleFormSubmit(form) {
    console.log('Form submitted:');

    const formDataObj = {}; // Delcare an object

    // Loop through form elements and add them to object
    for (let element of form.elements) {
        if (element.id != '' || element.value != '') {
            formDataObj[element.id] = element.value;
        }
    }

    const xhr = new XMLHttpRequest();
    xhr.onload = () => {
        if (xhr.status >= 200 && xhr.status <= 299) {
            console.log('Response: ' + xhr.response);
        } else {
            console.log('Request failed: ' + xhr.response);
        }

    }
    xhr.open('POST', 'https://us-central1-qac-sandbox-c347f.cloudfunctions.net/setUser');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(formDataObj));

    console.log(formDataObj);

    // destructure form object
    const { username, password, firstName, lastName, email } = formDataObj;

    console.log('Destructured form: ');
    console.log(firstName + ' ' + lastName);
    console.log(email);
    console.log(username);
    console.log(password);

    alert('Success!: \n' +
        'Username: ' + username + '\n' +
        'Email: ' + email + '\n');

    // // Destructuring using 'spread' operator
    // const{firstName, ...rest} = formDataObj;
    // console.log(firstName);
    // console.log('Rest: ', rest);

    return false;
}