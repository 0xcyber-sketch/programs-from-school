const mongoose = require('mongoose')
const Schema = mongoose.Schema

const book = new Schema({
  _id: Schema.Types.ObjectId,
  title: String, 
  isbn: {type: String, index: true},
  pages: Number, 
  author: {type: Schema.Types.ObjectId, ref: 'Author'} // 0..1 link to author
})

module.exports = mongoose.model('Book', book)