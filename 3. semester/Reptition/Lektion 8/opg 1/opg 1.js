const persons = [
    {name:"Emil", age:"21", mobile:"60818826"}, 
    {name:"Magnus", age:"18", mobile:"29292929"},
    {name:"Mikkel", age:"49", mobile:"22478187"},
    {name:"Alex", age:"21", mobile:"22478188"}
]

// Find person med et bestemt mobilnummer.  
console.log(persons.find((element => element.mobile === "60818826")));

// reduce /alder < minimum ? alder : minimum ternary operator
console.log(persons.map((element => element.age)).reduce(((min, age) => {
    if (age < min) {
        min = age
    }
    return min
}
)))

// modificer arrayet
let id = 1
persons.forEach(element =>  {
    element.id = "" + id++
})

console.log(persons);

// komma sepereret string


console.log(persons.map((element => element.name)).sort().reduce((names, name) => names += ", " + name))

// filter
console.log(persons.filter((element => parseInt(element.age) < 30)));
