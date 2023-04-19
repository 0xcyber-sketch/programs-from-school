
// opg 2.1
let list = [3, 5 , 2 , 4, 8 ,21];

let max = (list) => {
    let max = 0;
for (let i = 0; i < list.length; i++){
if (list[i] > max) {
    max = list[i];
}
}
return max;
};

console.log(max(list));

let contians = (list, n) => {
let i = 0;
found = false;
while (i < list.length && !found){
if (list[i] === n) {
    found = true;
} else {
    i++;
}
}
return found;
}
console.log(contians(list, 6)); // => false
console.log(contians(list, 3)); // => true

let sum = (list) => {
    let sum = 0;
for (let i = 0; i < list.length; i++){
    sum += list[i];
}
return sum;
};

console.log(sum(list));

// opg 2.2

// bubbleSort 


let swap = (i, j, list) => {
    
    let temp = list[i];
    list[i] = list[j];
    list[j] = temp;
}
let bubbleSort = (list) => {
    for (let i = list.length -1 ; i >= 0; i--){
        for (let j = 0; j <= i -1; j++) {
            if (list[j] > list[j+1]) {
                swap(j , j+1, list);
            }
        }
    }
   

}




let newList = [3, 5 , 2 , 4, 8 , 21];
bubbleSort(newList);
console.log(newList);

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

console.log(binarySearch(newList, 8));

// opg 2.3

let string1 = "hallo";
let string2 = "HAllo";

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

console.log(compare(string1, string2));

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

console.log(compareLen(string1, string2));

let compareIgnoreCase = (string, string2) =>{
    return compare(string.toLowerCase(),string2.toLowerCase())
}

console.log(compareIgnoreCase(string1, string2));

// Vil højst sandsynligt give en fejl, hvis det er en anden funtion
let bubbleSortCompare = (list, comparel) => {
    
    for (let i = list.length -1 ; i >= 0; i--){
        for (let j = 0; j <= i -1; j++) {
            if (comparel(list[j], list[j+1]) > 0 ) {
                swap(j , j+1, list);
            }
        }
    }
   

}

list = ['hej', 'kat', 'abe'];
bubbleSortCompare(list, compare)
console.log(list);

// opg 2.4
let text = "Hej jeg hedder Kaj Hej";

let words = text.split(" ");

let map = new Map();

for (let i = 0; i < words.length; i++){
    if (map.has(words[i])){
        map.set(words[i], map.get(words[i]) + 1);
    } else {
        map.set(words[i], 1);
    }
}

console.log(map);


// 2.5
// I JSON skal key være strings
let p1 = {name : 'Martin', email : 'mar@test.dk', phoneNumber : '45454545'};
let p2 = {name : 'Emil', email : 'e@test.dk', phoneNumber : '88888888'};
let p3 = {name : 'Mads', email : 'ma@test.dk', phoneNumber : '11223344'};
let p4 = {name : 'Capser', email : 'Ca@test.dk', phoneNumber : '11223774'};
let array = [p1, p2, p3];

console.log(array);
console.log(array[0].name);

array[3] = p4;

delete array[2];
console.log(array);


// 2.6 
let parenthesis = '"[[]][[]](){{}}';

let isBalanced = (string) => {
    let balanced = true;
    let stack = [];


    for (let e of string) {
        let temp;
        if (e === '[' || e === '(' || e === '{'){
            stack.push(e)
        }
        else if ( e === ']'){
            temp = stack.pop();
            if (temp !== '[') {
                balanced = false;
            }
        }
        else if ( e === '}'){
            temp = stack.pop();
            if (temp !== '{') {
                balanced = false;
            }
        }
        else if ( e === ')'){
            temp = stack.pop();
            if (temp !== '(') {
                balanced = false;
            }
        }
        

    }
    if (stack.length > 0) {
        balanced = false;
    }
    return balanced;
}

console.log(isBalanced(parenthesis))

// 2.7

arrayL = [1,2,32,1,234,31,3];

//arrayL[7] = max;
arrayL.max = max;


//console.log(arrayL[7](arrayL));
console.log(arrayL.max(arrayL));

arrayL.contians = contians;
console.log(arrayL.contians(arrayL, 3));
arrayL.sum = sum;
console.log(arrayL.sum(arrayL));
