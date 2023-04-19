
let observer = function() {
    console.log("observer notified");
}

let subject = function() {
    let o = new Object()
    let observers = []

    o.observers = observers

    o.registerObserver = function registerObserver(ob) {
        
        observers.push(ob)
    }

    o.notifyObserver = function notifyObserver() {
        for (e of observers) {
            e()
        }
    }

    return o
}

let ob = subject()
ob.registerObserver(observer)
ob.registerObserver(observer)

ob.notifyObserver()