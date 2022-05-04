const mongoose = require('mongoose')

function buildModel() {
    return mongoose.model("films", new mongoose.Schema({
        id: Number,
        name: String,
        poster: String,
        price: Number
    }))
}


function getMongoConnection(url) {
    return mongoose.connect(url, {
        useNewUrlParser: true, useUnifiedTopology: true
    })
}

module.exports = {
    buildModel,
    getMongoConnection
}
