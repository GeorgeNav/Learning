{
    function foo() {
        var a = 2;
        function bar() { console.log(a); } // 2 (bar has closure over foo and global scope)
        bar();
    }
    foo();
}
{
    function foo(b) {
        var a = b;
        function bar() { console.log(a); }
        return bar;
    }
    var baz = foo(3);
    baz(); // 3
}
{
    {
        function foo() {
            var a = 2;
            function baz() { console.log(a); }
            bar(baz);
        }
        function bar(fn) { fn(); }
    }{
        var fn;
        function foo() {
            var a = 2;
            function baz() { console.log(a); }
            fn = baz;
        }
        function bar() { fn(); }
        foo();
        bar(); // 2
    }
}
{ // Practical application of closures
    function wait(message) {
        setTimeout(
            function time(){ console.log(message); },
            1000
        );
    }
    wait("Hello, closure");
}
{ // loops and closures
    for(var i = 1; i <= 5; i++)
        (function(j) {
            setTimeout( // linters will often complain being put into for loops
                function timer() { console.log(j); },
                j*1000
            );
        })(i);
    for(let i = 1; i <= 5; i++)
        setTimeout( // linters will often complain being put into for loops
            function timer() { console.log(i); },
            i*1000
        );
}