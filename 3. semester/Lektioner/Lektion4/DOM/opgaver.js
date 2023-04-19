// Tilføj kode for opgave 4.1 - 4.5 her!

// 4.1
let texts = document.getElementsByTagName('p');

for (let t of texts){
    t.style.color = 'red';
}


// 4.2 
let element = document.querySelectorAll('h1 + * + *')
for (e of element){
e.style.color = 'brown'
}

// 4.3

for ( even of lis = document.querySelectorAll('li:nth-child(odd)')) {
    even.style.backgroundColor = 'lightgray'
}

// 4.4

for (e of document.querySelectorAll('h1 + *')){
    let outerHTML = e.innerHTML
    e.innerHTML = '<h2>' + outerHTML + '</h2>'
}


// 4.5
// querySelectorAll('h1, h2')

let titles = document.getElementsByTagName('h1')
let id = 1

for (e of titles){
    e.setAttribute('id', 'id' + id++)
    
}

let head1 = document.getElementsByTagName('h1')[0];

head1.outerHTML = '<a href = "#id1">Header 1</a><br><a href = "#id2">Header 2</a><br><a href = "#id3">Header 3</a><br>' + head1.outerHTML
