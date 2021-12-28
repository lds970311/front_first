function isEqual(value, other) {
    return Object.is(value, other)
}

console.log(isEqual({}, {}));
console.log(isEqual(NaN, NaN))
console.log(NaN == NaN)
