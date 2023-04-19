// Promise return true or false
// ask mom if we can get a new phone

let isMomHappy = true;
let showOff = function (phone) {
    const message = "Aye Yo, Look at my new Phone. Y'all ain't rich like me. *Shows* " +  `${phone.color} and ${phone.brand}`
    

    return Promise.resolve(message)
}
// Ask for a new phone
let askMom = () => {
 WillIGetNewPhone

 .then(showOff)
 .then(message => console.log(message))
 .catch(error => console.log(error.message));
}

// New promise
const WillIGetNewPhone = new Promise(
    (resolve, reject) => {
        if (isMomHappy) {
            const phone = {
                brand: 'One plus',
                color: 'Metallic black'
            }
            //setTimeout(resolve(phone), 10000)
            resolve(phone)
        } 
        else {
            const error = new Error("Mom isn't happy")

            reject(error)
        }
        
    }
)
askMom()





