// opgave11.1.js
//const userUrl = 'https://jsonplaceholder.typicode.com/users';
//const userUrl = 'https://jsonplaceholder.typicode.com/users/11';
//const userUrl = 'httpz://jsonplaceholder.typicode.com/users';

async function get(url) {
   try {
    const respons = await fetch(url);

    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
   }
   catch (e) {
       console.log("Exception: " + e);
   }
}

get(userUrl)
.then (users => console.log(users))
.catch (fejl => console.log(fejl))


let getS = (url) =>  {
    try {
        const respons =  fetch(url);
    
        if (respons.status !== 200) // OK
            throw new Error(respons.status);
        return  respons.json();
       }
       catch (e) {
           console.log("Exception: " + e);
       }
}

//console.log(getS(userUrl));
console.log(get(userUrl));