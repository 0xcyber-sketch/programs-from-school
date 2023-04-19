
const bodyNode = document.body

const tableNode = document.createElement('table')

const lande = [
    {'navn': 'Danmark', 'hovedstad' : 'København' },
    {'navn': 'Norge', 'hovedstad' : 'Oslo' },
    {'navn': 'Sverige', 'hovedstad' : 'Stockholm' },
]

// let er implicit:
for (land of lande){
    // Lav td noder
    const tdNavnNode = document.createElement('td')
    tdNavnNode.appendChild(document.createTextNode(land.navn))

    const tdHovedstadNode = document.createElement('td')
    // Tilføj hammer som en klasse til hovedstad
    //tdHovedstadNode.classList.add('hammer')
    tdHovedstadNode.appendChild(document.createTextNode(land.hovedstad))

    // Event listner
    tdHovedstadNode.addEventListener('click', clicked)

    tdHovedstadNode.style.color = 'blue'

    const trNode = document.createElement('tr')
    trNode.appendChild(tdNavnNode)
    trNode.appendChild(tdHovedstadNode)

    tableNode.appendChild(trNode)
}

bodyNode.appendChild(tableNode)

function clicked (event) {
    event.currentTarget.style.color = 'red';
    console.log(`Du trykkede på ${event.currentTarget.innerHTML}`)

}

let clicked2 = (event) => {
    event.currentTarget.style.color = 'green';
    console.log(`Du trykkede på ${event.currentTarget.innerHTML}`)
}
