const http = require ('http')
const figlet = require('figlet')

http.createServer((request, response) => {
    response.writeHead(200)
    figlet.text('Hello World', (error, data) =>{
        if (error) throw new error
        response.write(data)
        response.end()
    } )
    
}).listen(8080)
console.log("listening on port: 8080");