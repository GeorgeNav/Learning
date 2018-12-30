console.log(Math.floor(Math.random() * 20)); // Number between 0 and n (20)

function randomRange(min, max) {
    return Math.floor(
        Math.random() * (max - min + 1) + min
    );
}
console.log(randomRange(2,6));

console.log(parseInt("56"));
console.log(parseInt("56.5")); // no rounding, discard decimal
console.log(parseInt("hello")); // Not a Number
console.log(parseInt("1001", 2)); // parse binary number to integer