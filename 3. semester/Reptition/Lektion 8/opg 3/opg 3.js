
let compareSort = function(compare) {
    if (typeof(compare) !== "function") throw Error("parameter is not a function")

    return function sort(array) {
        if (array.length === 0) throw Error("Array is empty")
        let type = typeof array[0]
        if (type !== 'number' && type !== 'string') throw Error('not correct type')
        if (!array.every(e => typeof e === type)) throw Error('not same type');
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

let array = ["Hej", "Emil", "aelxss", "Drama" ]

let compareeLen = compareSort(compareLen)
console.log(compareeLen(array))

let compareeIC = compareSort(compareIgnorecase)
console.log(compareeIC(array));




