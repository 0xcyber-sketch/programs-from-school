class Person {
    #name
    #groups
    #age
    constructor(name, age) {
        this.#groups = [
        ]
        this.name = name
        this.age = age
    }

    addGroup(group)  {
        if (!group instanceof Group) throw Error("Element isn't a group object")
        if (!this.#groups.includes(group)){
            this.#groups.push(group)
            group.addPerson(this)
        }

    }

    removeGroup(group)  {
        if (!group instanceof Group) throw Error("Element isn't a group object")
        if (this.#groups.includes(group)){
          let i = this.#groups.indexOf(group)
           if (i > -1) {
            this.#groups.splice(i, 1)
           }
            group.removePerson(this)
        }

    }

    getName() {
        return this.#name
    }

    getGroups() {
        return Array.from(this.#groups)
    }

    getAge() {
        return this.#age
    }

}

class Group {
    #name
    #persons
    constructor(name) {
        this.#persons = [ ]
        this.name = name
    }

    addPerson(person)  {
        if (!person instanceof Person) throw Error("Element isn't a person object")
        if (!this.#persons.includes(person)){
            this.#persons.push(person)
            person.addGroup(this)
        }

    }

    removePerson(person)  {
        if (!person instanceof Person) throw Error("Element isn't a person object")
        if (this.#persons.includes(person)){
          let i = this.#persons.indexOf(person)
           if (i > -1) {
            this.#persons.splice(i, 1)
           }
           person.removeGroup(this)
        }

    }

    getName() {
        return this.#name
    }

    getPersons() {
        return Array.from(this.#persons)
    }
}


let p1 = new Person("Emil", 9)
let g1 = new Group("Langager")
let g2 = new Group("Datamatiker")



p1.addGroup(g1)
g2.addPerson(p1)

console.log(p1.getGroups());
console.log(g1.getPersons());

g1.removePerson(p1)

console.log(p1.getGroups());
console.log(g1.getPersons());