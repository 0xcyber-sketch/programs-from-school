'use strict';

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

// opgave 8.2
function compareSort(comparel, list) {
    return list.sort((a,b) => comparel(a,b))
}

let list = ["Emil", "Hans", "emil", "Tor", "Alexander", "Julie"]

console.log(compareSort(compare, list));
console.log(compareSort(compareIgnoreCase, list));
console.log(compareSort(compareLen, list));

let normalCompare = compareSort(compare, list)
console.log(normalCompare);
