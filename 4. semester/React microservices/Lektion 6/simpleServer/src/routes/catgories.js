const express = require('express');
const router = express.Router();
const advertisementControl = require('../controller/advertisements')

router.get('/categories', (req, resp) => {
    resp.send(JSON.stringify(advertisementControl.getCategories().map(c => c.toJSON())))
})

module.exports = router