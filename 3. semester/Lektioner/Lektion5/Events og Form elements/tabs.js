// 
let tabs = document.querySelectorAll('span')
// 
let headers = document.querySelectorAll('h1')
for (let i  = 0; i < tabs.length; i++){
    tabs[i].setAttribute("chosen", "false")
    tabs[i].addEventListener("click",tabbed)
    headers[i].style.display = "none";
}




function tabbed(event){
for (let i = 0; i < tabs.length; i++){
    if (event.target === tabs[i]){
        headers[i].setAttribute('chosen', 'true')
        headers[i].style.display = "block";
    }
    else {
        headers[i].setAttribute('chosen', 'false')
        headers[i].style.display = "none";
    }
}


}