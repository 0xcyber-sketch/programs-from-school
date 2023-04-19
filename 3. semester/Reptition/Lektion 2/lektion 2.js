// opgave 2.1


let max = (array) => {
    let max = 0

    for (const i of array) {
        if (i > max) {
            max = i
        }
    }
    return max
}

let contains = (array, element) => {
    let found = false
    let i = 0
    while (!found && i < array.length) {
        if (element === array[i]) {
            found = true
        }
        else {
            i++
        }
    }
    return found
}

let sum = (array) => {
    let sum = 0
    array.forEach(element => {
        sum += element
    });
    return sum
}
let array = [1, 2, 12, 11, 5, 29, 1, 34, 1, 23]

console.log(max(array));
console.log(contains(array, 8));
console.log(sum(array));


// opge 2.2
let bubbleSort = function (list) {
    let newList = list
    let swap = function (i, j) {
        let temp = newList[i]
        newList[i] = newList[j]
        newList[j] = temp

    }
    for (let i = newList.length - 1; i >= 0; i--) {
        for (let j = 0; j <= i - 1; j++) {
            if (list[j] > list[j + 1]) {
                swap(j, j + 1)
            }
        }
    }


    return newList
}





// Opgave 1.3

let binarySearch = (list, result) => {
    let start = 0
    let end = list.length - 1
    let i = 0;

    while (start <= end) {
        let mid = Math.floor((start + end) / 2)
        if (list[mid] === result) return i = mid
        else if (mid < result) {
            start = mid
        } else {
            end = mid
        }
    }
}

let array2 = [5, 2, 761, 3]
console.log(bubbleSort(array2));

// opgave 2.3
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

let bubbleSortCompare = function (list, compare) {
    let newList = list
    let swap = function (i, j) {
        let temp = newList[i]
        newList[i] = newList[j]
        newList[j] = temp

    }
    for (let i = newList.length - 1; i >= 0; i--) {
        for (let j = 0; j <= i - 1; j++) {
            if (compare(list[j], list[j + 1]) === 1) {
                swap(j, j + 1)
            }
        }
    }


    return newList
}

let list = ["Mads", "Barsøe", "Emil"]
console.log(bubbleSortCompare(list, compare))

let split = (string) => {
    let result = new Object()

    string.split(" ").forEach(element => {
        if (!result.hasOwnProperty(element)) {
            result[element] = 1
        } else {
            result[element] = result[element] + 1
        }
    });
    return result

}
let str = "Hej jeg er en kanin, og jeg kan lide at hoppe og spise gulerødder"

// opgave 2.5

let personer = [{navn :"Emil", email : "e@mail.dk", mobil : "5363537"}, 
{navn :"Mads", email : "m@mail.dk", mobil : "536323537"},
{navn :"Barsøe", email : "J@mail.dk", mobil : "536903537"}]


let createP = (name, mail, phoneNumber) => {
    let p = {navn : name, email : mail, mobil : phoneNumber}
    personer.push(p)
}

let readP = () => {
    console.log(personer)
}

let updateP = (i , prop, value) => { 
    personer[i][prop] = value
}

let deleteP = (i) => {
    delete personer[i]
}

readP()
createP("Hans", "h@mail.dk", "2324535")
readP()
updateP(personer.length - 1, 'navn', "Mikkel")
readP()
deleteP(2)
readP()

// opg 2.6 

let ballanced = (str) => {
    let stack = []

    let left = ["(", "{", "["] 
    let right = [")", "}", "]"] 

    for (let i = 0; i < str.length; i++)  {
        if (left.includes(str.charAt(i))) {
            stack.push(str.charAt(i))
        }
        else if (right.includes(str.charAt(i))) {
            let j = right.indexOf(str.charAt(i))
            if (stack[stack.length -1] === left[j]) {
                stack.pop()
            }
        }
    }
    console.log(stack.length)
    console.log(stack)

    if (stack.length === 0) {
        return true
    }
    return false

}

str = "{[{[][}]{[]]}"

let str2 = "{[()]}"
console.log(ballanced(str));
console.log(ballanced(str2));


// opg. 2.7
array = [27, 28,2, 2,54, 3]

array.max = function() {
    let max = 0 
    for (let i = 0; i < array.length; i++) {
        if (max < array[i]) {
            max = array[i]
        }
    }
    return max
}

array.contains = function(number) {
    let found = false 
    let i = 0

    while (i < array.length && !found) {
        if (number === array[i]) {
            found = true
        } 
        else {
            i++
        }
    }
    return found
}

array.sum = function() {
    let sum = 0

    array.forEach(element => {
        sum += element
    });
    return sum
}


console.log(array.max());
console.log(array.contains(54));
console.log(array.sum());