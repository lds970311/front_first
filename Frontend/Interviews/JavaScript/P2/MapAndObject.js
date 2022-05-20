//Map和Object的区别

const map = new Map();

map.set(1, {
    name: "suse",
    age: 12
})

// console.log(map.get(1))

map.forEach((value, key) => {
    console.log(`key: ${key}, value: ${value}`)
})


const obj = {
    name: "jack",
    age: 13,
    time: 2233,
    [Symbol.iterator]: function () {
        let keys = Object.keys(this);
        let length = keys.length;
        let cur = 0;
        return {
            next: () => {
                return {
                    value: this[keys[cur]],
                    done: cur++ === length
                }
            }
        }
    }
}

for (const objElement of obj) {
    console.log(objElement)
}
