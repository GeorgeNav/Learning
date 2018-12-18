Function makeAdder(num addBy) => (num i) => addBy + i;
class Person {
  String fname;
  String lname;
  Person(this.fname);
}

class Animal { 
  final String fname;
  final String lname;
  const Animal(this.fname, this.lname); // example of constant constructor (all values in object must be final)
}

void main() {
  // Create a function that adds 2.
  var add2 = makeAdder(2); // 2 is passed to amakeAdder's addBy then to anyonomous func's addBy 

  // Create a function that adds 4.
  var add4 = makeAdder(4);  // 4 is passed to makeAdder's addBy then to anyonomous func's addBy 

  print(add2(3)); // 3 is passed to i
  print(add4(3)); // 3 is passed to i

  var add;
  add??= 2; // add?? means if add is null, add??= means " ", then set equal to 2
  1 + 1 == 2 ? print("1 + 1 == 2") : print("1 + 1 != 2"); // condition ? do this if true : else do this

  print("5/2 = ${5/2} , 5~/2 = ${5~/2} , 5%2 = ${5%2}");

  var guy = Person("Billy");
  print(guy.fname);
  (guy as Person).fname = "Bob"; // If guy is of type Person, change name to Bob
  print(guy.fname);

  String playerName(String name) => name ?? 'Guest';

  guy
    ..fname = "George"
    ..lname = "Navarro"; // Cascade notation (multiple operations on same object and can be nested)
  print('${guy.fname} ${guy.lname}');
  var girl = Person("Shelly");
  print(girl?.fname); // Displays first name unless first name is null
  print(girl?.lname); // null

  var collection = [0,1,2];
  for(var item in collection) { // in instead of :
    print(collection[item]);
  }

  try { assert(collection[0] != 0, 'This collection value at index 0 not 0'); } // if condition is false, display string for exeception
  catch (e) { print(e); } // catches whatever exception is thrown and prints it
  finally { print("This finally part always runs no matter if an exception is thrown or not"); }
}