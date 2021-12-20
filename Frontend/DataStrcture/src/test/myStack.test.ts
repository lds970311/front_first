import MyStack from "../dataStructures/MyStack";

describe("myStackTest", () => {
    const stack = new MyStack<number>()
    for (let i = 5; i < 11; i++) {
        stack.push(i)
    }
    it("isEmpty", () => {
        expect(stack.isEmpty()).toBe(false)
    })

    it('peak', function () {
        expect(stack.peak()).toBe(10)
    });

    it('pop', function () {
        expect(stack.pop()).toBe(10)
        expect(stack.pop()).toBe(9)
        expect(stack.pop()).toBe(8)
    });
    it('size', function () {
        expect(stack.peak()).toBe(7)
        expect(stack.size()).toBe(3)
    });
})
