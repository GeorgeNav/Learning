class A {
  @override
  noSuchMethod(_) => print('hello'); // (_) : https://stackoverflow.com/questions/25517016/what-does-it-mean-to-pass-i-e-underscore-as-the-sole-parameter-to-a-dart
}
main() {
  print((new A() as dynamic).sayHello());
}