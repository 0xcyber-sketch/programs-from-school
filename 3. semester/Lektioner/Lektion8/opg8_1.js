// Opgave 8.1


users = [
    {
        name : "Emil",
        age : 20,
        phone : "60818826"
    },
    {
        name : "Mikkel",
        age : 48,
        phone : "22478187"
    }, 
    {
        name : "Magnus",
        age : 18,
        phone : "67676767"
    },
    {
        name : "Charlotte",
        age : 51,
        phone : "22476267"
    }

]

// filter example
startsWithM = (string) => string.toLowerCase().startsWith('m');

namesStartingWithM = users.filter((user) => startsWithM(user.name));
console.log(namesStartingWithM);



// Get Specific number
specificNumber = (string) => {
    //console.log(0 === string.localeCompare('60818826'))
    return (0 === string.localeCompare('60818826'))
}

// Do not enclose method/function in {}
getSpecificNumber = users.filter((user) => specificNumber(user.phone));

console.log(getSpecificNumber)


console.log("Min age");
// min age

console.log(users.sort((a,b) => a.age - b.age)[0]);

let id = 0;
users.forEach(element => {
    element.id = id++
});

// Modify users
console.log(users);

// Tekst streng

console.log("tekst strng");

compareString = (a,b) => {
    return a.localeCompare(b)
}
textString = ""
users.sort((a,b) => compareString(a.name, b.name)).forEach(e => textString += e.name + ",\n")
console.log(textString)


// New array 



under30 = (age) => {
    return (age < 30)
}
newArray = users.filter((user) => under30(user.age))
//.map(user => ({user.name, user}))
console.log(newArray);


