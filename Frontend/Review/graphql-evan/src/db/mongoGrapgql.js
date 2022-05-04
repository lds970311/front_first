const express = require('express')
//引入graphQL
const {buildSchema} = require('graphql')
const graphqlHttp = require('express-graphql')
const app = express()
const {getMongoConnection, buildModel} = require("../db/db")

getMongoConnection("mongodb://192.168.208.129:27017/maizuo")
    .then(res => console.log("connected to mongod"))
    .catch(err => console.error(err))

const fileModel = buildModel()

const schema = buildSchema(`
    type Film {
       id:Int,
       name:String,
       poster:String,
       price:Int
   }
   
   input FilmInput {
        name:String,
        poster:String,
        price:Int
   }
   
   type Mutation {
        createFilm(input: FilmInput):Film,
        updateFilm(id:Int!,input:FilmInput):Film,
        deleteFilm(id:Int!):Int
    }
`)
const root = {
    getNowplayingList() {
        return fileModel.find()
    },

    createFilm({input}) {
        return fileModel.create({...input})
    },
    updateFilm({id, input}) {
        return fileModel.updateOne({
            _id: id
        }, {
            ...input
        }).then(res => fileModel.find({_id: id})).then(res => res[0])
    },
    deleteFilm({id}) {
        return fileModel.deleteOne({_id: id}).then(res => 1)
    }
}

app.use('/graphql', graphqlHttp({
    schema: schema,
    rootValue: root,
    graphiql: true
}))

app.listen(12889, () => {
    console.log("app listening on port 12889")
})
