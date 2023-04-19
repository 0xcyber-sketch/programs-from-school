const express = require('express')

const app = express()

const pug = require('pug')

// Using template engine pug
app.set('view engine', 'pug')

app.get('/', (req, res) => {
    res.render('main', {title: 'Test', message: 'Hello world' } )
})


app.listen(8080, () => { console.log("listening on port 8080");})

 