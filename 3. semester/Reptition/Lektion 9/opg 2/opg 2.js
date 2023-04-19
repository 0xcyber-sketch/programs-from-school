class StringStack {
    constructor() {
        this.#stack = []
    }
    #stack
    pop() {this.#stack.pop()}
    push(str) {if (typeof (str) !== "string") throw Error ("Not a string")
        this.#stack.push(str)
            }
    getSize() {return this.#stack.length}
}

let stack = new StringStack()

stack.push("Hello")
console.log(stack.getSize());
stack.pop()
console.log(stack.getSize());