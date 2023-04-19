const express = require('express')
const fetch = require('node-fetch')
//const get = require("assets/js/get.js")

let url = 'https://randomuser.me/api/?'
//nat=dk&results=100'


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
  
  html = '<h1> Example </h1> <br> <p>/11 gives 11 people with Danish nationality </p> <br> \
  <p> /11/fr Gives 11 people from France. Choose between gb, dk, fr and de</p>'

  res.write(html)
  res.send()

})



app.get("/:amount", async (req, res) => {
let amount = req.params.amount
if (amount <= 100 && amount >= 10) { 
  
  newUrl = url + 'nat=dk&results=' + parseInt(amount)

  let users = await get(newUrl)

  res.render("template", {user: users.results})


}
else {
  res.send("404 ERROR")
}

})

app.get("/:amount/:nat", async (req, res) => {
  let amount = req.params.amount
  let nat = req.params.nat




  if (amount <= 100 && amount >= 10) { 
    if (nat.localeCompare("gb") === 0 || nat.localeCompare("dk") === 0 || nat.localeCompare("fr") === 0 || nat.localeCompare("de") === 0) {
      newUrl = url + 'nat=' + nat + '&results=' + parseInt(amount)
  
      let users = await get(newUrl)
      res.render("template", {user: users.results})
    }
    else {
      res.send("404 ERROR")
    }
  }
  else {
    res.send("404 ERROR")
  }
  
})




app.listen(8080, console.log("Listening on port 8080"))