const express = require('express')
//const pug = require('pug')

const app = express()

// You can now use pug
app.set("view engine", "pug")

// Statics files middleware. Don't use the assets in the url on the site
app.use(express.static('assets'))



app.get('/', (req, res) => {
    let cats = [{name: "Knud"},{name: "Kaj"}, {name: "Pus"} ]
    res.render('template', {title: 'Template Demo', cat: cats})

})

app.get('/test', (req, res) => {
    res.render('test')
})

app.post('/ja', (req, res)=>{
    console.log("Trykket på ja")
    res.render('test')

})

app.post('/nej', (req, res)=>{
    console.log("Trykket på nej")
    res.render('test')

})




app.listen(8080, console.log("listening on port 8080"))