const {Advertisement} = require('../model/advertisement')
const {User} = require('../model/user')
const {Category} = require('../model/category')

class Advertisements {
    #advertisements

    constructor() {
        this.#advertisements = new Map()
    }

    createAdvertisement(userId, category, type, header, text, price, imageUrl) {
        const ad = new Advertisement(category, type, header, text, price, imageUrl, userId)
        this.#advertisements.set(ad.id, ad)
        return ad
    }

    getAdvertisementById(adId) {
        return this.#advertisements.get(adId)
    }

    getAdvertisementsByUserId(userId) {
        return Array.from(this.#advertisements.values()).filter(a => a.userId === userId)
    }

    getAdvertisementsByCategory(category) {
        return Array.from(this.#advertisements.values()).filter(a => a.category === category)
    }

    getAdvertisements(category, userId) {
        return Array.from(this.#advertisements.values())
            .filter(a => !category || a.category === category)
            .filter(a => !userId || a.userId === userId)
    }

    getCategoryCount(category) {
        const count = Array.from(this.#advertisements.values()).filter(a => a.category === category).length
        return count
    }

    getCategories() {
        return Advertisement.categories.map(c => new Category(this.getCategoryCount(c), c))
    }
}

class Users {
    #users

    constructor() {
        this.#users = new Map()
    }

    createUser(userName, email, password) {
        if (this.hasUser(userName, email)) {
            throw new Error("user exists")
        }
        const user = new User(userName, email, password)
        this.#users.set(user.id, user)
    }

    getUserByEmail(email) {
        return Array.from(this.#users.values()).find(u => u.email === email)
    }

    getUserByUserName(userName) {
        return Array.from(this.#users.values()).find(u => u.userName === userName)
    }

    getUserById(id) {
        return this.#users.get(id)
    }

    hasUser(userName, email) {
        return this.getUserByEmail(email) || this.getUserByUserName(userName)
    }
}

const advertisements = new Advertisements()
const users = new Users()


function getAdvertisementsByUserId(userId) {
    return advertisements.getAdvertisementsByUserId(userId)
}

function createUser(userName, email, password) {
    users.createUser(userName, email, password)
}

function createAdvertisement(userId, category, type, header, text, price, imageUrl) {
    console.log("THE USER ID" + userId)
    if (!users.getUserById(userId)) {
        throw new Error("user does not exist")
    }
    return advertisements.createAdvertisement(userId, category, type, header, text, price, imageUrl)
}

function getCategories() {
    return advertisements.getCategories()
}

function getUserByUserName(userName) {
    return users.getUserByUserName(userName)
}

function getUserByEmail(email) {
    return users.getUserByEmail(email)
}

function getUserById(id) {
    return users.getUserById(id)
}

function getAdvertisementsByCategory(category) {
    return advertisements.getAdvertisementsByCategory(category)
}

function getAdvertisements(category, userId) {
    return advertisements.getAdvertisements(category,userId)
}

function getAdvertisementById(adId) {
    return advertisements.getAdvertisementById(adId)
}

function getCategoryEnum() {
    return Advertisement.categories
}

function getTypeEnum() {
    return Advertisement.types
}

module.exports = {
    getUserByUserName,
    getUserByEmail,
    createUser,
    createAdvertisement,
    getAdvertisementsByUserId,
    getCategories,
    getAdvertisementsByCategory,
    getUserById,
    getAdvertisementById,
    getCategoryEnum,
    getTypeEnum,
    getAdvertisements
}



