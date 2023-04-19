// opgave12.1.js
const earthquakeUrl = // https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php 
    'https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson';


async function get(url) {
const response = await fetch(url)
if (response.status !== 200) {
    throw Error ("Status code is not 200")
}
return response.json()
}

async function getData () {
    let getData = await get(earthquakeUrl)
    return getData
}

function sortdata(data) {
    let array = data.features.filter(data => data.properties.mag >= 5)
    .sort((a,b) => a.properties.mag - b.properties.mag)
    
    return array
}

function generateHtml(data) {
    let html = '<table>'
    data.forEach(element => {
        html += '<tr><td>' + 
        element.properties.place + '</td><td>' + 
        element.properties.time + '</td><td>' + 
        element.properties.mag + '</td></tr>'   
    });
    html += '</table>'
    return html
}




async function main() {
    let data = await getData()
    data = sortdata(data)
    document.body.innerHTML = generateHtml(data)
}
main()