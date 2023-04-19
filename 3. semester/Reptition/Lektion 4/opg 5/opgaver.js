// Tilføj kode for opgave 4.1 - 4.5 her!

const body = document.body

let changeHeadersToRed = () => {
    let elements = document.querySelectorAll("p")
    for (const e of elements) {
        e.style.color = "red"
    }
}

let changeEvery2ndToBrown = () => {
    let elements = document.querySelectorAll("h1 + * + *")
    for (const e of elements) {
        e.style.color = "brown"
    }
}

let everySecondSiblingGray = () => {
    let elements = document.querySelectorAll("li:nth-child(odd)")
    for (const e of elements) {
        e.style.backgroundColor = "lightgray"
    }
}

let firstSiblingToH2 = () => {
    let elements = document.querySelectorAll("h1 + * ")
    for (const e of elements) {
        e.outerHTML = "<h2>" + e.innerHTML + "</h2>"
    }
}

// Alternative use innerhtml to solve this
let makeHyperlinks = () => {
    let hElements = document.querySelectorAll("h1, h2")
    for (let i = 0; i < hElements.length; i++) {
        hElements[i].setAttribute("id", "header: " + (i + 1))
    }
    let len = hElements.length
    createLinkNodes(len)

}

let createLinkNodes = (len) => {
    let divNode = document.createElement("div")
    divNode.innerHTML = "Contents: <br>"
    let h1Elements = document.querySelectorAll("h1")
    const br = document.createElement("br")
    h1Elements[0].insertAdjacentElement("beforebegin", divNode)
    h1Elements[0].insertAdjacentElement("beforebegin",br )

    for (let i = 0; i < len; i++) {
        const node = document.createElement("a")
        node.href = "#header: " + i
        node.innerHTML = document.getElementById("header: " + (i+1)).innerHTML
        const br = document.createElement("br")
        divNode.appendChild(node)
        divNode.appendChild(br)
    }


}

let main = () => {
    changeHeadersToRed()
    changeEvery2ndToBrown()
    everySecondSiblingGray()
    firstSiblingToH2()
    makeHyperlinks()
}

main()