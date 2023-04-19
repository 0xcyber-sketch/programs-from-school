const url = "https://jsonplaceholder.typicode.com/posts"

const body = document.body



async function sendData(url, data) {
    let response = await fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: { 'Content-Type': 'application/json; charset=UTF-8' }
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

    let breaks = []

    for (let i = 0; i < 5; i++) {
        breaks.push(createNode("br"))
    }

    let form = createNode("form")
    form.method = "post"

    let titInput = createNode("input")
    titInput.type = "text"
    titInput.id = "title"

    let lblTitle = createNode("label")
    let lblTitleText = createTextNode("Title")
    appendChild(lblTitle, lblTitleText)
    lblTitle.setAttribute("for", "title")




    let bodInput = createNode("input")
    bodInput.type = "text"
    titInput.id = "body"

    let lblBody = createNode("label")
    let lblBodyText = createTextNode("Text")
    appendChild(lblBody, lblBodyText)
    lblBody.setAttribute("for", "body")

    let pstButton = createNode("input")
    pstButton.type = "button"
    pstButton.value = "Submit"
    pstButton.setAttribute("onclick", "buttonClicked()")

    appendChild(form, lblTitle)
    appendChild(form, breaks[0])
    appendChild(form, titInput)
    appendChild(form, breaks[1])
    appendChild(form, lblBody)
    appendChild(form, breaks[2])
    appendChild(form, bodInput)
    appendChild(form, breaks[3])
    appendChild(form, breaks[4])
    appendChild(form, pstButton)



    appendChild(body, form)




}

function buttonClicked() {
    let titleData = document.querySelectorAll("input")[0].value
    let bodyData = document.querySelectorAll("input")[1].value



    if (titleData.length > 0 && bodyData.length > 0) {
        let data = { userId: 111, id: 101, title: titleData, body: bodyData }
        sendData(url, data)


    }
}

function main() {
    drawGui()
}

main()

