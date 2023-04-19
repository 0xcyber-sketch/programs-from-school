const Book = require('../models/book')
const Schema = require('mongoose').Schema

exports.createBook = function(author){
  const book = new Book({
    _id: new Schema.Types.ObjectId,
    title: 'Swift 5.1',
    isbn: '0-13-421499-4',
    pages: 761,
    author: author
  })
  return book.save()
}

exports.deleteBook = function(){}

exports.updateBook = function(){}

exports.getBook = function(bookID){
  return Book.findOne({_id: bookID}).populate('author').exec()
}

exports.getBooks = function(){}