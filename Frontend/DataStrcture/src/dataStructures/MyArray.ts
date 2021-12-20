import {ArrayLike, IArray} from "../@types";


class MyArray<E> implements IArray<E> {
    private _length: number
    private _data: E[]

    constructor(...args: E[]) {
        this._length = args.length
        this._data = [...args]
    }

    private isEmpty(): boolean {
        return this._length === 0;
    }

    private isValidIndex(index: number): boolean {
        return !(index >= this._length || index < 0)
    }

    static isMyArray(value: any): boolean {
        return Object.prototype.toString.call(value) === "[object Array]"
    }

    static of(...args: any[]): MyArray<any> {
        return new MyArray<any>(...args)
    }

    static from(value: ArrayLike<any>, mapFn?: Function): MyArray<any> {
        const arr = new MyArray<any>();
        if (!mapFn) {
            for (let i = 0; i < value.length; i++) {
                arr.addLast(value[i])
            }
            return arr;
        }
        for (let i = 0; i < value.length; i++) {
            arr.addLast(mapFn(value[i]))
        }
        return arr;
    }

    /**
     * 获取数组元素
     * @param index
     */
    public get(index: number): E {
        return this._data[index]
    }

    public set(index: number, value: E): boolean {
        if (!this.isValidIndex(index)) {
            return false
        }
        this._data[index] = value
        return true
    }

    /**
     * 删除头元素
     */
    public removeFirst(): E | number {
        if (this.isEmpty()) {
            return -1
        }
        this._length--;
        return this.data.shift()!
    }

    /**
     * 删除尾部元素
     */
    public removeLast(): E | number {
        if (this.isEmpty()) {
            return -1
        }
        this._length--;
        return this.data.pop()!
    }

    /**
     * 删除元素
     * @param index
     * @param count
     */
    public delete(index: number, count?: number): boolean {
        if (this.isEmpty()) {
            return false
        }
        count ? this.data.splice(index, count) : this.data.splice(index, 1)
        if (count) {
            this._length -= count;
        } else {
            this._length -= 1
        }

        return true
    }

    //添加元素
    public addFirst(element: E): boolean {
        this.data.unshift(element)
        this._length++;
        return true
    }

    public addLast(element: E): boolean {
        this.data.push(element)
        this._length++;
        return true
    }

    public insert(index: number, ...elements: E[]): boolean {
        if (!this.isValidIndex(index)) {
            return false;
        }
        this._data.splice(index, 0, ...elements)
        this._length += elements.length;
        return true
    }

    //合并数组
    public concat(newArray: MyArray<E>): void {
        this.data = this._data.concat(newArray._data);
        this._length += newArray._length;
    }

    //清空元素
    public clear(): void {
        if (this.isEmpty()) {
            return
        }
        this._data = []
        this._length = 0;
    }

    //查找相关元素
    public find(cb: Function): MyArray<E> {
        const arr = new MyArray<E>()
        for (let i = 0; i < this._length; i++) {
            cb(this.data[i], i, this.data) && arr.addLast(this.data[i]);
        }
        return arr
    }

    //查找元素对应索引
    public findIndex(element: E): number {
        for (let i = 0; i < this._length; i++) {
            if (JSON.stringify(element) === JSON.stringify(this.data[i])) {
                return i
            }
        }
        return -1;
    }

    //合并成字符串
    public join(separator?: string): string {
        if (!separator) {
            separator = "";
        }
        let res: string = "";
        for (let i = 0; i < this._length; i++) {
            res += this.data[i] + separator
        }
        res = res.substring(0, res.lastIndexOf(separator))
        return res;
    }

    public map(cb: Function): MyArray<any> {
        let res: MyArray<any> = new MyArray<any>()
        for (let i = 0; i < this._length; i++) {
            res.addLast(cb(this._data[i], i, this._data))
        }
        return res;
    }

    //翻转
    public reverse(): void {
        if (this.isEmpty() || this._length === 1) {
            return
        }
        let len = this._length;
        let mid = Math.floor(this._length / 2)
        for (let i = 0; i < mid; i++) {
            let temp = this._data[len - i - 1];
            this.data[len - i - 1] = this.data[i];
            this._data[i] = temp
        }
    }

    public some(cb: (element: E, index: number, arr: Array<any>) => boolean): boolean {
        if (this.isEmpty()) {
            return false
        }
        for (let i = 0; i < this._length; i++) {
            if (cb(this._data[i], i, this._data)) {
                return true
            }
        }
        return false;
    }

    public every(cb: (element: E, index: number, arr: Array<any>) => boolean): boolean {
        if (this.isEmpty()) {
            return false
        }
        for (let i = 0; i < this._length; i++) {
            if (!cb(this._data[i], i, this._data)) {
                return false
            }
        }
        return true
    }

    /**
     * 迭代器模式
     */
    [Symbol.iterator] = () => {
        let count = 0;
        let len: number = this.length;
        let msg = this.data
        return {
            next() {
                if (count < len) {
                    return {
                        value: msg[count++],
                        done: false
                    }
                } else {
                    return {
                        value: undefined,
                        done: true
                    }
                }
            }
        }
    }

    public get length(): number {
        return this._length;
    }


    public get data(): E[] {
        return this._data;
    }

    public set data(value: E[]) {
        this._data = value;
    }
}

export default MyArray
