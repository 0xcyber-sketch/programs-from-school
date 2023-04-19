
import express from "express";
import path from 'path';
// https://stackoverflow.com/questions/64383909/dirname-is-not-defined-in-node-14-version

const __dirname = path.resolve();


const app = express()
app.use(express.static('public'))



app.get('/', async (req, res) => {
    res.writeHead(200, { "Content-Type": "text/html" }); // OK
    //res.sendFile('index.html')
    res.write('index.html')
    res.send()

})

app.get('/makePost', (req, res) => {

res.sendFile("./public/post.html", {root : __dirname})

})
app.listen(8080, () => {
    console.log("Listening on port 8080");
})
