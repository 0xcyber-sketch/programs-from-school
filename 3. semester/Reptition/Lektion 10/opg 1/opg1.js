
const url = "https://jsonplaceholder.typicode.com/users"

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}
let withoutAsync = function() {
   // let user
    get(url).then(elements => {console.log(elements)})
    .catch(result => console.log(result))

    

// https://stackoverflow.com/questions/38884522/why-is-my-asynchronous-function-returning-promise-pending-instead-of-a-val 
// https://stackoverflow.com/questions/29516390/how-to-access-the-value-of-a-promise
}

let withAsync = async function() {
    let users = await get(url)

    console.log(users[0].name)
}

function main() {
    withoutAsync()
    
}

async function main2() {
    withAsync()
}

main()
//main2()