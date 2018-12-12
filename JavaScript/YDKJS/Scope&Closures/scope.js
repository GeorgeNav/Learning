{ // Lexical Scope (JS): author-time
    function foo(a) {
        var b = a; // b is a LHS lookup, a is a RHS lookup
        return a + b; // a and b are RHS lookups
    }
    var c = foo(2); // c and foo are LHS lookups, lookup if foo function has a parameter a is a LHS lookup
}

{ // Lexical Scope (JS): author-time
    function foo2(a) {
        var b = a * 2;
        function bar(c) {
            console.log(a,b,c);
        }
        bar(b*3);
    }
    foo2(2);
}
// Cheating Lexical
{ // eval
    function foo3(str, a) {
        eval(str); // cheating!
        console.log(a,b);
    }
    var b = 2;
    foo3("var b = 3;", 1); // 1, 3
}
{ // with
    var obj = {
        a: 1,
        b: 2
    }
    console.log("original obj: " + obj.a + ", " + obj.b);
    with (obj) {
        a = 2;
        b = 3;
    }
    console.log("changed obj: " + obj.a + ", " + obj.b);
    //consider
    function foo4(obj) {
        with(obj) {
            a = 2;
        }
    }
    var o1 = { a: 3 };
    var o2 = { b: 3 };
    foo4(o1);
    console.log(o1.a);
    foo4(o2);
    console.log(o2.a);
    console.log(a);
}
// Function vs Block Scope
{
    { // Bad scope
        function doSomething(a) {
            b = a + doSomethingElse(a*2);
        }
        function doSomethingElse(a) { // only is accessed in doSomething() so should be in that function scope only
            return a-1;
        }
        var b; // only is accessed in doSomething() so should be in that function scope only
    }
    { // Good scope
        function doSomething(a) {
            function doSomethingElse(a) {
                return a-1;
            }
            var b;
            b = a + doSomethingElse(a*2);
            console.log(b*3);
        }
        doSomething(2);
        // Now nothing can access b outside of doSomething()
    }
}
{ // Collision
    function foo() {
        function bar(a) {
            /*i = 3;*/ // Would cause collision with outer scope's i
            var i = 3; // This wouldn't
            console.log(a+i);
        }
        for(var i = 0; i < 10; i++) {
            bar(i*2);
        }
    }
    foo();
}
{ // Library
    var MyLibrary = {
        awesome: "stuff",
        doSomething: function() { },
        doAnotherThing: function() { }

    };
}
{
    { // Has scope polution
        a = 2;
        function foo() { // Polutes global scope
            var a = 3;
            console.log(a); // 3
        }
        foo(); // has to find foo() and then execute it
        console.log(a);
    }
    { // Does not have scope polution
        var a = 2;
        (function foo() { // foo only used in this scope ()
            var a = 3;
            console.log(a);
        })();
    }
}
{ // Anonymous function expression
    setTimeout(
        function timeoutHandler() { console.log("I waited 2 seconds!"); }
        , 2000
    );
}
{ // Immediately invoked fuction expression
    (function() {
        console.log("Hello");
    })();
}
{ // TODO:  
    undefined = true;
    (function IIFE() {
        var a;
        if(a === undefined)
            console.log("Undefined is safe here");
    })();
}
(function()
{ // TODO: get this to work. Garbage collection
    function process(data) {
        // do something
    }
    { // will free up memory used by this after block is complete (ideal)
        let someReallyBigData = {};
        process(someReallyBigData);
    }
    var btn = document.getElementById("my_button");
    btn.addEventListener(
        "click",
        function click(evt) { console.log("button clicked"); },
        /*capturingPhase*/false
    );
});
{ // for loop behavior
    for(let i = 0; i < 10; i++)
        process.stdout.write(String(i));
    {
        let j;
        for(let j = 0; j < 10; j++) {
            let i = j;
            process.stdout.write(String(i));
        }
    }
}
{
    var foo = true, baz = 10;
    if(foo) {
        let bar = 3;
        if(baz > bar)
            console.log(baz);
    }
}