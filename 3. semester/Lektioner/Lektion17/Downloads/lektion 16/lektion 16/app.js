// INITIALISERING
const express = require('express')
const app = express()
app.set('view engine', 'pug')
const config = require('./config')

// MONGODB OPSÆTNING
const mongoose = require('mongoose')
mongoose.Promise = global.Promise
mongoose.connect(config.mongoDBHost, {
  useNewUrlParser: true,
  useCreateIndex: true, 
  autoIndex: false,
  useUnifiedTopology: true
})

// MIDDLEWARE


// ROUTES
const authorRouter = require('./routes/author')
app.use('/author', authorRouter)
const bookRouter = require('./routes/book')
app.use('/book', bookRouter)

// SERVERSTART
app.listen(config.PORT, ()=>{
  console.log(`PORT ${config.PORT} er i gang!`)
})

