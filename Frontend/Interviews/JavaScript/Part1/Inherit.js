//CREATE AT: 2021-12-27
//js继承

function objectCopy(obj) {
    /*function Fun() {
    };
    Fun.prototype = obj;
    return new Fun();*/
    return Object.create(obj);
}

function inheritPrototype(child, parent) {
    let prototype = objectCopy(parent.prototype); // 创建对象
    prototype.constructor = child; // 增强对象
    Child.prototype = prototype; // 赋值对象
}

function Parent(name) {
    this.name = name;
    this.friends = ["rose", "lily", "tom"]
}

Parent.prototype.sayName = function () {
    console.log(this.name);
}

function Child(name, age) {
    Parent.call(this, name);
    this.age = age;
}

inheritPrototype(Child, Parent);
Child.prototype.sayAge = function () {
    console.log(this.age);
}

let child1 = new Child("yhd", 23);
child1.sayAge(); // 23
child1.sayName(); // yhd
child1.friends.push("jack");
console.log(child1.friends); // ["rose", "lily", "tom", "jack"]


let child2 = new Child("yl", 22)
child2.sayAge(); // 22
child2.sayName(); // yl
console.log(child2.friends); // ["rose", "lily", "tom"]

