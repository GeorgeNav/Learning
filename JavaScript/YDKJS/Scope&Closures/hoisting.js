"use strict"; // prevents global variables to be created within an inner scope (bad practice)
{ // variables (hoisted first after functions)
    {   a = 2;
        var a;
        console.log(a); // 2
    }{  // .. is treated like this
        var a;
        a = 2;
        console.log(a); // 2
    }
    {   console.log(a); // undefined (remove all previous lines to get to work)
        var a = 2;
    }{  // .. is treated like this
        var a;
        console.log(a); // undefined (remove all previous lines to get to work)
        a = 2;
    }
}
{ // functions (hoisted first before variables)
    {
        foo();
        function foo() {
            console.log(a); // undefined
            var a = 2;
        }
    }{  // .. is treated like this
        function foo() {
            var a;
            console.log(a); // undefined
            a = 2;
        }
        foo();
    }
    {
        // console.log(foo()); // TypeError (foo is not a function)
        var foo = function bar() {
            //...
        };
    }
}