let Chef = function() {
    this.dishes = ['Dosa', 'Tea', 'Pokoras', 'Pav Bhaji']
    this.customers = 5
}

Chef.prototype.cheackMenu = function() {
    let dish = this.dishes[Math.floor(Math.random() * this.dishes.length)]

    // return a string
    // returns a random dish from dishes
    console.log("I will like to have", dish);
    return dish
}


// npm i --save-dev mocha chai
let chef = new Chef()

//module.exports = chef;
export default chef


