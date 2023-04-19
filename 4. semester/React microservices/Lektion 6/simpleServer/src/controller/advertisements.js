const repository = require('../repository/repository')

function getCategories() {
    return repository.getCategories()
}

function createAdvertisement(adDTO) {
    return repository.createAdvertisement(adDTO.userId, adDTO.category, adDTO.type, adDTO.header, adDTO.text, adDTO.price, adDTO.imageUrl)
}

function getAdvertisements(category, userId) {

    return repository.getAdvertisements(category, userId)
}

function getAdvertisementsByCategory(category) {
    return repository.getAdvertisementsByCategory(category)
}

function getAdvertisementsByUser(id) {
    return repository.getAdvertisementsByUserId(id)
}

function getAdvertisementById(adId) {
    return repository.getAdvertisementById(adId)
}

function getCategoryEnum() {
    return repository.getCategoryEnum()
}

function getTypeEnum() {
    return repository.getTypeEnum()
}

module.exports = {
    getCategories,
    getAdvertisementsByCategory,
    getAdvertisementsByUser,
    getAdvertisementById,
    getCategoryEnum,
    getTypeEnum,
    createAdvertisement,
    getAdvertisements
}