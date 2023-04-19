const express = require('express');
const router = express.Router();
const userControl = require('../controller/users');

router.get('/login', (req, resp) => {
    console.log("USERID" + req.session.userId)
    if (req.session.userId) {
        resp.send({"status":"loggedIn"})
    } else {
        resp.sendStatus(401)
    }
})
router.post('/login', (req, resp) => {
    const {credential, password} = req.body
    console.log(credential, password)
    let user = userControl.authenticateUserByUserName(credential, password)
    if (!user) {
        user = userControl.authenticateUserByEmail(credential, password)
    }
    if (user) {
        req.session.userId = user.id
        req.session.userName = user.userName
        req.session.email = user.email
        resp.sendStatus(200)
    } else {
        resp.sendStatus(400)
    }
})
module.exports = router
