import "dart:core";
printInteger(int aNumber) { print('The number is $aNumber'); } // print to console
main() { // App executes here
  void junkFn(val) => print(val); // short hand for a function with one statement
  dynamic number = 42; // Declare and initialize a variable
  printInteger(number); // Call the function printInteger
  dynamic val;
  assert(val is Object);
  final name1 = "Peter"; // initialized when accessed
  const name2 = "Griffin"; // initialized no matter what
  print("$name1 $name2");

  var one = int.parse("1");
  assert(one == 1);
  var huh = 0/0;
  assert(huh.isNaN == true);
  var list = ["a",1,'c'];
  print("$list with length: ${list.length}");
  var constantList = const [1,2,3];
  /* constantList[1] = 3; */ // Cannot work since list object is constant
  print(constantList);
  var sayings = { // Map
    "hello":"greetings",
    "bye":"goodbye"
  };
  sayings["wow"] = "very cool"; // adds key:value pair
  print(sayings);
  int ouch(int val, [int otherVal]) { // [int otherVal, ... ] optional variables
    if(otherVal != null)
      return val + otherVal;
    else
      return val;
  }
  print(ouch(2,3));
  print(ouch(2));

  void lists({List<int> lis = const [1,2,3]}) => print(lis); // passes default object if method is called with no arg
  var values = ["apples","bananas","oranges"];
  values.forEach( (item) => print("${values.indexOf(item)}: $item") );
}

