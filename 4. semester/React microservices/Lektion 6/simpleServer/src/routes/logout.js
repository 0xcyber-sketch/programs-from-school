const express = require('express');
const router = express.Router();

router.get('/logout', async (req, resp) => {
    req.session.destroy(err => {
        if (err) {
            console.log(err)
            resp.sendStatus(400)
        } else {
            resp.send({"status": "loggedOut"})
        }
    })
})
module.exports = router
