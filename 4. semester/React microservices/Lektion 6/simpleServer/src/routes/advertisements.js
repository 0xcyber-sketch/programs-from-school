const express = require('express');
const router = express.Router();
const advertisementControl = require('../controller/advertisements')
const userControl = require('../controller/users')

router.get('/advertisements', (req, resp) => {

    const category = req.query.category
    const userId = req.query.userId
    const advertisements = advertisementControl.getAdvertisements(category, userId)
    const list = advertisements.map(a => a.toJSONOverview())
    console.log("THE LIST" + list)
    resp.send(JSON.stringify(list))
})

router.get('/advertisements/:id', (req, resp) => {

    const advertisement = advertisementControl.getAdvertisementById(req.params.id)
    const user = userControl.getUserById(advertisement.userId)
    resp.send(JSON.stringify({user: user.toJSON(), advertisement: advertisement}))
})

router.post('/advertisements/', (req, resp) => {
    const body = req.body
    body.userId = req.session.userId
    const advertisement = advertisementControl.createAdvertisement(body)
    resp.send(JSON.stringify(advertisement))
})
module.exports = router