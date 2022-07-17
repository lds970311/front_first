const obj = {
    value: 1,
    get a() {
        return this.value++;
    }
}


let res = obj.a === 1 && obj.a === 2 && obj.a === 3
console.log(res)

let obj1 = {
    a: 1
}
