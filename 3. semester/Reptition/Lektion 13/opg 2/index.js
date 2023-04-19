import fetch from 'node-fetch'
import express from 'express'

const app = express()

const userUrl = 'https://jsonplaceholder.typicode.com/users';


async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

function genererTabel(users) {
    let html = '<table>';
    for (let o of users) {
        html +=
            '<tr><td>' + o.id +
            '</td><td>' + o.name +
            '</td><td>' + o.company.name +
            '</td></tr>\n';
    }
    html += '</table>';
    return html;
}

app.get('/', async (req,res) => {
    try {
        let users = await get(userUrl);
        let html = genererTabel(users);
        res.writeHead(200, { "Content-Type": "text/html" }); // OK
        res.write(html);
    } catch (fejl) {
        if (typeof fejl.message === 'number')
            res.writeHead(fejl.message);
        else
            res.writeHead(400); // Bad Request
        res.write(fejl.name + ": " + fejl.message);
    }
    res.send()
})

app.listen(8080, () => console.log("Listening on port 8080"))