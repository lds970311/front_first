import MyStack from "../dataStructures/MyStack";

//10进制转换成2进制(使用stack)
const dec2Bin = (num: number) => {
    const stack = new MyStack<number>();
    while (num > 0) {
        let binNum = num % 2;
        num = Math.floor(num / 2);
        stack.push(binNum);
    }
    let res = ""
    while (!stack.isEmpty()) {
        res += stack.pop();
    }
    return res;
}

const res = dec2Bin(18874);
console.log(res);
