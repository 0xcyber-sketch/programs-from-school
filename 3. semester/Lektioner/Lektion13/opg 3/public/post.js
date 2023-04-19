
function generateHtml() {
    let html = "<form action='post'><br>" +
    "<input type='text' id='title' name='Title' placeholder='Title'><br><br>"+
    "<textarea name='comment' placeholder='Enter text here...'></textarea><br><br>"+
    "<input type='submit' value='Submit'>" +
    "</form>"

    return html
}

async function post(url, obj) {
    const respons = await fetch(url, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: { 'Content-Type': 'application/json' }
    });
    if (respons.status !== 201) // Created
        throw new Error(respons.status);
    return await respons.json();
}

/*function createObj() {
    let title = document.getElementById("title").value
    let body = document.querySelector('textarea').value
    let id = 
    return {title:''}
}*/

function main() {
   //document.body.innerHTML = generateHtml()
   //let obj = createObj()
   document.body.innerHTML = "<h1>hej</h1>"
}
main()