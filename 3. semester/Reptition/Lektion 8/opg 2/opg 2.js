
let compareSort = function(compare) {

    return function sort(array) {
        return array.sort(compare)
    }
}


let compare = (s1, s2) => {
    let value = 0
    if (s1 < s2) {
        value = -1
    }
    else if (s1 > s2) {
        value = 1
    }
    else {
        value = 0
    }
    return value
}

let compareLen = (s1, s2) => {
    return compare(s1.length, s2.length)
}

let compareIgnorecase = (s1, s2) => {
    return compare(s1.toLowerCase(), s2.toLowerCase())
}

let array = ["Hej", "Emil", "aelxss", "Drama"]

let compareeLen = compareSort(compareLen)
console.log(compareeLen(array))

let compareeIC = compareSort(compareIgnorecase)
console.log(compareeIC(array));


