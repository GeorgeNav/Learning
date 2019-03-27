//  SyntaxReview
//  Created by George Navarro on 1/24/18.
/*
 Chapters skipped: Arrays, Searching and Sorting Arrays, Pointers (kind of), Characters C-Strings.. string class
 */

// #include = causes contents of another file to be inserted
// # = pre processor directive
// < > = encloses filename
#include <iostream>
// For setprecision(numberOfDigits)
#include <iomanip>
#include <string>
using namespace std;

// Definition of a global constant variable that is required to be initialized
const int CONSTANTVAR = 1;

// Function prototype with a referenced value
void functionDefined(int& value1, int value2);
// Function prototype that has a default value specified if no input on function call
void secondFunc(int value1 = 100);
// Function signature only has name of function and argument types (not names) such as defaultArgs(int, int)
void defaultArgs(int, int);

// () = used for naming function
// {} = encloses group of statements
int main() {
    // "" = encloses a string of characters
    // Prints out string using cout object
    // ; = marks end of a statement
    /*
         Escape sequences
     \n = newline
     \t = horizontal tab
     \a = alarm (beep)
     \b = backspace
     \r = moves cursor to beginning of current line
     \\ = backslash
     \' = single quote
     \" = double quote
     */
    string value1, value2;
    // Take in input from user
    cin >> value1 >> value2;
    getline(cin, value1);
    getline(cin, value2);
    cout << value1 << "\n" << value2 << "\n";

    // Definition and initialization of a variable
    /*
     unsigned int = + values
     signed int = - and + values
     short int = small number
     int = normal size number
     long int = large number
     */
    double num1, num2, num3;
    num1 = num2 = num3 = 23.12345;
    // setprecision(numberOfDigits) starts from highest digit
    // showpoint shows remaining zeros to complete setprecision amount
    cout << setprecision(10) << showpoint << num1 << endl;
    // left and right justifies text on side
    cout << left << num1 << endl << right << num1 << endl;
    cout << setw(30) << num1 << endl;
    // Definition of a string variable
    string movieTitle = "Hello";
    // Definition and initialization of a bool
    bool logic = true;
    // Definition and initialization with what is needed for the parrameter
    auto whatIsThis = 3;
    int someVal = 5;
    // Definition and initialization of a pointer variable
    // * = indirection operator
    int *ptr = &someVal; // Stores address of someVal (not value it holds)
    cout << "someVal: " << someVal << ". ptr: " << ptr << ". *ptr (someVal contents): " << *ptr << endl;
    *ptr = 100; // someVal contents changes to 100
    cout << "*ptr: " << *ptr << endl;
    
    //Type Casting
    double number = 3.7;
    int val;
    val = static_cast<int>(number);
    cout << val;

    // int or char
    switch (1) {
        case 1:
            cout << "Wow Ryan" << endl;
        case 2:
            cout << "Beep Boop" << endl;
        default:
            cout << "Nice Meme" << endl;
    }

    // Array
    const int ARRAY_SIZE = 10;
    int numbers[ARRAY_SIZE] = {0,1,2,3,4,5,6,7,8,9}; // 10 elements: subscript 0-9
    for (int subscript : numbers) {
        cout << numbers[subscript];
        if (subscript != (ARRAY_SIZE-1)) {
            cout << ", ";
        } else {
            cout << "." << endl;
        }
    }
    
    //Pointers
    *(numbers+0) = 10;
    
    numbers[0] = 0;
    cout << numbers[0] << endl;
    int *numPtr = nullptr;
    numPtr = numbers;
    
    //Uses pointer to increment through array
    for (int count = 0; count < ARRAY_SIZE; count++) {
        cout << *(numPtr+count);
        if (count != (ARRAY_SIZE-1)) {
            cout << ", ";
        } else {
            cout << "." << endl;
        }
    }

    // Calling function
    functionDefined(someVal, whatIsThis);
    cout << "back inside main and 5 is now " << someVal << endl;
    defaultArgs();
    // Unconditionally shuts down program without continuing through rest of function
    exit(0);
    return 0;
}

// Defining a Function
// returnType functionName() {}
void functionDefined(int& value1, int value2) {
    value1++;
    cout << "This is the inside of functionDefined " << value1 << " " << value2 << endl;
    secondFunc(value2);
    cout << "back in this function" << endl;
    // Back inside main
}

void secondFunc(int value1) {
    // static local variable is created then will not be destroyed even though function finishes
    // only initiated once (if changed it will not reinitialize to 5)
    static int staticVar = 5;
    cout << "This is the second function " << value1 << endl;
    // Go back into functionDefined
}

// Default values for function can be set straight into the function rather than the prototype
// If some do not have a default value then they must be in front of the ones that do
void defaultArgs(int value1, int value2 = 11) {
    cout << value1 << " " << value2 << endl;
}
