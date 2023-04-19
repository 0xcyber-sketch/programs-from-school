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
    
let main = () => {
    changeHeadersToRed()
    changeEvery2ndToBrown()
}

main()