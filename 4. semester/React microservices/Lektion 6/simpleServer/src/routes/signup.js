const express = require('express');
const router = express.Router();
const {signupUser} = require('../controller/users');

router.post('/signup', async (req, resp) => {
    const {userName, email, password} = req.body
    if (signupUser(userName,email, password)) {
        resp.sendStatus(204)
    } else {
        resp.sendStatus(400)
    }
})
module.exports = router