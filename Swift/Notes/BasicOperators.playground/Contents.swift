//: The Swift Programming Language (Swift 4 beta): Language Guide

import UIKit

    //==> Seciton: Basic Operators <==//
// Logical operator '&&'
// Arithmetic operators (+,-,*,/,%) detect and disallow overflow:
var smallValue: Int8 = 1
/* smallValue = Int8.max + 1 // Will not be allow since it results in an overflow */
// Overflow operators: these should be used instead (&+, &-, &*) to allow overflow:
smallValue = Int8.max &+ 1 // Allows overflow behavior for integer calculations
// Range of values: (a..<b) and (a...b)
    //-> Subsection: Terminology <-//
// Operators are unary (1 outcome), binary (2 outcomes), or ternary (3 outcomes)
// Unary (1 outcome): -a (- single target), !b (! prefix), c! (postfix !)
// Binary (2 outcomes): 2 + 3 (+ infix since in between two targets)
// Ternary (3 outcomes): a ? b : c (The only ternary operator in Swift)
// Operands are the targets that the operators effect
    //-> Subsection: Assignment Operator <-//
// Assignment operator: initializes or updates the contents within a target
let b = 10
var a = 5
a = b // a is now equal to 10
// A tuple's contents is decomposed to initialize or update constants or variables with it's own
let (x,y) = (1,2) // x = 1, y = 2

    //==> Section: Arithmetic Operators <==//
// Arithmetic Operators: Addition (+), Subtraction (-), Multiplication (*), Division (/)
// Swift does not allow values to overflow by default
1 + 2 // equals 3
5 - 3 // equals 2
2 * 3 // equals 6
10.0 / 2.5 // equals 4.0
"hello, " + "world" // String concatenation: combines (String) values into one
    //-> Subsection: Remainder Operator <-//
// Remainder operator (%): (a % b) finds equal group(s) of b will fit into a, then returns the remainder
var aValue = 9, bValue = 4
var remainder = aValue % bValue // 2 equal groups of bValue fit into aValue; remainder left over is 1
/* <#aValue#> = (<#bValue#> * <#equalGroupsOfB#>) + <#remainder#> */
/* 9 = (4 * 2) + 1 */
// Finding remainder with a negative value
aValue = -9 // Now aValue = -9 and bValue is the same which = 4)
remainder = aValue % bValue // -2 equal groups of bValue fit into aValue; remainder left over is -1
/* <#aValue#> = (<#bValue#> * <#equalGroupsOfB#>) + <#remainder#> */
/* -9 = (4 * (-2)) + (-1) */
// If only bValue was (-), the remainder result would be equal as if both aValue and bValue were (+):
aValue = 9; bValue = 4
print(aValue%(-bValue)) // bValue = -4 in this operation temporarily
print(aValue%bValue)
    //-> Subsection: Unary Minus Operator <-//
// Unary Minus Operator (-<#value#>): Toggles a value's sign with a (-) prefix in front:
let three = 3 // three = 3
let minusThree = -three // minusThree = -3 since a negative version of three's value initializes it
let plusThree = -minusThree // plusThree=3 since a negative version of minusThree's value initializes it

    //==> Section: Compound Assignment Operators <==//
// Compound assignment operators: combine arithmetic operators (-,+,*,/) -> (-=, +=, *=, /=)
// Uses value that is being updated to compute it's own new value
var d = 40
d -= 4 // same as: d = d - 4     d now equals 36
d += 4 // same as: d = d + 4     d now equals 40
d *= 4 // same as: d = d * 4     d now equals 160
d /= 4 // same as: d = d / 4     d now equals 40

    //==> Section: Comparison Operators <==//
// Comparison operators (==, !=, <, <=, >, >=) compares left target to right target
1 == 1 // Is 1 equal to 1? true
2 != 1 // Does 2 NOT equal 1? true
2 > 1 // Is 2 greater than 1? true
1 < 2 // Is 1 less than 2? true
1 >= 1 // Is 1 greater than OR equal to 1? true
2 <= 1 // Is 2 less than OR equal to 1? false
// Some of these operators work on Strings as well
let name = "world"
if(name == "world") {
    print("These Strings are the same")
} else if(name != "world") {
    print("These Strings are not the same")
}
// This is true for tuples as well
// Using all comparison operators on tuples:
if( (1, "zebra") < (2, "apple") ) {
    print("1 is less than 2 so true! (zebra and apple comparison is skipped since 1 < 2 is true")
}
if( (3, "apple") < (3, "zebra") ) {
    print("3 is not less than 3. Apple is less than zebra so true!")
}
let valOne = "year"
let valTwo = 365
let valThree = "days"
let tuple = (valOne, valTwo, valThree), otherTuple: (String,Int,String) = ("year", 365, "days")
if(tuple == ("year", 365, "days")) { // Comparing a tuple to tuple values
    print("A \(tuple.0) has \(tuple.1) \(tuple.2)")
} else if(tuple == otherTuple) { // Comparing two tuples
    print("A \(tuple.0) has \(tuple.1) \(tuple.2)")
} else if(tuple != ("year", 365, "days")) {
    print("Your tuple does not contain the correct values")
}
    //==> Section: Ternary Conditional Operator <==//
// There is only one ternary conditional operator in swift:
// (<#question#> ? <#answerOne#> : <#answerTwo#>)
// Same as:
var questionOne = (1 == 1)
if(questionOne) {
    // answerOne is chosen since questionOne is true
    print("answerOne was chosen")
} else {
    // answerTwo is not chosen since questionOne is true
    print("answerTwo was chosen")
}
var blueSky = true
var isTheSkyBlue = blueSky ? "true.. The sky is blue!" : "false.. The sky is not blue :/"
print(isTheSkyBlue)
let contentHeight = 40
let hasHeader = true
let rowHeight = contentHeight + (hasHeader ? 50 : 20) // rowHeight is equal to 90 since 50 was chosen

    //==> Section: Nil-Coalescing Operator <==//
// Nil-coalescing operator (optionalA ?? nonOptionalB):
// Unwraps first optional (optionalA) if it contains a val,
// If not, return nonOptionalB's default value (which should be the same type as optionalA)
var optionalA: Int?
var nonOptionalB: Int = -1
// optionalA's value equals nil so nonOptionalB's value (-1) is the value returned
print(optionalA != nil ? optionalA! : nonOptionalB)
optionalA = 2
// optionalA's value DOES NOT equal nil so nonOptionalA's value of (2) is unwrapped then returned
//> Note: This is known as short-circuit evaluation
print(optionalA != nil ? optionalA! : nonOptionalB)
let defaultColorName = "red"
var userDefinedColorName: String?
// Uses defaultColorName's value to initialize since
// userDefinedColorName optional doesn't contain a value
var colorNameToUseOne = userDefinedColorName ?? defaultColorName // "red"
userDefinedColorName = "green"
// userDefinedColorName's unwrapped value is used since now it contains a String
var colorNameToUseTwo = userDefinedColorName ?? defaultColorName // "green"

    //==> Section: Range Operators <==//
// Range operators: shortcuts for expressing a range of values
    //-> Subsection: Closed Range Operator <-//
// Closed range operators: (a...b) include value (a) up to and including value (b)
for index in 1...5 {
    print("\(index) times 5 is \(index * 5)")
}
    //-> Subsection: Half-Open Range Operator <-//
// Half-Open Range Operator: (a..<b) include value (a) up to and doesn't include value (b)
// This is most useful when counting up zero-based array lists, but not down
let names = ["Anna", "Alex", "Brian", "Jack"]
for index in 0..<names.count { // index only goes up to 3, not 4 (amount of names in array)
    print("Person \(index + 1) is called \(names[index])")
}
    //-> Subsection: One-Sided Ranges <-//
// One-Sided Ranges: (...endHere) or (startHere...) or (..<endBeforeHere) or (startAfterHere<..)
for name in names[2...] { // Starts at index 2 and goes up until each index number is used after it
    print(name)
} // Brian Jack
for name in names[...2] { // Starts at very beginning of the array and goes up until it reaches index 2
    print(name)
} // Anna Alex Brian
// This cannot be done in the other direction:
for name in names[..<2] { // Starts at very beginning of the array and goes up until it reaches index 1
    print(name)
} // Anna Alex
let range = ...5 // ???? (-infinity to 5) ????
let doesRangeContain7 = range.contains(7) // false
let doesRangeContain4 = range.contains(4) // true
let doesRangeContainMinus1 = range.contains(-1) // true

    //==> Section: Logical Operators <==//
// Logical Operators: modify or combine Boolean logic values true and false:
// Logical NOT (!a), Logical AND (a && b), Logical OR (a || b)
//-> Subsection: Logical NOT Operator <-//
// Logical NOT (!a): Is (a) NOT true?
let allowedEntry = false
if(!allowedEntry) { // Is allowedEntry NOT true? true!
    // Code is executed
    print("ACCESS DENIED")
}
    //-> Subsection: Logical AND Operator <-//
// Logical AND (a && b):  Are both (a) AND (b) true?
let enteredDoorCode = true
let passedRetinaScan = false
if(enteredDoorCode && passedRetinaScan) { // Are both values true? false
    print("Welcome!")
} else { // This is executed since both values weren't true
    print("ACCESS DENIED")
}
    //-> Subsection: Logical OR Operator <-//
// Logical OR (a || b):   Is (a) OR (b) true?
let hasDoorKey = false
let knowsOverridePassword = true
if(hasDoorKey || knowsOverridePassword) { // Does ether have a value that equals true? true!
    // One value was true so this code is executed
    print("Welcome!")
} else {
    print("ACCESS DENIED")
}
    //-> Combining Logical Operators <-//
if(enteredDoorCode && passedRetinaScan || hasDoorKey || knowsOverridePassword ) {
    print("Welcome!")
} else {
    print("ACCESS DENIED")
}
//> Note: Logical operators are left-associative: left most expression or subexpression first
    //-> Section: Explicit Parentheses <-//
if( (enteredDoorCode && passedRetinaScan) || hasDoorKey || knowsOverridePassword) {
    print("Welcome!")
} else {
    print("ACCESS DENIED")
}
