const express = require('express')
const fetch = require('node-fetch')
//const get = require("assets/js/get.js")

const userUrl = 'https://randomuser.me/api/?nat=dk&results=100'


async function get(url) {
  const respons = await fetch(url);
  if (respons.status !== 200) // OK
    throw new Error(respons.status);
  return await respons.json();
}



const app = express()

app.set("view engine", "pug")

app.use(express.static('assets'))

app.get("/", async (req, res) => {
  // let users = get.get(userUrl)
  let users = await get(userUrl)
  res.render("template", {user: users.results})

})

app.listen(8080, console.log("Listening on port 8080"))