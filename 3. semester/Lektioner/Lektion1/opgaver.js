// 25/08/21
// Opgave 1.2
let list = ["h","a", "z", "d", "e", "ee", "da"];

for (let i = list.length -1 ; i >= 0; i--){
    for (let j = 0; j <= i -1; j++) {
        if (list[j] > list[j+1]) {
            let temp = list[j];
            list[j] = list[j+1];
            list[j+1] = temp;
        }
    }
}

console.log(list);

// Opgave 1.3
function binarySearch(list, target){
    let index = -1;
    let left = 0;
    let right = list.length - 1;

    while (index == -1 && left <= right){
        let middle = parseInt((left + right)/2);
        let k = list[middle];
        if (k == target){
            index = middle;
        }
        else if ( k < target ){
            left = middle +1;
        }
        else {
            right = middle -1;
        }
    }
    return index;
}



console.log(binarySearch(list, "e"));

// Opgave 1.4

let list2 = ["d", "x", "z"];


function merge(s1, s2){
    let result = [];
    let i1 = 0;
    let i2 = 0;

    while(i1 < s1.length && i2 < s2.length){
        if (s1[i1] < s2[i2]){
            result.push(s1[i1]);
            i1++;
        } else {
            result.push(s2[i2]);
            i2++;
        }
    }

    while (i1 < s1.length){
        result.push(s1[i1]);
        i1++;
    }
    while (i2 < s2.length){
        result.push(s2[i2]);
        i2++;
    }
    return result;
}

console.log("Opgave 1.4");
console.log(merge(list, list2));

// opgave 1.5

/*
let tal1 = 2;
let tal2 = 100;
let found = false;


    for (let i = 1; i <= tal2; i++){
    while (tal1 <= tal2 && !found){
    
        if ( tal1 % i === 0){
            
            found = true;  
        }
        else {
            
            tal1++;
        }

    }

    if (found){
        console.log(tal1);
        tal1++;
        found = false;
        
    }
}
    */
//https://www.programiz.com/javascript/examples/prime-number
function isPrime(number){
    let prime = true;
    if (number === 0 || number === 1){
        return !prime;
    }
    else if (number > 1){
        for(let i = 2; i < number; i++){
            if (number % i === 0){
                return !prime;
            }
        }
    }
    return prime;
}

let number = 101;

for (let x = 1; x <= number; x++){
    if (isPrime(x)){
        console.log(x);
    }
}




