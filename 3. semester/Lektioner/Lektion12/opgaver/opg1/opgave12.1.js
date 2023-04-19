// opgave12.1.js
const earthquakeUrl = // https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php 
    'https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson';

    const body = document.body

/*async function get(url) {
    try {
        result = await fetch(url)
        return await result.json()

    } catch (error) {
        console.log(error)
    }
}
*/

 function selectQuackes(quacke) {
    return quacke.features
    .filter(earth => earth.properties.mag >= 5)
    .sort((a,b) => a.properties.mag - b.properties.mag)


}

function addNode (parent, child) {
    parent.appendChild(child)
}

function buildSite (list) {

const tbl = document.createElement("table")    

// Leg med for lykke ?? 

// let {time, place, mag} = e.properties
for (e of list) {
    const tr = document.createElement("tr")
    const mag = document.createElement("td")
    const place = document.createElement("td")
    const time = document.createElement("td")

    mag.innerHTML = e.properties.mag
    place.innerHTML = e.properties.place
    time.innerHTML = e.properties.time

    addNode(tr,mag)
    addNode(tr,place)
    addNode(tr,time)
    
    addNode(tbl, tr)

}



addNode(body, tbl)




}

async function main() {
let queakes

try {
    queakes =  await get(earthquakeUrl)
} catch (error) {
    console.log(error);
}
let list = await selectQuackes(queakes)
console.log(list);

buildSite(list)

}
main()