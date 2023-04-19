
const BODYNODE = document.body
const tableNode = document.createElement('table')

const MOUNTAINS = [
    {name: "Kilimanjaro", height: 5895, place: "Tanzania"},
    {name: "Everest", height: 8848, place: "Nepal"},
    {name: "Mount Fuji", height: 3776, place: "Japan"},
    {name: "Vaalserberg", height: 323, place: "Netherlands"},
    {name: "Denali", height: 6168, place: "United States"},
    {name: "Popocatepetl", height: 5465, place: "Mexico"},
    {name: "Mont Blanc", height: 4808, place: "Italy/France"}
];

let header = document.createElement('h1')
header.innerHTML = 'Mountains'
header.style.color = 'red'
BODYNODE.appendChild(header)

let tableDiv = document.createElement('div')
tableDiv.setAttribute('id', 'tableID')

const thNameNode = document.createElement('th')
    thNameNode.appendChild(document.createTextNode('Name'))

    const thHeightNode = document.createElement('th')
    thHeightNode.appendChild(document.createTextNode('Height'))

    const thplaceNode = document.createElement('th')
    thplaceNode.appendChild(document.createTextNode('Place'))

    tableNode.appendChild(thNameNode)
    tableNode.appendChild(thHeightNode)
    tableNode.appendChild(thplaceNode)

for (moun of MOUNTAINS){
    const tdNameNode = document.createElement('td')
    tdNameNode.appendChild(document.createTextNode(moun.name))

    tdNameNode.style.borderWidth = '5px'
    tdNameNode.style.borderStyle = 'solid'
    tdNameNode.style.borderColor = 'blue'

    const tdHeightNode = document.createElement('td')
    tdHeightNode.appendChild(document.createTextNode(moun.height))

    tdHeightNode.style.borderWidth = '5px'
    tdHeightNode.style.borderStyle = 'solid'
    tdHeightNode.style.borderColor = 'blue'

    const tdplaceNode = document.createElement('td')
    tdplaceNode.appendChild(document.createTextNode(moun.place))

    tdplaceNode.style.borderWidth = '5px'
    tdplaceNode.style.borderStyle = 'solid'
    tdplaceNode.style.borderColor = 'blue'

    

    const trNode = document.createElement('tr')

    

    trNode.appendChild(tdNameNode)
    trNode.appendChild(tdHeightNode)
    trNode.appendChild(tdplaceNode)

    

    tableNode.appendChild(trNode)

}

tableNode.style.borderWidth = '5px'
tableNode.style.borderStyle = 'solid'
tableNode.style.borderColor = 'blue'

tableDiv.appendChild(tableNode)
BODYNODE.appendChild(tableDiv)