const url = "https://jsonplaceholder.typicode.com/users"
const postUrl = 'https://jsonplaceholder.typicode.com/posts?userId=';

const body = document.body

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

function generateTables(users) {
    let html = "<table>"
    for (o of users) {
        html += "<tr><td>" + 
        o.name + "</td>"+
        "<td>" + 
        o.id + "</td>" +
        "<td>" + 
        o.email + "</td></tr>" 
    }

    html += "</table><br><div></div>"
    return html
}

function generatePostTables(posts) {
    let html = "<table>"
    for (p of posts) {
        html += "<tr><td>" +
        p.title + "</td><td>" + 
        p.id + "</td><t/r>"
    }

    html += "</table>"
    return html
}

async function createPostHandler(event) {
    let userid = event.currentTarget.firstChild.nextElementSibling.innerHTML
    let posts
    try {
        posts = await get(postUrl + userid)
    } catch(e) {
        console.log(e);
    }
    document.querySelector("div").innerHTML = generatePostTables(posts)
}

async function main() {
    let users
    try {
         users = await get(url)
    } catch(e) {
        console.log(e);
    }
    console.log(users)
    
    body.innerHTML = generateTables(users)
    for (const e of document.querySelectorAll("tr")) {
        e.onclick = createPostHandler
    }
 }

 main()