// Tilføj kode for opgave 4.1 - 4.5 her!

const body = document.body

let changeHeadersToRed = () => {
   let elements = document.querySelectorAll("p")
   for (const e of elements) {
       e.style.color = "red"
   }
}

let main = () => {
    changeHeadersToRed()
}

main()