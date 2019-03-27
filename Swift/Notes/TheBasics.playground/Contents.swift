//: The Swift Programming Language (Swift 4 beta): Language Guide

import UIKit
    //==> Seciton: The Basics <==//
// Tuples anable you to create and pass around groupings of values
//     (such as a returning in a function)
// Optionals handle the absence of a value similar to using nil with pointers
//     (for any type and safer/more expressive than Objective-C) -> (type-safe language)

    //==> Section: Constants and Variables <==//
// Constant values cannot be changed once they are set
    //-> Subsection: Declaring Constants and Variables <-//
// Use (let) for constants and (var) for variables to decalre them before they can be used
//> Note: Constants like this cannot be changed after initialization
let maximumNumberOfLoginAttempts = 10 // If changed there will be a compile-time error
//> Note: Variables such as this can be changed after initialization
var currentLoginAttempt = 0
var x = 0.0, y = 0.0, z = 0.0 // Declare multiple constants or variables on a single line using (,'
    //-> Subsection: Type Annotations <-//
// Set a explicit type for constant or variable by using a (: ) then type name such as (Int'
var welcomeMessage: String
// print(welcomeMessage) // This variable cannot be used since variable isn't initialized yet
welcomeMessage = "Hello" // Initialization of String variable wecomeMessage
// Declare multiple constants or variables with the same explicit type by including a type annotation at the end
var red, green, blue: Double // Now all these variables can only take in type Double values
//> Note: Type annotations should not be used most of the time since Swift infers, implicitly, the type needed when initialized
let π = 3.14159 // ???? Couldn't figure out how to input the unicode value for pi symbol ????
// let 你好 = "你好世界” // ???? Undetermined string literal ????
let 😄 = "happy" // Emojis can be used for constant or variable names
var `for` = 2 // Can use Swift language terms enclosed in (`) (backtick), but you shouldn't
var friendlyWelcome = "Bonjour"
    //-> Subsection: Printing Constants and Variables <-//
// Prints out one or more values in Xcode's console
// print(_: separator: terminator:) is the syntax
print("Wow") // Adds a new line by default
print("Wow",terminator: "") // Does no add a new line
print("The current value of friendlyWelcome is \(friendlyWelcome)") // Stirng interpolation
    //-> Subsection: Comments
// Single line comments (//'
// Multiline comments (/* */) which can be nested in other multi line comments unlike C:
/* This is the start of the first multiline comments.
 /* This is the second, nested multiline comment. */
 This is the end of the first multiline comment. */
    //-> Subsection: Semicolons <-//
// Semicolon (;) isn't required to end statements in Swift,
// but can, and must, be used to write multiple statements on one line
let cat = "🐱"; print(cat);

    //==> Section: Integers <==//
// Integers; signed (positive,zero,negative) or unsigned (positive,zero)
// 8, 16, 32, and 64bit forms; use (U) for unsigned (UInt8), no (U) for signed (Int8)
var value1: UInt8 = 43, value2: Int8 = -23 // Unsigned since positive, signed since negative
    //-> Integer Bounds <-//
// Accessing minimum and maximum values of each integer type with (min) and (max) properties
let minValue = UInt8.min // minValue is equal to 0, and is of type UInt8
let maxValue = UInt8.max // maxValue is equal to 255, and is of type UInt8
// var value3: UInt8 = 256 // This would overflow since the value isn't in the bounds of 0 - 255
// var value4: UInt8 = -1 // This would also overflow since the value isn't in the bounds of 0 - 255
    //-> Subsection: Int <-//
// (Int) type is used dynamicaly depending on platform; 32bit (Int32) or 64bit (Int64)
var value5: Int = 4 // Would translate to (: Int32) or (: Int64) depending on 32bit or 64bit OS
// (Int) should always be used for interoperability; bounds are (-+)2,147,483,648 for (Int'
// Interoperability: the ability of computer systems or software to exchange and make use of information
    //-> Subsection: UInt <-//
// (UInt) type is used dynamicaly, just as (Int', depending on platform; 32bit (UInt32) or 64bit (UInt64)
// Unsigned integers should be avoided unless the same size of platform's native word size is needed

    //==> Section: Floating-Point Numbers <==//
// Floating-Point numbers contain a fractional component that is in decimal form
// Type (Float) (6 decimal digits) and (Double) (15 decimal digits) can be used
//> Note: Type (Double) is prefered over (Float'

    //==> Section: Type Safety and Type Inference <==//
// Swift is a type-safe language: encourages you to be clear about the types of values your code uses
// Type checks are performed during compile time
// Explicit type declarations are not required since Swift uses type inference at compile time
// To determine the type Swift uses a literal initializing the constant or variable like (42':
let meaningOfLife = 42 // Swift infers that you want the constant (value6) to be a (Int) type by default
let pi = 3.14159 // Swift infers the you want the constant (pi) to be a (Double) type by default
let anotherPi = 3 + 0.14159 // Both 3 and 0.14159 don't have a type, but is infered once added together

    //==> Section: Numeric Literals <==//
// Can be writen as: Decimal (.12), Binary (0b prefix), Octal (0o prefix), or Hexadecimal (0x prefix)
let decimalInteger = 17 // Decimal notation of 17
let binaryInteger = 0b10001 // Binary notation of 17
let octalInteger = 0o21 // Octal notation of 17
let hexadecimalInteger = 0x11 // Hexadecimal notation of 17
// Floating-point literals: Number/hexadecimal number must be on both sides of decimal
// Decimal can have optional exponent (e) or (E) (same thing)
print(1.25e2) // 1.25 * 10^2 = 125.0 (Float'
print(1.25e-2) // 1.25 * 10^(-2) = 0.0125 (Float
// Hexadecimal MUST have exponent using (p'
print(0xFp2) // [0xF = 15; p2 = 2^2] = 15 * 2^2 = 60.0
print(0xFp-2) // [0xF = 15; p2 = 2^(-2)] = 15 * 2^(-2) = 3.75
// All of these floating-point literals have a decimal value of 12.1875
let decimalDouble = 12.1875
let exponentDouble = 1.21875e1
let hexadecimalDouble = 0xC.3p0
// Numeric literals extra formatting (for easier readability); (Int) and (Float) can contain underscores
let paddedDouble = 000123.456
let oneMillion = 1_000_000
let justOverOneMillion = 1_000_000.000_000_1

    //==> Section: Numeric Type Conversion <==//
// Always use (Int) unless other integer types are needed for the task at hand:
// These other types can be used to increase performance and memory usage
// They can also handle overflows and implicitly document the nature of data being used
    //-> Subsection: Integer Conversion <-//
//
let twoThousand: UInt16 = 2_000
var one: UInt8 = 1
let twoThousandAndOne = twoThousand + UInt16(one) // (one) is used to make a temporary UInt16 value
// one = UInt8.max + 1 // This will still cause an overflow since (one) was not converted, it's self
    //-> Subsection: Integer and Floating-Point Conversion <-//
// This type of conversion must be made explicit
let three = 3
let pointOneFourOneFiveNine = 0.14159
let pii = Double(three) + pointOneFourOneFiveNine
// An integer type can be initialized with a (Double) or (Float) value
let integerPi = Int(pii) // 3
let negIntPi = Int(-pii) // -3
//> Note: literal values do not have a type,
//  but once final initialization value is found, then type is found:
var piValue = 3 + 0.14159 // Double since 3.14159 is type Double

    //==> Section: Type Aliases <==//
// You can create a keyword for a type when working with data of a specific size from an external source
typealias AudioSample = UInt16
var maxAmplitudeFound = AudioSample.min // maxAmplitudeFound is now 0

    //==> Section: Booleans <==//
// A (Bool) is a Boolean which is considered a logical since it can only be true or false
let orangesAreOrange = true
let turnipsAreDelicious = false
if(turnipsAreDelicious) {
    print("Mmm, tasty turnips!")
} else if(orangesAreOrange) {
    print("Eww, turnips are horrible.") // This will be printed
}
let i = 1
//if i {
//    // This will result in a compile error since an (Int) cannot be converted into a (Bool) logical:
//}
if(i == 1) {
    // But this will since the condition (i == 1) can be only true or false (true in this case)
}

    //==> Section: Tuples <==//
// Tuples: a single compound value that contains can contain multiple values of same or different types
//> Note: These are useful by being able to return multiple values in a function temporarily
//> Note: They should not be used as data structures since once out of scope, they can be accessed
let http404Error = (404, "Not Found") // Same as: let http404Error: (Int, String) = (404, "Not Found")
// Decompose a tuple's contents into separate constants or variables:
let (statusCode, statusMessage) = http404Error // http404Error tuple initializes these constants
// Use (_) when you need just need different parts of the tuple, but not the whole thing:
let (justTheStatusCode, _) = http404Error // justTheStatusCode = 404; Second (http404Error'value not used
print("The status code is \(justTheStatusCode)")
// Alternatively use a (.) then an index number (0', for example, after tuple to access a specific value:
print("The status code is \(http404Error.0)") // http404Error = 404; Same as statement above
print("The status message is \(http404Error.1)") // http404Error.1 = "Not Found"
// Naming a tuple's values:
let http200Status = (statusCode: 200, description: "Ok") // Tuple is declared with names for values
// Use value names in tuple to access their contents
print("The status code is \(http200Status.statusCode)") // http200Status.statusCode = 200
print("The status message is \(http200Status.description)") // http200Status.description = "OK"

    //==> Section: Optionals <==//
// Optionals should be used when a value may be absent and has two possibilities
// There is a value that can be accessed when unwrapping optional, or there isn't a value
//> Note: Swift's optionals let you indicate the absence of a value for ANY TYPE without special constant
let possibleNumber = "123"
// (Int?) optional is inferred since the conversion of (String) may or may not have an (Int) value
// if possibleNumber has a value of "Hello", there would be no (Int) value for convertedNumber
let convertedNumber = Int(possibleNumber) // same as (let convertedNumber: Int? = Int(possibleNumber)'
//> Note: (nil) can only be used to set optional constants or variables to a valueless state
// This is done automatically when first initializing an optional without a value
var surveyAnswer: Int? // Same as (var surveyAnswer: Int? = nil'
    //-> Subsection: If Statements and Forced Unwrapping <-//
// To find out if an optional has a value, use an if statement comparing the optional to (nil'
// Only if an optional contains a value, then (!) can be used after optional to unwrap
// There will be a runtime error an optional that contains no value (nil) is unwrapped
if(convertedNumber != nil) {
    print("convertedNumber has an integer value of \(convertedNumber!).")
}
    //-> Subsection: Optional Binding <-//
// Optional Binding: a statement that checks if a optional contains a value
// After the check, then the value is made available through a constant or variable
/*
 if let <#constantName#> = <#someOptional#> { // Checks if a value is inside the optional
    <#statements#> // Uses the value found through the temp variable (constantName) (or (variableName')
}
 */
if let actualNumber = Int(possibleNumber) {
    //> Note: Temporary constant (actualNumber) type (Int?) that contains a value can only be used here
    print("\"\(possibleNumber)\" has an integer value of \(actualNumber)")
} else {
    // Temporary constant (actualNumber) cannot be used here since unwrapping failed
    print("\"\(possibleNumber)\" could not be converted to an integer")
} // Prints ""123" has an integer value of 123"
//> Note: a (guard) statement allows the contents to be used throughout the rest of the code within a func:
func stringToIntOptional(_ stringValue: String) {
    guard let actualNumber = Int(stringValue) else { // This will not be converted from (String) to (Int'
        // Temporary constant (actualNumber) cannot be used here since unwrapping failed
        print("stringToIntOptional: The string could not be converted to an integer")
        return
    } // Same as if let statement above, but shorter and the (actualNumber) value can be used after
    print("stringToIntOptional: Conversion successful and the number is \"\(actualNumber)\"")
}
stringToIntOptional("Hello")
stringToIntOptional("123")
// In this example string literals "4" and "42" are attempted to be unwrapped into optionals
if let firstNumber = Int("4"), let secondNumber = Int("42"), // optionals: (firstNumber) and (secondNumber'
        (firstNumber < secondNumber && secondNumber < 100) {
    print("\(firstNumber) < \(secondNumber) < 100")
} // Prints "4 < 42 < 100"
// The same if statement as shown above
if let firstNumber = Int("4") {
    if let secondNumber = Int("42") {
        if(firstNumber < secondNumber && secondNumber < 100) {
            print("\(firstNumber) < \(secondNumber) < 100")
        }
    }
} // Prints "4 < 42 < 100"
//> Note: ???? (guard': the constant or variable can be used throughout all lines of code after it ????
    //-> Subsection: Implicitly Unwrapped Optionals <-//
// Implicitly unwrapped optionals: this type of optional does not need to be checked
// They can be unwrapped with (!) after the optional name; primary use is during class initialization
// They can be treated as if they were a normal optional using optional binding
let possibleString: String? = "An optional String" // Requires (!) to be unwrapped
let forcedString: String = possibleString! // Unwraps without the need for checking if it contains a value
let assumedString: String! = "An implicitly unwrapped optional String." // No (!) required to be unwrapped
let implicitString: String = assumedString
//> Note: if an implicitly unwrapped optional contains (nil) then runtime error will happen if unwrapped
//> Note: Do not use an implicitly unwrapped optional if can become (nil) at a later point

    //==> Section: Error Handling <==//
// Error handling: respond to error conditions that may or may not happen during execution
// This allows you to find the underlying cause of failure, and propagate the error
// In functions a (throws) is needed if the statement might (throw) an error:
func canThrowAnError() throws {
    
}
// Swift automatically propagates errors out of their current scope
// do statements allows errors to be propagated to one or more catch clauses
do {
    try canThrowAnError() // since this doesn't throw an error, the catch clause is not used
} catch { // Swift automatically propagates a thrown error in do to this catch clause with (error'
    // catch clause is the same as: } catch(error) {
    // if (canThrowAnError()) threw an error this body would be executed
    print(error)
}
/* Error handling example: */
// Error protocol that implements error class
enum SandwichError: Error {
    case outOfCleanDishes
    case missingIngredients([String])
}
func makeASandwich() throws {
    // ...
    let ingredients: [String] = ["bread", "lettice", "meat", "cheese", "sauce"]
    // throw SandwichError.outOfCleanDishes // Will propogate error to first catch clause below
    throw SandwichError.missingIngredients(ingredients) // Will propogate error to second catch clause below
}
func buyGroceries(_ ingredients: [String]) {
    // ...
    print("Bought \(ingredients)")
}
func eatASandwich() {}
func washDishes() {}
do {
    try makeASandwich() // Might throw an error
    eatASandwich() // If it doesn't, run (eatASandwich()'
} catch SandwichError.outOfCleanDishes { // See (makeASandwich()) for error
    washDishes()
} catch SandwichError.missingIngredients(let ingredients) { // See (eatASandwich()) for error
    buyGroceries(ingredients)
}

    //==> Section: Assertions and Preconditions <==//
// Assertions and preconditions: checks that make sure a condition is satisfied before executing code
// If the condition is not met, then the application terminates
/* assert(<#condiiton#>,<#message#>) */
let age = -3
// assert(age >= 0, "A person's age can't be less than zero.") // Stops here since condition is not met
// Use assertionFailure() to run failure so program will stop, without a condition to be met
if (age > 10) {
    print("You can ride the roller-coaster or the ferris wheel.")
} else if(age > 0) {
    print("You can ride the ferris wheel.")
} else {
    // assertionFailure("A person's age can't be less than zero.") // Stops here without a condition
}
    //-> Subsection: Enforcing Preconditions <-//
// Precondition: should be used when a condition has the potential to be false
// ???? What's the difference between assert and precondition ????
var index = 1
precondition(index > 0, "Index must be greater than zero.")
index = 0
//> Note: In unchecked mode (-Ounchecked), preconditions are not checked (conditions always true)
//> Note: (fatalError(_:file:line:)) always halts application (they are used at stub implementations)
