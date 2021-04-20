// Useful Functions
//document.getElementById();
//document.createElement();

//console.log('Hello World');
//window.alert('HALLOW WORLD');
//document.write('Written using document.write'); // Writes directly to the webpage
//console.warn('I wouldn't...'); // Adds a warning to the console
//console.error('You fucked up');// Adds an error to the console
// function messageFunc() {
//     console.log('This came from a function');
// }
// messageFunc();
// let message = 'This is a variable message';
// console.log (message);

// const people =[
//     'Shafiq',
//     'Martin',
//     'William',
//     'Dylan',
//     'Chris'
// ];
// // a space + ',' skips that element
// const[ ,one, ,two] = people;
// console.log('People: ' + one + ' and ' + two);

// const acc1 = {
//     id: 1,
//     name: 'Martin',
//     locale: 'Newcastle'
// }

// const acc2 = {
//     id: 2,
//     name: 'Dylan',
//     locale: 'Bolton'
// }

// const {name, ...rest} = acc1;
// const merged = {...acc1, ...acc2};
// console.log(merged);

// const ppl = [
//     'Martin',
//     'Shafiq'
// ]

// const ppl2 = [
//     'William',
//     'Dylan',
//     'Chris'
// ]

// const merged = {...ppl, ...ppl2};
// console.log(merged);

// function spreadArgs(arg1, ...restOfArgs) {
//     console.log(arg1, restOfArgs);
// }
// spreadArgs(1,2,3,'Four',5,6);

// function passObj({name}) {
//     console.log('My name is ' + name);
// }
// passObj({name:'Martin'});

// // swap variables
// let a = 'basketball';
// let b = 'spanner';
// [a,b] = [b,a];
// console.log(a, b);

// function handleClick(element) {
//     alert('WHY CLICK THIS?!');
//     //element.style.backgroundColor = 'black';
//     //element.innerText = '?!?!?!?!?!?!?!?!?!?!';
// }

const containerElement = document.getElementById('container');
const historyContainer = document.getElementById('history');

const newElement = document.createElement('h1');
newElement.id = 'number';
newElement.innerText = '0';
containerElement.append(newElement);

const historyHeader = document.createElement('h2');
historyHeader.innerText = 'History: ';
historyContainer.appendChild(historyHeader);

const newButton = document.createElement('button');
newButton.className = 'numButton';
newButton.innerText = '-10';
containerElement.append(newButton);
newButton.addEventListener('click', () => {
    subTen()
    counterHistory();
});

const newButton2 = document.createElement('button');
newButton2.className = 'numButton';
newButton2.innerText = '-1';
containerElement.append(newButton2);
newButton2.addEventListener('click', () => {
    decrement()
    counterHistory();
});

const newButton3 = document.createElement('button');
newButton3.className = 'numButton';
newButton3.innerText = 'Reset';
containerElement.append(newButton3);
newButton3.addEventListener('click', () => {
    reset()
    counterHistory();
});

const newButton4 = document.createElement('button');
newButton4.className = 'numButton';
newButton4.innerText = '+1';
containerElement.append(newButton4);
newButton4.addEventListener('click', () => {
    increment()
    counterHistory();
});

const newButton5 = document.createElement('button');
newButton5.className = 'numButton';
newButton5.innerText = '+10';
containerElement.append(newButton5);
newButton5.addEventListener('click', () => {
    addTen()
    counterHistory();
});

let counter = 0;
let lastCounter = 0;

function updateCounter() {
    newElement.innerText = counter;
    if (counter % 2 == 0) {
        document.getElementById('number').style.backgroundColor = 'green';
    } else {
        document.getElementById('number').style.backgroundColor = 'red';
    }
    if (counter > 100) {
        document.getElementById('number').innerText = counter + '!';
    }
}

function increment() {
    counter++;
    updateCounter();
}

function decrement() {
    counter--;
    updateCounter();
}

function addTen() {
    counter += 10;
    updateCounter();
}

function subTen() {
    counter -= 10;
    updateCounter();
}

function reset() {
    counter = 0;
    updateCounter();
}

function counterHistory() {
    let lastCounter = counter;
    const lastCount = document.createElement('button');
    lastCount.className = 'numButton';
    lastCount.innerText = lastCounter;
    historyContainer.append(lastCount);
    lastCount.addEventListener('click', () => {
        newElement.innerText = lastCounter;
    });
}

function handleEvent(element) {
    console.log('Password: ', element.value);
}

function handleFormSubmit(form) {
    console.log('Form submitted:');

    const formDataObj = {}; // Delcare an object

    // Loop through form elements and add them to object
    for (let element of form.elements) {
        console.log(element.value);
        if (element.id != '') {
            formDataObj[element.id] = element.value;
        }
    }
    console.log(formDataObj);

    // destructure form object
    const { firstName, lastName, dob: DOB, email } = formDataObj;

    console.log('Destructured form: ');
    console.log(firstName + ' ' + lastName);
    console.log(DOB);
    console.log(email);

    // // Destructuring using 'spread' operator
    // const{firstName, ...rest} = formDataObj;
    // console.log(firstName);
    // console.log('Rest: ', rest);

    alert('Success!: \n' +
        'Name: ' + firstName + ' ' + lastName + '\n' +
        'D.O.B: ' + DOB + '\n' +
        'Email: ' + email + '\n');

    return false;
}

function handleChange(form) {
    //console.log('change');
    const alert = document.getElementById('bs-alert');
    alert.innerText = 'Welcome back ' + form.value;
}

function handleClick() {
    document.cookie = 'name=Martin';
    localStorage.setItem('randomCrap', 'it\'s junk');
    localStorage.setItem('moreRandomCrap', 'it\'s still junk');
    sessionStorage.setItem('sessionCrap', 'it\s more junk');
    location.href = 'secondPage.html?name=martin&'; // add data into URL
}

function getArgs() {
    return arguments; // gets all args passed into function
}

function calculator(operator, num1, num2) {
    const add = () => num1 + num2; // lambda function
    const sub = () => num1 - num2;
    const multi = () => num1 * num2;
    const div = () => num1 / num2;

    if (operator == '+') {
        return add();
    } else if (operator == '-') {
        return sub();
    } else if (operator == '/') {
        return div();
    } else if (operator == '*') {
        return multi();
    } else {
        console.error('Invalid selection, try again');
    }
}

function multiply(a, b) {
    return a * b;
}

function multiplyPrint(a, b) {
    let result = multiply(a, b);
    console.log(result);
}

const multiplyPrint2 = (a, b) => {
    let result = multiplyPrint(a, b);
    console.log(result);
}

function multiplyAll() {
    arguments;
    let answer = 1;
    for (let i = 0; i < arguments.length; i++) {
        answer *= arguments[i];
    }
    console.log(answer);
}

let myArray = ['a', 'b', 'c'];

function printArray() {
    myArray.forEach((value, index, array) => {
        console.log('Value: ' + value + ' Index: ' + index + ' Array: ' + array);
    });
}
//printArray();

const animals = ['frog', 'llama', 'elephant', 'crocodile', 'hippopotamus',
    'aardvark', 'geoff', 'galapagos giant tortoise'];

let filteredAnimals = 'Animals: ' + animals.filter((value, index) => {
    if (value.length >= 9) { // filter out words that are 9 chars or longer
        return false;
    } else {
        return true;
    }
}).map((value, index, array) => {
    if (index < array.length - 1) {
        return value[0].toUpperCase() + value.substring(1) + ', ';
    } else {
        return value[0].toUpperCase() + value.substring(1) + '.';

    }
}).reduce((prev, current) => {
    return prev + current;
});

const betterFilteredAnimals = animals
    .filter(item => item.length < 9)
    .map(item => item[0].toUpperCase() + item.slice(1))
    .map((item, index) => index ? ', ' + item : item) // True: add comma. False: just add item
    .reduce((prev, current) => prev + current, 'Animals: ') // 'Animals: ' is the initial value of 'prev'
    .concat('.');

// console.log(filteredAnimals);
// console.log(betterFilteredAnimals);