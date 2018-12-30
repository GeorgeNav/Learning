var magic = function() { // anonymous function
    return new Date();
}
console.log(magic());

var magic = () => { // same as first function
    return new Date();
}
console.log(magic());

var magic = () => new Date(); // same as first function
console.log(magic());


var numArr = [4, 5.6, -9.8, 3.14, 42, 6, 8.34, -2];
console.log(
    numArr.filter((num) => Number.isInteger(num) && num >= 0 // array's numbers that are integers and >= 0
    ).map((num) => num * num) // returns an array that has squared versions of each element
);

const sum = (...args) => args.reduce( // ...args means any args that are passed into function are converted to a single array 
    (a,b) => a + b, 0
);
console.log(sum(1,2,3,4,5));

import {capitalizedString} from "./import_example";
import * as obj from "./import_example";
const cap = capitalizeString("hello");
console.log(cap);