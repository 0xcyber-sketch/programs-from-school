import express from "express";
import fs from "fs/promises"

const app = express()

app.set("view engine", "pug")

app.use(express.static("filer"))



app.get('/', async (req, res) => {
    let filenames = await fs.readdir('filer')
    res.render('index.pug', {filenames: filenames})
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
