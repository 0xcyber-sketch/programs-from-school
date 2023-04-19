class StringStack {
    #stack = []
    #size = 0

    push(e) {
        if (!typeof e === "string") throw Error("Element e is not a string object")
        this.#stack.push(e)
        this.#size++
    }
    pop() {
        let temp = this.#stack.pop()
        this.#size--
        return temp
    }

    getStack(){
        return Array.from(this.#stack)
    }
    getSize(){
        return this.#size
    }
}

let stack = new StringStack()

let s3 = "hej"
let s2 = "med"
let s1 = "dig"

stack.push(s1)
stack.push(s2)
stack.push(s3)

console.log(stack.getSize());
console.log(stack.getStack());

console.log(stack.pop());
console.log(stack.getSize());
console.log(stack.getStack());
console.log(stack.pop());
console.log(stack.getSize());
console.log(stack.getStack());
console.log(stack.pop());
console.log(stack.getSize());
console.log(stack.getStack());

