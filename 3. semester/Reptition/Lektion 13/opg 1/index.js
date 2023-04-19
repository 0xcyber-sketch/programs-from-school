import express from 'express'
import fs from 'fs/promises'
import path from 'path'

const app = express()
const __dirname = path.resolve()

app.use(express.static("filer"))

function genererLinks(filnavne) {
    let html = '';
    for (let filnavn of filnavne) {
        html += '<a href="' + filnavn + '">' + filnavn + '</a><br>\n';
    }
    return html;
}

app.get('/', async (req, res) => {
    let filenames = await fs.readdir('filer')
    let html = genererLinks(filenames);
    res.writeHead(200, { "Content-Type": "text/html" }); // OK
    res.write(html);
    res.send()
})

app.get('/:file', async (req,res) => {
    try {
        let sti =  '/filer' + req.params.file;
        let filData = await fs.readFile(sti);
        res.writeHead(200); // OK
        res.write(filData);
    } catch (e) {
        res.writeHead(404); // Not Found
        res.write(e.name + ": " + e.message);
    }    
    res.send()
})

app.listen(8080, () => console.log("Listening on port 8080"))