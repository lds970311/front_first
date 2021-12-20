import {IStack} from "../@types";

class MyStack<E> implements IStack<E> {
    private stackSize: number;
    private readonly data: E[]

    constructor() {
        this.stackSize = 0;
        this.data = []
    }

    isEmpty(): boolean {
        return this.stackSize === 0;
    }

    peak(): E {
        return this.data[this.stackSize - 1];
    }

    pop(): E | undefined {
        if (this.size() === 0) {
            return undefined;
        }
        --this.stackSize;
        return this.data.pop();
    }

    push(element: E): void {
        this.data.push(element);
        this.stackSize++;
    }

    size(): number {
        return this.stackSize;
    }
}

export default MyStack;
