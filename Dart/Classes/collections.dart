class Foo<T extends SomeBaseClass> { } // limits the type to a base class's
class SomeBaseClass { }

main() {
  var foo = Foo<SomeBaseClass>(); // When using Foo<Type>(), it's limited to SomeBaseClass's accepted types
  /* var foo = Foo<String>(); */ // Wont work since SomeBaseClass doesn't allow type String
  printWhatever('String');
  printWhatever(5);
  printWhatever(5.1);
  print('method 1');
  method();
  print('method 3');
  { // Collection literals
    var names = <String>['Setch','Kathy','Lars'];
    var pages = <String, String> { // String:String key value pair for pages object
      'index.html': 'Homepage',
      'robots.txt': 'Hints for web robots',
      'humans.txt': 'We are people, not machines'
    };
  }
  { // Using generic types for darts built in Objects List and Set
    var names = List<String>(); print(names); // Collection of Objects (with length)
    names.addAll(['Seth','Kathy','Lars']); print(names);
    names.addAll(['George']); print(names);
    var nameSet = Set<String>.from(names); print(nameSet); // Set of unique Objects
    print(names is List<String>); // can only test if names is a List in Java
  } //
  {

  }
}

void printWhatever<T>(T val) => print(val); // Genertic method that takes whatever type is needed or specified types
void method() async {
  await Future.delayed(Duration(seconds: 4));
  print('method 2');
}