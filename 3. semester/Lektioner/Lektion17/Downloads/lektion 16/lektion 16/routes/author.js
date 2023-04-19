const express = require('express')
const router = express.Router()
const controller = require('../controllers/author')

router.get('/', (req, res)=>{
  // find alle authors
  const authors = controller.getAuthors().then(data =>{
    res.render('authors',{authors: data})
  })
  //res.json({name:'HUGO'})
})

router.get('/createauthor', (req, res)=>{
  controller.createAuthor().then(data=>{
    console.log(data)

  })
  
})

router.get('/:id', (req, res)=>{
  // her kommer noget response noget
  
  const author = controller.getAuthor(req.params.id)
  author.then((data)=>{
    res.json(data)
  })
})


module.exports = router
