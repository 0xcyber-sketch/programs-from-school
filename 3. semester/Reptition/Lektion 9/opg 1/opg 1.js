// specialisering.js
class Person {
    constructor(navn) { this.navn = navn; }
    toString() { return this.navn; }
    equals(p) { return p instanceof Person && this.navn === p.navn }
    static compare(p1, p2) {
        if (p1.navn < p2.navn) {
            return -1
        } else if (p1.navn > p2.navn) {
            return 1
        } else return 0
    }
}
class Studerende extends Person {
    constructor(navn, id) {
        super(navn);
        this.id = id;
    }
    toString() { return super.toString() + ": " + this.id; };
    equals(s) { return s instanceof Studerende && this.navn === s.navn && this.id === s.id }

}
let person = new Person("Viggo");
let person2 = new Person("Alex");
let person3 = new Person("Buller");
let studerende = new Studerende("Ida", 123);
let studerende2 = new Studerende("Hans", 122);
let studerende3 = new Studerende("Benny", 121);

console.log(person instanceof Person); // => true
console.log(person instanceof Studerende); // => false
console.log(studerende instanceof Person); // => true
console.log(studerende instanceof Studerende); // => true


//let array = [person, studerende2, person2, studerende, person3, studerende3]

//console.log(array.sort(Person.compare));

class Kat {
    constructor(navn) { this.navn = navn; }
    toString() { return 'Kat: ' + this.navn; };
}
let kat = new Kat('Garfield');
let person4 = new Person('Viggor');
for (o of [kat, person])
    console.log(o.toString());

    let array = [person, studerende2, person2, studerende, person3, studerende3, kat]
    console.log(array.sort(Person.compare));