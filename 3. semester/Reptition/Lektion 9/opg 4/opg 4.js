class Person {
    constructor(name, age) {
        this.#name = name
        this.#age = age
    } 
    #name
    #age
    #group

    getAge() {return this.#age}
    getName() {return this.#name}
    getGroup() {return this.#group.getName()}

    setGroup(group) {
        if (this.#group !== group ){
            if (this.#group !== undefined) {
                group.removePerson(this)
            }
        }
        this.#group = group
        if (group !== undefined) {
            group.addPerson(this)
        }
        
    }
}

class Group {
    constructor(name) {
        this.#name = name
        this.#persons = []
    }
    #name
    #persons

    getName() {return this.#name}
    addPerson(person) {
        if (!this.#persons.includes(person)) {
            this.#persons.push(person)
            person.setGroup(this)
        }
    }
    removePerson(person) {
        if (this.#persons.includes(person)) {
            let i = this.#persons.findIndex(person)
            this.#persons.splice(i,1)
            person.setGroup(undefined)
        }
    }
    getPersons() {return this.#persons}

}

let p1 = new Person("Emil", 21)
let p2 = new Person("Mads", 18)

let g1 = new Group("Langager")

//console.log(p1.getGroup());
p1.setGroup(g1)
console.log(p1.getGroup());
//g1.addPerson(p1)

console.log(g1.getPersons()[0].getName())