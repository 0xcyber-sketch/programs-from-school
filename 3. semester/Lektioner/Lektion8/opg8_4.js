//Observer pattern
// https://en.wikipedia.org/wiki/Observer_pattern

// Observers

let o1 = (x) => {
    console.log("Observer " + x + " got an update")
}

let o2 = () => {
    console.log("Observer got add")
}
let observers = []
// Subject functions
let subject = () => {
    
    let s = {

    "register" : function registerObserver (obs) {
        observers.push(obs)
        o2()
    },

   "notify" : function notifyObserver(obs) {
        o1(obs)
    }
    }
    
return s
}


let obs1 =  {
    "name" : "Charles"
}

let obs2 =  {
    "name" : "Charlez"
}



let sub = subject()

sub.register(obs1)
sub.register(obs2)
console.log(observers);

for (i in observers){
    sub.notify(i)
}


