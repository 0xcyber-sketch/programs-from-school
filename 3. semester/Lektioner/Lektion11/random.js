

const url = 'https://randomuser.me/api/?results=50'
const ul = document.getElementById('users')

// Promise 

function createNode(element) {
    return document.createElement(element)
}

function appendNode(parent, element) {
    return parent.appendChild(element)
}
/*
fetch(url)
.then(response => response.json())
.then(json => {
    const users = json.results

    return users.map(user => {
        const li = createNode('li'), 
        img = createNode('img'),
        span = createNode('span')

        img.src = user.picture.large
        span.innerHTML = `${user.name.first} ${user.name.last}`

        appendNode(li,img)
        appendNode(li, span)
        appendNode(ul, li)

    } )  
}
    )
.catch(error => console.log(JSON.stringify(error)))
// Første fejl men hvis den anden skal catches skal ind i then oven overfor.

*/
// Async await

async function getTinges(url) {
    let user
    let jsonData

    try {
        user = await fetch(url)


    } catch (error) {
        console.log(error => console.log(JSON.stringify(error)))
    }
    jsonData = (await user.json()).results

    return jsonData.map(user => {
        const li = createNode('li'),
            img = createNode('img'),
            span = createNode('span')

        img.src = user.picture.large
        span.innerHTML = `${user.name.first} ${user.name.last}`

        appendNode(li, img)
        appendNode(li, span)
        appendNode(ul, li)
    }
    )
}


getTinges(url)
