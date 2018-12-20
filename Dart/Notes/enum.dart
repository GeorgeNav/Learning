enum Color {red, green, blue}

main() {
  print(Color);
  Color colors;
  var input = Color.green;
  switch(input) {
    case Color.red :
      print("red"); break;
    case Color.green :
      print("green"); break;
    case Color.blue :
      print("blue"); break;
  }
}