import e from "express";
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

const allowed = ['dk', 'gb', 'fr', 'de']
let nat = 'dk'
let results = 10

app.get('/',  (req, res) => {
    res.redirect('/dk/10')

})

app.get('/:nat/:amount', async (req, res) => {
    nat = req.params.nat
    results = req.params.amount
 
    try {
    let userUrl = 'https://randomuser.me/api/?nat=' + nat + '&results=' + results
    let users = await get(userUrl)

    if (!allowed.includes(nat)) {
        throw Error("This Nationality is not allowed");
    }
    if (results > 100 || results < 0) {
        throw Error("Amount value is not allowed");
    }


    res.render('search.pug', {users : users.results})
    }
    catch (e) {
        

        res.render('error.pug', {e : e})
    }
})

app.listen(8080, () => console.log("Listening on port 8080"))