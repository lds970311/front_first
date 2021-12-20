export interface IArray<E> {
    get(index: number): E

    set(index: number, value: E): boolean

    removeFirst(): E | number

    removeLast(): E | number

    delete(index: number, count?: number): boolean

    addFirst(element: E): boolean

    addLast(element: E): boolean

    insert(index: number, ...elements: E[]): boolean
}

export interface IStack<E> {
    push(element: E): void

    pop(): E | undefined

    peak(): E

    isEmpty(): boolean

    size(): number
}

export type ArrayLike<T> = {
    readonly length: number;
    readonly [n: number]: T;
}
