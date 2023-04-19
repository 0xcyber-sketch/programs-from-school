const mongoose = require('mongoose')
const Schema = mongoose.Schema

const now = new Date().getFullYear

const author = new Schema({
  _id: Schema.Types.ObjectId,
  name: String,
  birthYear: {type: Number, min: 1910},
  books: [{type: Schema.Types.ObjectId, ref: 'Book'}]
})

module.exports = mongoose.model('Author', author)
