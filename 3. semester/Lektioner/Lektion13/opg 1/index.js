const express = require('express')
const app = express()
const fs = require('fs').promises

function genererLinks(filnavne) {
    let html = '';
    for (let filnavn of filnavne) {
        html += '<a href="' + filnavn + '">' + filnavn + '</a><br>\n';
    }
    return html;
}

app.get('/', async (req, res) => {
    let filnavne = await fs.readdir(__dirname + '/filer');
    let html = genererLinks(filnavne);
    res.writeHead(200, 'Content-Type: text/html; charset=UTF-8')
    res.write(html)
    res.send()
})

app.get('/:file', async (req, res) => {
    try {
        let file = req.params.file
        let route = __dirname + '/filer/' + file
        let fileData = await fs.readFile(route)
        res.writeHead(200)
        res.write(fileData)
       
    }
    catch (e) {
        res.writeHead(404); // Not Found
        res.write(e.name + ": " + e.message);
    }
    res.send()
})

app.listen(8080, () => {
    console.log("Listening on port 8080");
})


