const uuid = require('uuid').v4
const moment = require('moment');

class Advertisement {
    #id
    #category
    #type
    #text
    #header
    #price
    #created
    #imageUrl
    #userId
    static categories = ["CAR", "MC", "BICYCLE", "TOOL", "HORSE"]
    static types = ["SALE", "LEASE", "PURCHASE"]

    constructor(category, type, header, text, price, imageUrl, userId) {
        if (!Advertisement.categories.includes(category)) {
            throw new Error("Category illegal")
        }
        this.#id = uuid()
        this.#category = category
        this.#type = type
        this.#text = text
        this.#header = header
        this.#price = price
        this.#imageUrl = imageUrl
        this.#created = moment()
        this.#userId = userId
        this.#userId = userId;
    }


    get category() {
        return this.#category;
    }

    get type() {
        return this.#type;
    }

    get header() {
        return this.#header;
    }

    get text() {
        return this.#text;
    }

    get price() {
        return this.#price;
    }

    get imageUrl() {
        return this.#imageUrl;
    }

    get id() {
        return this.#id;
    }

    get created() {
        return this.#created;
    }

    get userId() {
        return this.#userId;
    }

    toJSONOverview() {
        return {
            id: this.id,
            category: this.category,
            type: this.type,
            header: this.header,
            price: this.price,
            imageUrl: this.imageUrl,
        }
    }

    toJSON() {
        return {
            id: this.id,
            category: this.category,
            type: this.type,
            header: this.header,
            text: this.text,
            price: this.price,
            created: this.created.format("yyyy-MM-DD,HH:mm:ss"),
            imageUrl: this.imageUrl,
            userId: this.userId
        }
    }
}

module.exports = {Advertisement}