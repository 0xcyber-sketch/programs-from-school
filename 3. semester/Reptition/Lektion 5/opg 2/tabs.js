

let start = () => {
    let i = 0
    for (e of document.querySelectorAll("h1")) {
        if (i === 0) {
            e.style.display = "block"
        } else {
            e.style.display = "none"
        }
        document.querySelectorAll("span")[i].addEventListener("click", makeTabVisible)
        i++
    }

}

function makeTabVisible(event) {
    console.log(event.target)
    let i = -1
    for (e of document.querySelectorAll("span")) {
        if (e === event.target) {
            i++
            document.querySelectorAll("h1")[i].style.display = "block"
        }
        else {
            i++
            document.querySelectorAll("h1")[i].style.display = "none"
        }
    }
    

}


let main = () => {
    start()
}
main()