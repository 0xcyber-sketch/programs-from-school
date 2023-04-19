const userControl = require("../controller/users");

function authentication(req, resp, next) {
    console.log("AUTHENTICATION FILTER")
    let match = /^(\/login|\/signup|\/)$/.exec(req.url)
    if (!match) {
        if (!userControl.authenticateSessionName(req.session.userId)) {
            resp.sendStatus(401)
        } else {
            next()
        }
    } else {
        next()
    }
}
module.exports = {authentication}