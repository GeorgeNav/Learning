import "Rectangle.dart";

main() {
  var rec = Rectangle.withAssert(5,5); // Checks for valid input before creating instance
  /* var rec = Rectangle.withAssert(0,5); */ // Causes exception
  print(rec.topDim);
  rec.topDim = 2;
  print(rec.topDim);
  var squ = Rectangle.square(5);
  print(
    "Square: left is ${squ.leftDim},\n" +
    "right is ${squ.rightDim},\n" +
    "top is ${squ.topDim},\n" + 
    "bottom is ${squ.bottom}");
}