fn main() {
/*  Rust is statically typed (type is determined at compile time)
    Value types subsets are scalar and compound
    Scalar Type (single value): integer(s), floating-point(s), boolean(s), character(s)
        Integer Types: rust assigns an int type depending on the value
            Signed: negative values -(2^(n-1)) through positive 2^(n-1)-1 numbers
            Unsigned: 0 through positive 2^n-1 numbers
                where n is the bit length
            isize and usize: depend on your computer (32bit or 64bit)
            Length      Signed          Unsigned
            8-bit       i8              u8
            16-bit      i16             u16
            32-bit      i32 (default)   u32
            64-bit      i64             u64
            arch        isize           usize
        Float-point Types: f32 is 32bits and f64 is 64bits (default)
        Boolean Type: can be true or false
        Character Type: Unicode Scalar Value
            Range: U+0000 through U+D7FF    and    U+E000 through U+10FFFF inclusive
    Compound Type: group multiple values and (or) types of values in one type
        Tuples: can have multiple types of values
        Arrays: only can hold one type of value and size cannot grow/shrink 

*/
    /* Scalar Values
        Explicit scalar
            let valName: typeOfValue = value;
        Implicit scalar
            let valName = value;
        Similar for mutable (value can be changed)
            let mut valName: typeOfValue = value;
            let mut valName = value;
    */
    let mut val: i8 = 127;
    println!("{}", val);
    val += 1;
    println!("{}", val);

    let _explicit: i32 = -1; // explicit i32 immutable
    let mut _implicit = 1; // implicit integer mutable
    println!("_explicit = {}", _explicit); // print an explicit integer value
    println!("_implicit = {}", _implicit); // print an implicit integer value

    /* Compound Values
        Tuple qualities:
            finite (fixed number of elements),
            heterogeneous (can contain many data types),
            sequences (order matters since access with index),
            immutable
        Array qualities:
            finite (fixed number of elements),
            homogeneous (all elements are of the same data type),
            sequences (order matters since access with index),
            mutable
    */

    // Tuples
    let _explicit_tuple: (i8, f64, i32) = (5, 3.14, 7000); // Explicit Tuple: let tuple_name: (data_type_1, ... , data_type_n) = (value_for_dt1, ... , value_for_dtn);
    let _implicit_tuple = (5, 3.14, 7000); // Implicit tuple: let tuple_name = (value_for_dt1, ... , value_for_dtn);
    let (a1, b1, c1) = _explicit_tuple; // Initialize values by destructuring tuple
    let a2 = _explicit_tuple.0; // Access tuple values with index number
    let b2 = _explicit_tuple.1;
    let c2 = _explicit_tuple.2;
    println!("a1 = {}, b1 = {}, c1 = {}", a1, b1, c1); // equivalent..
    println!("a2 = {}, b2 = {}, c2 = {}", a2, b2, c2); // ..to this

    // Arrays
    let _array: [String; 32] = Default::default(); // sets all 32 elements to empty strings
    let _days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
    let _days = ["val"; 7]; // make an array of 7 elements with an initial value of "val"
    let _days: [i32; 7];
    println!("{:?}",_days); // print this array of values
    println!("{:?}",_array); // print this array of values

    /* Constant value
        Can be declared anywhere and will be available for any scope there after (global)
        Cannot be set by the result of a function call or any other value that could only be computed at runtime.
        Type must be explicitly said
        Naming convention is all caps with underscores between multiple words
    */

    const TWO_VALUE: i32 = 2;

    println!("TWO_VALUE = {}", TWO_VALUE);

    /* Shadowing using let can modify an immutable value into the same or a different datatype */
    let _value = 2; // 2
    let _value = _value + 2; // 4
    println!("_value = {}", _value);
    let _spaces = "  ";
    let _spaces = _spaces.len();
    println!("{} spaces", _spaces);
/* Rust's Ownership feature
    First lets define memory safety...
        Being protected from software bugs and security vulnerabilities.
        The cause of these would be memory access such as buffer overflows, dangling pointers, array bounds error detection
    Rust guarantees memory safety without the need for garbage collector using ownership
        Only a single identifier can own a value
        Value will be dropped once owner is out of scope
*/
}
