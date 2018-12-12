{   // Dynamic scope (uses scope where the function is called)
    function foo() { console.log(a); } // 2
    function bar() {
        var a = 10;
        foo();
    }
    var a = 0;
    bar();
}
{   // Polyfilling
    {   // block scope 
        {
            let a = 1;
            console.log(a);
        }
        console.log(a); // ReferenceError
    }{  // .. is the same thing
        try {
            throw 2
        } catch(a) { // polyfill for pre-ES6
            console.log(a); // 2
        }
        console.log(a); // ReferenceError
    }{
        try {
            throw undefined;
        } catch(a) {
            a = 3;
            console.log(a);
        }
        console.log(a);
    }
}
{   {
        var foo = a => {
            console.log(a);
        };
        foo(4);
    }
    {
        var obj = {
            id:"awesome",
            cool:function coolFn() { console.log(this.id); }
        };
        var id = "not awesome";
        obj.cool(); // awesome
        setTimeout(obj.cool, 100); // not awesome
    }{
        var obj = {
            count:0,
            cool:function coolFn() {
                var self = this;
                if(self.count < 1) {
                    setTimeout(
                        () => {
                            self.count++;
                            console.log("awesome?");
                        },
                        100
                    );
                }
            }
        }
        obj.cool();
    }
}