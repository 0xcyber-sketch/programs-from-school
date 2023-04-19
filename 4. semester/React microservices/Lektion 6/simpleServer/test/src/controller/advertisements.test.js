const {getCategories, createAdvertisement} = require('../../../src/controller/advertisements')
const {signupUser, getUserByUserName} = require('../../../src/controller/users')
const {Advertisement} = require("../../../src/model/advertisement");
describe("Categories", () => {

    test("Get Categories ", () => {

        //precondition
        expect(getCategories()[Advertisement.categories.indexOf('TOOL')].count).toBe(0)
        //prepare
        signupUser("hans", "hans", "hans")
        const id = getUserByUserName("hans").id
        createAdvertisement({
            userId: id,
            category: "TOOL",
            type: "SALE",
            header: "header",
            text: "text",
            price: 123,
            imageUrl: "url"
        })

        //act
        const result = getCategories()

        // Assert
        expect(result.length).toBe(Advertisement.categories.length)
        expect(result[Advertisement.categories.indexOf('TOOL')].count).toBe(1)
    })
})