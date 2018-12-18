import "Quadrilateral.dart";

class Rectangle extends Quadrilateral {
  Rectangle(num leftRight, num topBottom) { // Super class must not have a constructor defined
    this.left = leftRight;
    this.right = leftRight;
    this.top = topBottom;
    this.bottom = topBottom;
  }
  Rectangle.withAssert(num leftRight, num topBottom) : assert(leftRight > 0 && topBottom > 0) { // Checks for valid input before creating instance
    this.left = leftRight;
    this.right = leftRight;
    this.top = topBottom;
    this.bottom = topBottom;
  }
  Rectangle.square(num anySide) : this(anySide, anySide); // Redirecting constructor
  @override
    noSuchMethod(Invocation invocation) => super.noSuchMethod(invocation); // this gets called if a method being called doesn't exist in this class
  @override
  set leftDim(num val) {
    this.left = val;
    this.right = val;
  }
  @override
  set rightDim(num val) {
    this.left = val;
    this.right = val;
  }
  @override
  set topDim(num val) {
    this.top = val;
    this.bottom = val;
  }
  @override
  set bottomDim(num val) {
    this.top = val;
    this.bottom = val;
  }
}
