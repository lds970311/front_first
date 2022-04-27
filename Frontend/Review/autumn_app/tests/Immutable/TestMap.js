const Immutable = require('immutable')


const map1 = Immutable.Map({
    a: 1,
    b: 2,
    c: 3
})

const map2 = map1.set('a', 30)

// console.log(map1)
// console.log(map2)


console.log(map1.toJS());
console.log(map2.toJS());
