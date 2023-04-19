import express from "express";
import fetch from "node-fetch";

const app = express()

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

app.use(express.static('assets'))

app.set("view engine", "pug")



app.get('/', async (req, res) => {
    const userUrl = 'https://randomuser.me/api/?nat=dk&results=10'

    let users = await get(userUrl)
    res.render('index.pug', {users : users.results})

})

app.listen(8080, () => console.log("Listening on port 8080"))