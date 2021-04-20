function makeRequest() {
    return new Promise((resolve, reject) => {
    const xhr = new XMLHttpRequest();
    xhr.onload = () => {
        if (xhr.status == 200) {
            const data = JSON.parse(xhr.response); // convert response to an object
            resolve(data);
        } else {
            reject('Request failed');
        }
    };
    xhr.open('GET', 'https://raw.githubusercontent.com/ewomackQA/JSONDataRepo/master/example.json');
    xhr.send();
    });
}
makeRequest()
    .then(data => {
        console.log('This is the response', data);
        // destruct object
        const{squadName, homeTown, formed, secretBase, members} = data;

        function createHeader() {
        const heading = document.getElementById('heading');
        const newElement = document.createElement('h1');
        newElement.id = 'squadName';
        newElement.innerText = squadName;
        heading.append(newElement);
    }
    
    function createDetailsSection() {
        const details = document.getElementById('details');
    
        const detailsHeading = document.createElement('h2');
        detailsHeading.id = 'detailsHeading';
        detailsHeading.innerText = 'Details';
        details.append(detailsHeading);
    
        const dateFormed = document.createElement('p');
        dateFormed.innerText = 'Formed: ' + formed;
        details.appendChild(dateFormed);
    
        const home = document.createElement('p');
        home.innerText = '| Hometown: ' + homeTown;
        details.append(home);
    
        const base = document.createElement('p');
        base.innerText = '| Secret base: ' + secretBase;
        details.append(base);
    
        const membersHeading = document.createElement('h3');
        membersHeading.id = 'membersHeading';
        membersHeading.innerText = 'Members';
        details.append(membersHeading);
    
        const heroList = document.createElement('ul')
        for (let member of data.members) {
            const listItem = document.createElement('li')
            listItem.innerText = member.name + ' | ';
            heroList.append(listItem);
        }
        details.appendChild(heroList);
    }
    
    function displayMembers() {
        for (let m of members) {
            const memberDiv = document.createElement('div');
            memberSection.append(memberDiv);
            const memberName = document.createElement('h1');
            memberName.innerText = m.name;
            memberDiv.append(memberName);
            const memberAge = document.createElement('h2');
            memberAge.innerText = 'Age: ' + m.age;
            memberDiv.append(memberAge);
            const secretID = document.createElement('h2');
            secretID.innerText = 'Secret Identity: ' + m.secretIdentity;
            memberDiv.append(secretID);
            const memberPowers = document.createElement('h3');
            memberPowers.innerText = 'Powers: ' + m.powers;
            memberDiv.append(memberPowers);
        }
    }
        createHeader();
        createDetailsSection();
        displayMembers();
    })
    .catch(error => {
        console.log('Didn\'t work', error);
    });