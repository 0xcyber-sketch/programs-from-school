let createLabel = function () {
    let elements = document.querySelectorAll("input")
    for (const e of elements) {
        e.outerHTML = "<label for='" + e.id + "'>" + e.id + "</label>" + e.outerHTML
    } 
    document.getElementById("tal").onclick = onClickTal
    document.querySelectorAll("label")[0].onclick = onClickTal
    document.getElementById("tid").onclick = onClickTid
    document.querySelectorAll("label")[1].onclick = onClickTid


}

function onClickTal(event) {
    let random = Math.floor(Math.random() * 1000)
    document.getElementById("tal").value = random
}

function onClickTid(event) {
    let date = new Date()
    document.getElementById("tid").value = date.toString()
}

let main = () => {
    createLabel()
}

main()