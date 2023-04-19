const PORT = process.env.PORT || 8087
const express = require('express')
const session = require('express-session')
const morgan = require('morgan')

//ROUTES
const loginRoute = require('./routes/login.js')
const signupRoute = require('./routes/signup.js')
const logoutRoute = require('./routes/logout.js')
const advertisementsRoute = require('./routes/advertisements.js')
const categoriesRoute = require('./routes/catgories.js')
//FILTER
const {authentication} = require('./filter/authenticationFilter')

//CORS
const cors = require('cors')

const app = express()
//middleware
app.use(express.json())
app.use(session({
    secret: 'mysecret123123123',
    saveUninitialized: true,
    resave: true,
    cookie: {
        "sameSite": "Strict",
        "maxAge": 86400000,
        "secure": false,
        "httpOnly": true
    }
}))
app.use(morgan('tiny'))
const corsOptions = {
    "origin": "http://localhost:3000",
    "methods": "GET,HEAD,PUT,PATCH,POST,DELETE",
    "preflightContinue": false,
    "optionsSuccessStatus": 204,
    "credentials": true,
    "allowedHeaders": "content-type,credentials,withcredentials,Cookie,Authentication"
}

app.use(cors(corsOptions))
app.use(authentication)
//ROUTES
app.use(loginRoute)
app.use(signupRoute)
app.use(logoutRoute)
app.use(advertisementsRoute)
app.use(categoriesRoute)


app.listen(PORT, () => {
    console.log(`listening to port ${PORT}`)
})