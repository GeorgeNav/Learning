T printy<T>(T val) => val; // Returns the value passed for any type
main() {
  print( printy('val') );
  print( printy(1) );
  print( printy(1.1) );
}