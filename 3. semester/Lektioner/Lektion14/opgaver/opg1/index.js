const express = require('express')
const fs = require('fs').promises

const app = express()

app.use(express.static('assets'))

app.set("view engine", "pug")

app.get("/", async (req, res) => {
    let filenames = await fs.readdir(__dirname + '/assets/filer');
    res.render('root', {filer: filenames} )

})



app.listen(8080, () => { console.log("Listening on port 8080");})