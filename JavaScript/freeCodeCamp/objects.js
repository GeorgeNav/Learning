var testObj = {
    "test": "Testing",
    "test space": "Testing with a space",
    "nestobj1": {
        "prop1": "p1",
        "nestobj2": {
            "pro1": "p1"
        }
    },
};

console.log(testObj.test);
console.log(testObj["test space"]);
testObj.test = 2; // change value for test:Testing key value pair
console.log(testObj.test);
testObj.text = "Added text to object"; // added key value pair to end of object
testObj["hello there"] = "Hi";
console.log(testObj);
delete testObj.text;
console.log(testObj);
console.log(testObj["hello there"] != undefined ? true : false); // has key value pair for property "hello there"?
console.log(JSON.stringify(testObj));

const mutableObj = {
    "key1": "val1",
    "key2": "val2",
}

mutableObj.key1 = "val3";
console.log(mutableObj); // there should have been an error here in mutableObj was immutable
mutableObj.key1 = "val1"; // changed back value to try again with...
Object.freeze(mutableObj);
try { mutableObj.key1 = "val3";
} catch (e) { console.log(e); }
console.log(mutableObj); // there should have been an error here in mutableObj was immutable

var obj1 = {
    "key1": "val1",
    "key2": "val2",
    "key3": {
        "prop1": "prop1 val",
        "prop2": "prop2 val",
    }
}

var {key1 : a, key2: b} = obj1; // declaring and initializing a and b to obj1's values
console.log("a = " + a + ", b = " + b);
var {key3 : c} = obj1; // sets c to obj1's key3's obj
console.log(c.prop1);

/* const half = (function() {
    return function half({max, min}) {
        return (max + min) / 2.0;
    }
})(); */
const half = (() =>
    ({max, min}) =>
        (max + min) / 2.0
)();
var stats = {
    max: 56.78,
    min: -0.75,
}
console.log(stats);
console.log(half(stats));

console.log(`The number is ${stats.max}
and here is a new line without any backslash command`);

var createPerson = (name,age) => ({name, age});
var person1 = createPerson("Billy", 56);
var person2 = createPerson("Bob", 15);
console.log(person1);
console.log(person2);