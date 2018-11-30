// Chapter 2

"use strict"; // prevents global variables to be created within an inner scope (bad practice)
// Types
var type;
    console.log(typeof type); // "undifined"
type = "hello world";
    console.log(typeof type); // "string"
type = 42;
    console.log(typeof type); // "number"
type = true;
    console.log(typeof type); // "boolean"
type = null;
    console.log(typeof type); // "boolean"
type = undefined;
    console.log(typeof type); // "undefined"
type = { b: "c" };
    console.log(typeof type); // "object"
var obj = {
    a: "a string",
    b: 42,
    c: true
}
console.log("a: " + obj.a + ", b: " + obj.b + ", c: " + obj.c);
console.log("a: " + obj["a"] + ", b: " + obj["b"] + ", c: " + obj["c"]);

// Functions (object subtype)
function foo() { return 42; } // Call this function without a value inside ()
    console.log(typeof foo + " " + typeof foo()); // "function" "number"
foo.bar = "hello world";
    console.log(typeof foo.bar); // "string"

// Type methods
var a = "Hello I am a string";
    console.log(a.length); // "19"
    console.log(a.toUpperCase()); // "HELLO I AM A STRING"
var b = 3.14159;
    console.log(b.toFixed(3)); // "3.142" rounds to specified decimal place

// Falsy values: "" , 0, -0, NaN, null, undefined, false
// Truthy values: anything that isn't falsy

// Equality == vs ===
// If a value is a true or false value, use ===
// If a value is 0, "", or an empty array, use ===
// Else use ==
var a = [1,2,3]; // a references some place in memory
var b = [1,2,3]; // a references a different place in memory
var c = "1,2,3";
console.log("a == b is " + String(a == b));
console.log("a === b is " + String(a === b));
console.log("a == c is " + String(a == c));
console.log("b == c is " + String(b == c));
a = "apple";
b = 42;
c = "35";
if(a < b) console.log("can compare a and b");
else console.log("cannot compare a and b");
if(c < b) console.log("can compare c and b");
else console.log("cannot compare c and b");
// Varaibles: start with a-z, A-Z, $, or _ (can have any of these through out the rest)
var $a, _a, a, A;

// Strict mode prevents creating global variables in this way
/* e = 1; */ // declares b as a global variable (can be accessed anywhere)
{ // Block variable
    let blockVar = "hello";
    console.log(blockVar);
}

// Ternary operator
var a = 42;
var b = (a > 41) ? "wow" : "ouch";
console.log(b);
var b = (a > 44) ? "wow" : "ouch";
console.log(b);
/* console.log(blockVar); */ // This cannot work since blockVar can only be accessed within the block it was declared at

// Switch statement
switch(1) {
    case 1:
        console.log("case 1");
    case 2:
        console.log("case 2");
        break;
    default:
        console.log("ouch");
}

// Functions
var foo1 = function() { // ananymous function
    return 1 + 2;
}
var foo2 = function bar() { // named function
    return "cool";
}
console.log(foo1() + " " + foo2());

// Imediately invoked function expression
( function IIFE() { console.log("Hello!"); } )();
console.log(
    ( function heyo() { return "Hello!"; } )()
);
a = ( function () { console.log("Hello!"); } )();
console.log(a);

// Closure
function makeAdder(x) {
    function add(y) { return y + x; };
    return add;
}
var func = makeAdder(2); // passes function with scope
var value = func(3); // 5
console.log(value + " is the same as " + makeAdder(2)(3));

// Modules
function User() {
    var username, password;
    function doLogin(u,p) {
        this.username = u;
        this.password = p;
    }
    var publicAPI = {
        login: doLogin
    };
    return publicAPI;
}
var fred = User();
fred.login("fred123","Mypassword1234");

// this
/*
function foo() {
    console.log(this.bar);
}
var bar = "global";
var obj1 = {
    bar: "obj1",
    foo: foo
};
var obj2 = {
    bar: "obj2"
};

foo(); // "global" bar
obj1.foo(); // "obj1" bar
foo.call(obj2); // "obj2" bar
new foo(); // bar is undefined since creating a new empty object
*/

// Prototyping
var prototypeObj = {
    h: "value"
}
var target = Object.create(prototypeObj); // Creates object referencing another objects values
target.you = "you";
console.log(target.h + " " + target.you);

// Polyfilling
// https://github.com/es-shims/es5-shim
// https://github.com/es-shims/es6-shim
if (!Number.isNaN) {
    Number.isNaN = function isNaN(x) {
        return x !== x;
    };
}

// Transpiling: convert newer code to an older code version
// ES6+ to ES5: https://babeljs.io/
// ES6, ES7, and beyond to ES5: https://github.com/google/traceur-compiler