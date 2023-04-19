// opgave11.2.js
const userUrl = 'https://jsonplaceholder.typicode.com/users';
const postUrl = 'https://jsonplaceholder.typicode.com/posts?userId=';


const body = document.body

async function get(url) {
    try {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
    }
    catch (e) {
        console.log("Mistakes were made: " + e);
    }
}

async function makeUserTables() {
    let data = await get(userUrl)
    console.log(data[0].name);
    
    let tbl = document.createElement('table')
    for (d of data)     {
        let tr = tbl.insertRow()
            let td = tr.insertCell()
            let link = document.createElement("a")
            link.innerHTML = d.name
            td.appendChild(link)        

    }
    body.appendChild(tbl)
}

async function makePostTables(post) {

}

function main() {
    makeUserTables()

}


main()

