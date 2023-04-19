const uuid = require('uuid').v4

class User {
    #id
    #userName
    #email
    #password

    constructor(userName, email, password) {
        this.#id = uuid()
        this.#email = email
        this.#userName = userName
        this.#password = password
    }


    get id() {
        return this.#id;
    }

    get userName() {
        return this.#userName;
    }

    get email() {
        return this.#email;
    }

    get password() {
        return this.#password;
    }

    toJSON() {
        return {
            id: this.id,
            userName: this.userName,
            email: this.email,
        }
    }
}

module.exports = {User}