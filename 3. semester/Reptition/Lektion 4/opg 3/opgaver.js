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

let everySecondChildGray = () => {
    let elements = document.querySelectorAll("li:nth-child(odd)")
    for (const e of elements) {
        e.style.backgroundColor = "lightgray"
    }
}
    
let main = () => {
    changeHeadersToRed()
    changeEvery2ndToBrown()
    everySecondChildGray()
}

main()