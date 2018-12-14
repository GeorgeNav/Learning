class Quadrilateral {
  num left, right, top, bottom;
  // Quadrilateral(this.left, this.right, this.top, this.bottom);
  num get leftDim => this.left;
  num get rightDim => this.right;
  num get topDim => this.top;
  num get bottomDim => this.bottom;
  set leftDim(num val) => this.left = val;
  set rightDim(num val) => this.right = val;
  set topDim(num val) => this.top = val;
  set bottomDim(num val) => this.bottom = val;
}