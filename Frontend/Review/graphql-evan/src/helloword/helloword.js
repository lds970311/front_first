const express = require('express')
//引入graphQL
const {buildSchema} = require('graphql')
const graphqlHttp = require('express-graphql')
const app = express()

const schema = buildSchema(`

   type Account{
       name:String,
       age:Int,
       location:String
   }

   type Film{
       id:Int,
       name:String,
       poster:String,
       price:Int
   }
   
   input FilmInput{
        name:String,
        poster:String,
        price:Int
   }

   type Query{
       hello: String,
       getName: String,
       getAge :Int,
       getAllNames:[String],
       getAllAges:[Int],
       getAccountInfo: Account,
       getNowplayingList:[Film],
       geteFilmDetail(id:Int!):Film
   }
   
    type Mutation{
        createFilm(input: FilmInput):Film,
        updateFilm(id:Int!,input:FilmInput):Film,
        deleteFilm(id:Int!):Int
    }
`);

let faskeDb = [
    {
        id: 1,
        name: "1111",
        poster: "http://1111",
        price: 100,
    },
    {
        id: 2,
        name: "2222",
        poster: "http://2222",
        price: 200,
    },
    {
        id: 3,
        name: "3333",
        poster: "http://333",
        price: 300,
    },
];

const root = {
    hello: () => {
        //通过数据库查
        var str = "hello wolrd1111";

        return str;
    },
    getName: () => {
        return "kerwin";
    },
    getAge: () => {
        return 100;
    },

    getAllNames: () => {
        return ["kerwin", "teichui", "xiaoming"];
    },
    getAllAges() {
        return [19, 20, 200];
    },

    getAccountInfo() {
        return {
            name: "kerwin",
            age: 100,
            location: "dalian",
        };
    },

    getNowplayingList() {
        return faskeDb;
    },
    geteFilmDetail({id}) {
        console.log(id);

        return faskeDb.filter((item) => item.id === id)[0];
    },
    createFilm({input}) {
        const obj = {...input, id: faskeDb.length + 1}
        faskeDb.push(obj)
        return obj
    },
    updateFilm({id, input}) {
        let current = null;
        faskeDb = faskeDb.map((item) => {
            if (item.id === id) {
                current = {...item, ...input};
                return {...item, ...input};
            }

            return item;
        });

        return current;
    },
    deleteFilm({id}) {
        faskeDb = faskeDb.filter(item => item.id !== id)
    }
};

app.get('/', (req, res, next) => {
    res.send('hello world')
})

app.use('/graphql', graphqlHttp({
    schema,
    rootValue: root,
    graphiql: true
}))

app.listen(12888, () => {
    console.log("app listening on port 12888")
})
