/*
Compile file
    rustc nameOfFile.rs
Run compiled file
    ./nameOfFile
Compile and run compiled file
    rustc nameOfFile.rs; ./nameOfFile.rs
Format code command
    Step 1:
        rustup component add rustfmt
    Then you can use this every time:
        rustfmt nameOfFile.rs
*/

fn main() {
    println!("Hello world!"); // calls a rust macro because of the !
}
