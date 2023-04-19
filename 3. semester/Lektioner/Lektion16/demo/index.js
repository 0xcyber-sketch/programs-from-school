// Change in package.json add "type"
// const express ... =>
//import express from "express";

// Save in another file not in index.js

import {initializeApp} from 'firebase/app'
import {getFirestore, collection, getDocs, doc, deleteDoc, addDoc, getDoc} from 'firebase/firestore' 

import express from 'express'
import { async } from '@firebase/util'


const app = express()
app.use(express.static('assets'))
// To use post data
app.use(express.json())
app.use(express.urlencoded())


app.set('view engine', 'pug')

// To use post data
app.use(express.json())
app.use(express.urlencoded())

let currentID



// Laver en forbindelse til firebase applikationen express-toget
const firebase_app = initializeApp(
    {

        apiKey: "AIzaSyDUqnhLI7Eki-7-QwGePwrIyClX65sIdw4",
      
        authDomain: "express-toget.firebaseapp.com",
      
        projectId: "express-toget",
      
        storageBucket: "express-toget.appspot.com",
      
        messagingSenderId: "507573562547",
      
        appId: "1:507573562547:web:3be5856fe9e669b6e814c6"
      
      }
)

// Opreter en forbindelse til firestore db'en i appen 
const db = getFirestore(firebase_app)

// *alt kommunikation er async



async function getMessages() {
    const messageCol = collection(db, 'beskeder')

    // Get a snapshot 
    const messageSnapsshot = await getDocs(messageCol)

    // Transform data from docs 
    //const messageList = messageSnapsshot.docs.map(doc => doc.data())

    // get ID as well
    const messageList = messageSnapsshot.docs.map(doc => {
        let data = doc.data()
        data.docID = doc.id
        return data
    })

    return messageList





}
// Can be an async await
//getMessages().then( list => console.log(list))
//await solutions
/*let list = await getMessages()
console.log(list);*/

// Delete message
async function deleteMessage(messageID) {
    await deleteDoc(doc(db, "beskeder", messageID))
}


//deleteMessage('gn2TCV8FKfeKF6GiDjD3').then(result => console.log("slettet"))

// Adds a document to a collection 
async function addMessage(message) {

    // Need to program some validation of the message parameter
    const docRef = await addDoc(collection(db, "beskeder"), message)
    
    return docRef.id
}

let message = {
    messagetext: "Hurra et nyt besked", owner: "Emil"
}

//addMessage(message).then(id => console.log(id))



app.get('/', async (req,res) => {
    const messages = await getMessages()
    res.render('frontpage', {messages: messages})
})

app.get('/createMessage', (req, res) => {
res.render('addmessage')
})

app.post('/createMessage', async (req, res) => {
    const message = req.body.besked // Get data from form with name besked
    const dbObject = {messagetext: message, owner: "User"}
    const id = await addMessage(dbObject)

    res.redirect('/')


})

async function getMessage(id) {
    const messageRef = doc(db, 'beskeder', id)
    const messageSnapsshot = await getDoc(messageRef)

    if (messageSnapsshot.exists()) {
        let data = messageSnapsshot.data()
        data.docID = id
        return data
    }
}
app.get('/message/:id', async (req, res) => {
    const docID = req.params.id
    currentID = docID
    const message = await getMessage(docID)
    res.render('messageDetail', {message: message})
})

app.post('/message/:id', async (req, res) => {
    await deleteMessage(currentID)
    res.redirect('/')
})



app.listen(8080, () => console.log("Listening on port 8080"))