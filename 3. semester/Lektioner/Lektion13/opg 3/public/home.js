
const userUrl = 'https://jsonplaceholder.typicode.com/users'
const postUrl = 'https://jsonplaceholder.typicode.com/posts'
const get = async (url) => {
    try {
        resp = await fetch(url)
        return await resp.json()
    } catch (error) {
        throw new Error("" + error)
    }
}

function addListener(users) {
    for (let user of users) {
        let i = user.id
        let span = document.getElementById("" + i)
        span.addEventListener("click", tabbed)
    }
}

async function tabbed(event) {
    const id = parseInt(event.target.id)
    let i = 1
    for (let o of document.querySelectorAll("span")) {
        if (parseInt(o.id) === id && i === id) {
           document.getElementsByClassName("post")[i-1].style.display = "block"
        }
        else {
            document.getElementsByClassName("post")[i - 1].style.display = "none"
        }
        i++
    }
}

async function getPosts() {
    
    for (let i = 1; i <= document.getElementsByClassName("post").length; i++) {
        let data = await get(postUrl + "/" + i)
        document.getElementsByClassName("post")[i - 1].innerHTML = "<h4>" + data.title + "</h4><p>" + data.body + "</p><button type='button' onclick=location.href='/makePost/'>Post</button>"
    }
}


function generateUsersTable(users) {
    let html = '<ul>'

    for (o of users) {
        let { id, name, phone } = o
        html += '<li>ID: ' + id + '<br> Name: ' + name + '<br> Phone: ' + phone + '<h3><span id=' + id + '>Post</span></h3><div class="post" style="display: none"></div>' + '</li>'
    }
    html += '</ul>'
    return html

}
main = async () => {
    let users = await get(userUrl)
    console.log(users);
    document.body.innerHTML = generateUsersTable(users)
    getPosts()
    addListener(users)
}

main()