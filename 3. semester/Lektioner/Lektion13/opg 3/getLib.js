

const fetch = require('node-fetch')


let body = "<body>"
let amountOfUser = 0
let classes





const get = async (url) => {
    try {
        resp = await fetch(url)
        return await resp.json()
    } catch (error) {
        throw new Error("" + error)
    }
}

function  scriptGen(users) {
  let html = '<script> ' +
  'let amountOfUser = 0' +
  '</script>'
  /* \n let classes \n' + `let users = ${users}\n` +
   'function addListener(users) { \n for (user of users) { \n let i = user.id \n let span = document.getElementById("" + i) \
   \n span.addEventListener("click", tabbed) } \n \n async function tabbed(event) {\n \
    const id = parseInt(event.target.id)  \n let div = classes[(id - 1)] \n \
    for (let i = 0; i <= amountOfUser; i++) { \n if (i === id) { \n div.style.display = "block"; \
    \n div.setAttribute("chosen", "true") } \n else { \
    \n div.style.display = "none"; \n div.setAttribute("chosen", "false") } \n \
    div = classes[(i)] }} \n \n async function getPosts() { \n \
    classes = document.getElementsByClassName("post") \n for (let i = 1; i <= amountOfUser; i++) { \
    \n let data = await get(postUrl + "/" + i) \n  div = classes[i - 1] \
    \n div.setAttribute("chosen", "false") \n  div.innerHTML = "<h4>" + data.title + "</h4><p>" + data.body + "</p><br>"\n \
    div.style.display = "none" } \n }'

    html = html +"\ngetPosts()\n" + `//addListener(users) + \n console.log(users)</script>`

    */

  return html
}






function generateUsersTable(users) {
    let html = '<ul>'

    for (user of users) {
        amountOfUser++
        let { id, name, phone } = user
        html += '<li>ID: ' + id + '<br> Name: ' + name + '<br> Phone: ' + phone + '<h3><span id=' + id + '>Post</span></h3><div class="post"></div>' + '</li>'
    }
    html += '</ul>'
    return html

}

module.exports = {
    get,  generateUsersTable,  body, classes, amountOfUser, scriptGen
   }