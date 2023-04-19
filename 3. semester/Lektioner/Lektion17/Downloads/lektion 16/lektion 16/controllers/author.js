const Author = require('../models/author')

const Mongoose = require('mongoose')

exports.createAuthor = function() {
  const author = new Author({
    _id: new Mongoose.Types.ObjectId,
    name: 'Ian Flemming',
    birthYear: 1920
  })
  return author.save()
}

exports.getAuthor = function(authorID) {
  return Author.findOne({_id: authorID}).exec()
}

exports.getAuthors = function(){
  return Author.find().exec()
}

