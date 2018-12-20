import 'Libraries/sort.dart';
import 'dart:io';

main() {
  var option;
  do { 
    clear();
    printInterface();
    option = getInput();
    switch(option) {
      case 0:
        print('End of program');
        break;
      case 1:
        stdout.write('sorting...');
        sleep(Duration(seconds: 2));
        print('done!');
        sleep(Duration(seconds: 1));
        break;
      default:
        print('Not an option yet, please try again');
        sleep(Duration(seconds: 2));
        break;
    }
  } while(option != 0);
}

int getInput() {
  var input;
  while(input == null) {
    try {
      input = int.parse( stdin.readLineSync() );
    } catch(error) {
      print('Please enter a valid integer');
    }
  }
  return input;
}

void printInterface() {
  print(
    '''

    This application showcases datastructures and algorithms
    I have created in Dart throught 12/19/2018 until now.
      (1) Sorting
      (0) Exit program

    '''
  );
  stdout.write('Pick an option > ');
}

void clear() { // Clears command prompt or terminal
  print(Process.runSync(!Platform.isWindows ? "cls" : "clear", [], runInShell: true).stdout);
}