
// Urls
const userUrl = 'https://jsonplaceholder.typicode.com/users'

// Gets
// title og body
const postUrl = 'https://jsonplaceholder.typicode.com/posts'


const body = document.body
let amountOfUser = 0
let classes





const get = async (url) => {
    try {
        resp = await fetch(url)
        return await resp.json()
    } catch (error) {
        throw new Error("" + error)
    }
}

function addListener(users) {
    for (user of users) {
        let i = user.id
        let span = document.getElementById("" + i)
        span.addEventListener("click", tabbed)


    }
}

async function tabbed(event) {

    const id = parseInt(event.target.id) 
    let div = classes[(id - 1)]
    for (let i = 0; i <= amountOfUser; i++) {
        if (i === id) {
            console.log(true);
            div.style.display = "block";
            div.setAttribute('chosen', 'true')
        }
        else {
            console.log(false);
            div.style.display = "none";
            div.setAttribute('chosen', 'false')
        }
        div = classes[(i)]
    }







}








async function getPosts() {
    classes = document.getElementsByClassName("post")
    for (let i = 1; i <= amountOfUser; i++) {
        let data = await get(postUrl + '/' + i)
        div = classes[i - 1]
        div.setAttribute("chosen", "false")
        div.innerHTML = '<h4>' + data.title + '</h4><p>' + data.body + '</p><br>'
        div.style.display = "none"
    }
}



async function main() {

    let users = await get(userUrl)
    body.innerHTML = generateUsersTable(users)
    getPosts()
    console.log(amountOfUser);
    addListener(users)

}



function generateUsersTable(users) {
    let html = '<ul>'

    for (user of users) {
        amountOfUser++
        let { id, name, phone } = user
        html += '<li>ID: ' + id + '<br> Name: ' + name + '<br> Phone: ' + phone + '<h3><span id=' + id + '>Post</span></h3><div class="post"></div>' + '</li>'
    }
    html += '</ul>'
    return html

}

main()


