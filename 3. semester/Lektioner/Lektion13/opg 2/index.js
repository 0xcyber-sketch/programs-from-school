
const express = require('express');
const fetch = require('node-fetch');


const app = express();

const userUrl = 'https://jsonplaceholder.typicode.com/users';

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

function genererTabel(users) {
    let html = '<table>';
    for (user of users) {
        html +=
            '<tr><td>' + user.id +
            '</td><td>' + user.name +
            '</td><td>' + user.company.name +
            '</td></tr>\n';
    }
    html += '</table>';
    return html;
}

app.get('/', async (req, res) => {
    try {
        let users = await get(userUrl)
        let html = genererTabel(users)

        res.writeHead(200, { "Content-Type": "text/html" }); // OK
        res.write(html);
    }
    catch (e) {
        if (typeof e.message === 'number')
            res.writeHead(e.message);
        else
            res.writeHead(400); // Bad Request
            res.write(e.name + ": " + e.message);
    }
    res.send()
})
app.listen(8080, () => {
    console.log("Listening on port 8080");
})