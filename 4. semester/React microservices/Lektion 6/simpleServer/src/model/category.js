class Category {
    #count
    #category

    constructor(count, category) {
        this.#category = category
        this.#count = count
    }

    get count() {
        return this.#count;
    }

    get category() {
        return this.#category;
    }

    toJSON() {
        return {category: this.category, count: this.count}
    }
}

module.exports = {Category}