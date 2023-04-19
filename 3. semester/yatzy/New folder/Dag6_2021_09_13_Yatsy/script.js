let throwCount = 0;
let values = [0, 0, 0, 0, 0];

values.getValues = function () {
    let copy = [];
    for (let i = 0; i < values.length; i++) {
        copy[i] = values[i];
    }
    return copy;
}
let holds = [false, false, false, false, false];


//hold terning
function hold(x) {
    if (holds[x] == false) {
        holds[x] = true;
        document.getElementById("dices").getElementsByTagName("IMG")[x].classList.add("hold");
    } else {
        holds[x] = false;
        document.getElementById("dices").getElementsByTagName("IMG")[x].classList.remove("hold");
    }
}

//terning kast
function throwDice() {
    if (throwCount < 3) {
        throwCount++;
        for (let i = 0; i < holds.length; i++) {
            if (!holds[i]) {
                values[i] = Math.floor(Math.random() * 6 + 1);
            }
        }
    }
    results();
    changeHTML();
}

//
function calcCount() {
    let count = [0, 0, 0, 0, 0, 0, 0];
    for (let face of values) {
        count[face]++;
    }
    return count;
}

let resultat = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
//resultat arrayet
function results() {
    for (let i = 0; i < 6; i++) {
        resultat[i] = sameValuePoints(i + 1);
    }
    resultat[6] = samePoint(2);
    resultat[7] = twoPairs();
    resultat[8] = samePoint(3);
    resultat[9] = samePoint(4);
    resultat[10] = fullHouse();
    resultat[11] = smallStraight();
    resultat[12] = largeStraight();
    resultat[13] = chance();
    resultat[14] = yatzy();
}

function sameValuePoints(face) {
    return calcCount()[face] * face;
}

function samePoint(amount) {
    let max = 0;
    let resultarr = calcCount();
    for (let i = 1; i < resultarr.length; i++) {
        if (resultarr[i] >= amount) {
            max = i * amount;
        }
    }
    return max;
}

function twoPairs() {
    let max1 = 0;
    let max2 = 0;
    let resultarr = calcCount();
    for (let i = 1; i < resultarr.length; i++) {
        if (resultarr[i] >= 2) {
            max2 = max1;
            max1 = i * 2;
        }
    }
    if (max2 == 0) {
        sum = 0;
    } else {
        sum = max1 + max2;
    }
    return sum;
}

function fullHouse() {
    let max = 0;
    let maxPair = 0;
    let maxTripple = 0;
    let resultarr = calcCount();
    for (let i = 1; i < resultarr.length; i++) {
        if (resultarr[i] >= 3) {
            maxTripple = i * 3;
        } else if (resultarr[i] >= 2) {
            maxPair = i * 2;
        }
    }
    if (maxPair != 0 && maxTripple != 0) {
        max = maxPair + maxTripple;
    }
    return max;
}

function smallStraight() {
    let max = 0;
    let counter = 0;
    let resultarr = calcCount();
    for (let i = 1; i < resultarr.length - 1; i++) {
        if (resultarr[i] == 1) {
            counter++;
        }
    }
    if (counter == 5) {
        max = 15;
    }
    return max;
}

function largeStraight() {
    let max = 0;
    let counter = 0;
    let resultarr = calcCount();
    for (let i = 2; i < resultarr.length; i++) {
        if (resultarr[i] == 1) {
            counter++;
        }
    }
    if (counter == 5) {
        max = 20;
    }
    return max;
}

function chance() {
    let max = 0;
    let resultarr = values.getValues();
    for (let i of resultarr) {
        max += i;
    }
    return max;
}

function yatzy() {
    let max = 0;
    if (samePoint(5) != 0) {
        max = 50;
    }
    return max;
}

throwDice(holds);
changeHTML();

// change html
function changeHTML() {
    let diceImages = document.getElementById("dices").getElementsByTagName("IMG");
    for (let i = 0; i < diceImages.length; i++) {
        diceImages[i].setAttribute("src", "img/dice" + values[i] + ".png");
        if (holds[i] == false) {
            diceImages[i].classList.remove("spin");
            setTimeout(function() {diceImages[i].classList.add("spin")}, 10);
        }
    }
    document.getElementById("turn").innerHTML = throwCount;
    if (throwCount == 3) {
        document.getElementById("throw_button").disabled = true;
    }
    for (let i = 0; i < resultat.length; i++) {
        if (!document.getElementsByClassName("point_box")[i].classList.contains("active")){
            document.getElementById("result_" + i).innerHTML = resultat[i];
        }
    }
    let total = 0;
    let smallTotal = 0;
    for (let i = 0; i < resultat.length; i++) {
        if (document.getElementsByClassName("point_box")[i].classList.contains("active")){
            total += parseInt(document.getElementById("result_" + i).innerHTML);
            if (i < 6) {
                smallTotal += parseInt(document.getElementById("result_" + i).innerHTML);
            }
        }
    }
    document.getElementById("sum").innerHTML = smallTotal;
    if (smallTotal >= 63) {
        total += 50;
        document.getElementById("bonus").innerHTML = 50;
    }
    document.getElementById("total").innerHTML = total;
    document.getElementById("score").innerHTML = total;
}

//vælg point 
function choose(x) {
    document.getElementsByClassName("point_box")[x].classList.add("active");
    document.getElementById("points").getElementsByTagName("A")[x].setAttribute("onclick", " ");
    document.getElementById("throw_button").disabled = false;
    for (let i = 0; i < holds.length; i++) {
        holds[i] = false;
        document.getElementById("dices").getElementsByTagName("IMG")[i].classList.remove("hold");
    }
    throwCount = 0;
    throwDice();
    let done = true;
    for (let i = 0; i < resultat.length; i++) {
        if (!document.getElementsByClassName("point_box")[i].classList.contains("active")) {
            done = false;
        }
    }
    if (done) {
        document.getElementById("popup").classList.remove("none");
    }
}

function reload() {
    location.reload();
}