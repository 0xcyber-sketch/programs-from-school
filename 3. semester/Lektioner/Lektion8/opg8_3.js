'use strict';
// https://stackoverflow.com/questions/456177/function-overloading-in-javascript-best-practices?page=1&tab=votes#tab-top

// Ooagve 2.3
let compare =(string, string2) => {
    if (string < string2) {
        return -1;
    } else if (string > string2) {
        return 1;
    }
    else {
        return 0;
    }
}

let compareLen =(string, string2) =>
{
    if (string.length < string2.length)
    return -1;
    else if (string.length > string2.length){
    return 1
    }
    else {
        return 0;
    }
}


let compareIgnoreCase = (string, string2) =>{
    return compare(string.toLowerCase(),string2.toLowerCase())
}

// opgave 8.3
function compareSort(comparel, list) {
    // Argument 0 function check
    if (!comparel instanceof Function) throw Error("First arg isn't a function")

    // Agrgument 1 list/array check
    if (list.length === 0) throw Error("No data to sort");
    let typeOfData = typeof list[0]
    if (typeOfData !== 'number' && typeOfData !== 'string') throw Error("List consists of wrong types of elements");
    if (!list.every(e => typeof e === typeOfData)) throw Error("Lists elements aren't the same type");


    return list.sort((a,b) => comparel(a,b))
}

let list = ["Emil", "Hans", "emil", "Tor", "Alexander", "Julie"]



console.log(compareSort(compareIgnoreCase, list));

//list = [8, 9 , 7]
//console.log(compareSort(compare, list));

// No data
//list = []
//console.log(compareSort(compareIgnoreCase, list));

// Wrong elements
//list = [{name : "heh"}]
//console.log(compareSort(compareIgnoreCase, list));

// Aren't same type
//list = ["hej", 78]
//console.log(compareSort(compareIgnoreCase, list));

// no function
//console.log(compareSort(23, list));




