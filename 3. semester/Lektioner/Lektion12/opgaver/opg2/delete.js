const url = "https://jsonplaceholder.typicode.com/posts/11"

const body = document.body



async function deleteData(url) {
    let response = await fetch(url, {
        method: 'DELETE'
    }).then(resp => {
        if (resp.status >= 400)
            throw new Error(resp.status);
        else
            return resp.json();
    }).then(result => {return result}).catch(error => {return error}) 

    //.then(result => { console.log(result); }).catch(error => { return error })


    console.log(response);
}

function createNode(m) {
    return document.createElement(m)
}
function createTextNode(m) {
    return document.createTextNode(m)
}

function appendChild(parent, child) {
    parent.appendChild(child)
}

function drawGui() {

    let br  = createNode("br")

    let text = createNode("p")
    text.innerHTML = "Deletes post id 11"
    let form = createNode("form")
    form.method = "post"



    let pstButton = createNode("input")
    pstButton.type = "button"
    pstButton.value = "Submit"
    pstButton.setAttribute("onclick", "buttonClicked()")

    appendChild(form, pstButton)
    appendChild(body, text)
    appendChild(body, br)
    appendChild(body, form)




}

function buttonClicked() {
    deleteData(url)
}

function main() {
    drawGui()
}

main()

