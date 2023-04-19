const repository = require('../repository/repository')


function authenticateUserByEmail(email, password) {
    const user = repository.getUserByEmail(email)
    if (user && user.password === password) {
        return user
    }
    return false
}

function authenticateUserByUserName(userName, password) {
    const user = repository.getUserByUserName(userName)
    if (user && user.password === password) {
        return user
    }
    return false
}

function signupUser(userName, email, password) {
    if (repository.getUserByUserName(userName) || repository.getUserByEmail(email)) {
        return false
    } else {
        repository.createUser(userName, email, password)
        console.log(`created user with user name ${userName}`)
        return true
    }
}

function authenticateSessionName(userId) {
    return repository.getUserById(userId) !== undefined
}

function getUserById(id) {
    console.log("GETUSER BY ID" + id)
    return repository.getUserById(id)
}

function getUserByUserName(userName) {
    return repository.getUserByUserName(userName)
}

module.exports = {
    authenticateUserByUserName,
    authenticateUserByEmail,
    signupUser,
    authenticateSessionName,
    getUserById,
    getUserByUserName
}