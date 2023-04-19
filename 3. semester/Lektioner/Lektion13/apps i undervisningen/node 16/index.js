const { request, response } = require('express')
const express = require('express')
const figlet = require('figlet')

const app = express()

/*
app.get('/', (request, response) => {
    figlet.text("Hello World", (error, data) => {
        if (error) throw error
        response.write(data)
        response.send()
    })
})*/


app.get('/', (req, resp) => {
    resp.writeHead(200, 'Content-Type: text/html; charset=UTF-8')
    resp.write('<h1> Welcome to my site</h1><br><p>Try /*word* in the url</p>')
    resp.send()
})

app.get('/:text', (request, response) => {
    figlet.text(request.params.text, (error, data) => {
        if (error) throw error
        response.write(data)
        response.send()
    })
})

app.listen(8080, () => {
    console.log("Listening on port 8080");
})
