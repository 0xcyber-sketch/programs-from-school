const MOUNTAINS = [
    {name: "Kilimanjaro", height: 5895, place: "Tanzania"},
    {name: "Everest", height: 8848, place: "Nepal"},
    {name: "Mount Fuji", height: 3776, place: "Japan"},
    {name: "Vaalserberg", height: 323, place: "Netherlands"},
    {name: "Denali", height: 6168, place: "United States"},
    {name: "Popocatepetl", height: 5465, place: "Mexico"},
    {name: "Mont Blanc", height: 4808, place: "Italy/France"}
];

const tblHeaders = ["Name", "Height", "Place"]

const body = document.body

let h1 = document.createElement("h1")
h1.innerHTML = "Mountains"

body.appendChild(h1)

const table = document.createElement("table")

for (const e of tblHeaders) {
    const node = document.createElement("th")
    node.innerHTML = e
    table.appendChild(node)
}

MOUNTAINS.forEach(element => {
   const tr = document.createElement("tr")
   let name = document.createElement("td")
   name.innerText = element.name
   let height = document.createElement("td")
   height.innerText = element.height
   let place = document.createElement("td")
   place.innerText = element.place
   tr.appendChild(name)
   tr.appendChild(height)
   tr.appendChild(place)
   table.appendChild(tr)
})

body.appendChild(table)