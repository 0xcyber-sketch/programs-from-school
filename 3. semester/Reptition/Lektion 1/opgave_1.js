// opgave 1.2 

let list = ["Mads", "Emil", "Jacob"]

function bubbleSort(list) {
    let newList = list
    for (let i = newList.length - 1; i >= 0; i--) {
        for (let j = 0; j <= i - 1; j++) {
            if (newList[j] > newList[j + 1]) {
                let temp = list[j];
                newList[j] = newList[j + 1];
                newList[j + 1] = temp;
            }
        }
    }
    return newList
}


console.log(bubbleSort(list))

// Opgave 1.3

let binarySearch = (list, result) => {
let start = 0
let end = list.length - 1
let i = 0;

while (start <= end) {
    let mid = Math.floor( (start + end) / 2)
    if (list[mid] === result) return i = mid
    else if (mid < result) {
        start = mid
    } else {
        end = mid
    }
}

}
list = [1, 2 ,4 ,7, 12, 23, 43, 54, 65, 100]
console.log(binarySearch(list, 65))


// opg 1.4 

let merge = (list1, list2) => {
let newList = []
let i1 = 0
let i2 = 0

while (l1 < list1.length && l2 < list2) {
    if (list1[i1] < list2[i2]) {
        newList.push(list1[l1])
        i1++
    } else {
        newList.push(list2[l2])
        i2++
    }
}

while (i1 < list1.length) {
    newList.push(list1[l1])
        i1++
}

while (i2 < list2.length) {
    newList.push(list1[l2])
        i2++
}
return newList

}

// opg. 1.5

function isPrime(n)
{
    // Corner case
    if (n <= 1)
        return false;
  
    // Check from 2 to n-1
    for (let i = 2; i < n; i++)
        if (n % i == 0)
            return false;
  
    return true;
}

function printPrimeNumbers(integer) {
    let num = 2
    while (num <= integer) {
        if (num === 2) {
            console.log(2)
        }
        else {
            if (isPrime(num)) {
                console.log(num);
            }
        }
        num++
    }

}
printPrimeNumbers(100)