// specialisering.js
class Person {constructor(navn) { this.navn = navn; }    
toString() { return this.navn; }
static compare(p1, p2) {
    return p1.localeCompare(p2)
}
}
class Studerende extends Person {constructor(navn, id) {super(navn);this.id = id;    }
    toString() { return super.toString() + ": " + this.id; };}
    let person = new Person("Viggo");
    let studerende = new Studerende("Ida", 123);
    console.log(person instanceof Person);
     // => true
     console.log(person instanceof Studerende); // => false
     console.log(studerende instanceof Person); // => true
     console.log(studerende instanceof Studerende); // => true


     // p.constructor.name === "Person" er det samme som instance of

     //  Tilføjer til Person prototype = Objekt?
    
     Person.prototype.equals = function (p) { 
         return (p.constructor.name === "Person"  && p.navn === this.navn)
     }

     // Tilføjer til studerendes prototype = Person
     Studerende.prototype.equals = function (s) { 
        return (s.constructor.name === "Studerende"  && s.navn === this.navn && s.id === this.id)
    }
    /*
        // Skulle virke?
    Person.equals = function (p) { 
        return (p.constructor.name === "Person"  && p.navn === this.navn)
    }

    // Tilføjer til studerendes prototype = Person
    Studerende.equals = function (s) { 
       return (s.constructor.name === "Studerende"  && s.navn === this.navn && s.id === this.id)
   }
   */
    // Man skulle ikke anvende prototype Studerende.prototype.equals
    // static ?
    /*
      Person.prototype.compare = function (p1,p2)  {
        if (!typeof p1 === "string" ||!typeof p2 === "string" ) throw Error("p1 or p2 is not a string")
        return p1.localeComapare(p2)
     }*/


     let person2 = new Person("Viggo");
     let person3 = new Person("Xander");

     let studerende2 = new Studerende("Ida", 123);
     let studerende3 = new Studerende("Idal", 123);
     let studerende4 = new Studerende("Ida", 1234);


     console.log(person.equals);


     console.log("Tests");
     console.log(person.equals(person));
     console.log(person.equals(person2));
     console.log(person.equals(person3));
     console.log("Tests studerende");

     console.log(studerende.equals(studerende2));
     console.log(studerende.equals(studerende3));
     console.log(studerende.equals(studerende4));

     list = [] 
     list.push(person)
     list.push(person2)
     list.push(person3)
     list.push(studerende)
     list.push(studerende2)
     list.push(studerende3)
     list.push(studerende4)

     list.sort((a,b) => Person.compare(a.navn,b.navn))
     console.log(list);


     class Kat {
        constructor(navn) { this.navn = navn; }
        toString() { return 'Kat: ' + this.navn; };
    }

    let cat1 = new Kat("Hans")
    let cat2 = new Kat("Lotte")

    list.push(cat1)
    list.push(cat2)

    list.forEach(element => {
       console.log(element.toString());
    });

// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes
