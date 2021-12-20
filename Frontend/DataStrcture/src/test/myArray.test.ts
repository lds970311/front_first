import MyArray from "../dataStructures/MyArray";


const arr = new MyArray<number>()
for (let i = 1; i < 6; i++) {
    arr.addLast(i)
}


const arr2 = new MyArray<number>();

for (let i = 10; i < 16; i++) {
    arr2.addLast(i)
}


test("first add element", () => {
    arr.addFirst(6)
    expect(arr.data).toEqual([6, 1, 2, 3, 4, 5])
})


test('clear element', () => {
    arr.clear()
    expect(arr.data).toEqual([])
});


test("last add element", () => {
    arr.clear()
    for (let i = 1; i < 6; i++) {
        arr.addLast(i)
    }
    arr.addLast(6)
    expect(arr.data).toEqual([1, 2, 3, 4, 5, 6])
})


test("insert element", () => {
    arr.clear()
    for (let i = 1; i < 6; i++) {
        arr.addLast(i)
    }
    arr.insert(2, 9, 10)
    expect(arr.data).toEqual([1, 2, 9, 10, 3, 4, 5])
})


test("delete", () => {
    arr.clear()
    for (let i = 1; i < 6; i++) {
        arr.addLast(i)
    }
    arr.removeFirst()
    arr.removeLast()
    arr.delete(0, 2)
    expect(arr.data).toEqual([4])
})

test("concat", () => {
    arr.clear()
    for (let i = 1; i < 6; i++) {
        arr.addLast(i)
    }
    arr.concat(arr2)
    expect(arr.data).toEqual([1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 15])
})

// //静态方法测试
test("isMyArray", () => {
    expect(MyArray.isMyArray([1, 2])).toBe(true)
    expect(MyArray.isMyArray("123")).toBe(false)
})

test("of", () => {
    const arr = MyArray.of(1, 2, 3)
    expect(arr.data).toEqual([1, 2, 3])
})

test("from", () => {
    const a = MyArray.from("hello");
    expect(a.data).toEqual(["h", "e", "l", "l", "o"])
})


test("遍历MyArray", () => {
    // @ts-ignore
    for (let element of arr) {
        console.log(element)
    }
})

test("find", () => {
    arr.clear()
    for (let i = 1; i < 6; i++) {
        arr.addLast(i)
    }
    const res = arr.find((item: number) => {
        return item % 2 === 0;
    })
    expect(res.data).toEqual([2, 4])
})

test("findIndex", () => {
    expect(arr.findIndex(2)).toBe(1)
    expect(arr.findIndex(11)).toBe(-1)
})


test("join", () => {
    expect(arr.join("-")).toEqual("1-2-3-4-5")
})

test("map", () => {
    arr.clear()
    for (let i = 1; i < 6; i++) {
        arr.addLast(i)
    }
    const res = arr.map(((item: number) => {
        return item + 3
    }))
    expect(res.data).toEqual([4, 5, 6, 7, 8])
})

test("reverse", () => {
    arr.clear()
    for (let i = 1; i < 6; i++) {
        arr.addLast(i)
    }
    arr.reverse()
    expect(arr.data).toEqual([5, 4, 3, 2, 1])
})


//some every
test("every/some", () => {
    arr.clear()
    for (let i = 1; i < 6; i++) {
        arr.addLast(i)
    }
    expect(arr.some(item => item === 1)).toBe(true)
    expect(arr.every(item => item < 7)).toBe(true)
    expect(arr.every(item => item > 2)).toBe(false)
})
