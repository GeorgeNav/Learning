fn main() {
    let mut x = 5;
    ugh(x);
    println!("{}",x);
}

fn ugh(x: &mut i32) {
    x = 2;
}
