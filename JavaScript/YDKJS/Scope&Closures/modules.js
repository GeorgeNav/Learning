{   // Modules
    // module pattern: outer closing funciton (a instance of a function), return at least one inner function
    function doo() { // Not a module
        var something = "cool";
        var another = [1,2,3];
        function doSomething() { console.log(something); }
        function doAnother() { console.log(another.join("!")); }
    }
    
    function CoolModule() { // revealing module
        var something = "cool";
        var another = [1,2,3];
        function doSomething() { console.log(something);}
        function doAnother() { console.log(another.join("!")); }
        return {
            doS: doSomething,
            doA: doAnother
        };
    }
    var foo = CoolModule();
    foo.doS(); // cool
    foo.doA(); // 1!2!3
}
{   // Modern Modules
    var MyModules = (function Manager(){
        var modules = {};
        function define(name,deps,impl) {
            for(let i = 0; i < deps.length; i++)
                deps[i] = modules[deps[i]];
            modules[name] = impl.apply(impl,deps); // invokes definition wrapper function for a module (passes dependencies)
        }
        function get(name) { return modules[name]; }
        return {
            define: define,
            get: get
        };
    })();
    MyModules.define( "bar", [],
        function() {
            function hello(who) { return("Let me introduce: " + who); }
            return { hello: hello };
        }
    );
    MyModules.define( "foo", ["bar"],
        function(bar) {
            var hungry = "hippo";
            function awesome() { console.log(bar.hello(hungry).toUpperCase()); }
            return { awesome: awesome };
        }
    );
    console.log( (MyModules.get("bar")).hello("hippo") );
    (MyModules.get("foo")).awesome();
    
    /* module foo from "foo"; */ // imports foo module
}