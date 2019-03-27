//: The Swift Programming Language (Swift 4 beta): Welcome to Swift (pages 5 - 43)

import UIKit

print("Hello World!") // Statements donnot need semicolons

    //==> Section: Simple Values <==//
var myVariable = 42 // Implicit Int variable that can be changed
myVariable = 50
let myConstant = 42 // Implicit Int constant that cannot be changed

let implicitInteger = 70 // Implicit Int constant that cannot be changed
let implicitDouble = 70.0 // Implicit Double constant that cannot be changed
let explicitDouble: Double = 70 // Explicit Double constant that cannot be changed
//> Experiment: Explicit Float constant of value 4 that cannot be changed <//
let four: Float = 4

let label = "The width is "
let width = 94
//> Experiment: if String() is taken away; Error: non-matching parameters & fails to implicitly choose type <//
let widthLabel = label + String(width) // Converted (width) to type String to initialize (widthLabel'

let apples = 3
let oranges = 5
let appleSummary = "I have \(apples) apples."
let fruitSummary = "I have \(apples + oranges) peices of fruit."
//> Experiment: Use \() and include floating point calc in a greating with someone's name <//
print("]")

//let quotation = """
//Even though there's whitespace to the left,
//the actual lines aren't indented.
//Except for this line.
//Double quotes ("") can appear without being escaped.
//I still have \(apples + oranges) pieces of fruit.
//"""
//print(quotation)

var shoppingList = ["catfish","water","tulips","blue","paint"] // Implicit String array
shoppingList[1] = "bottle of water" // Set element 1 to a different string value
var occupations = ["Malcolm": "Captain","Kaylee": "Mechanic"] // Dictionary: key = String, val = String
occupations["Jayne"] = "Public Relations" // ???? Where did the key "Jayne" ????

let emptyArray = [String]() // Empty String array
let emptyDictionary = [String: Float]() // Empty String:Float Dictionary
print(shoppingList)
shoppingList = [] // Sets array contents to empty
print(shoppingList)
print(occupations)
occupations = [:] // Sets dictionary contents to empty
print(occupations)

    //==> Section: Control Flow <==//
// if and switch statements are conditionals {braces are needed always}
// for-in, while, repeat-while statements are loops
let individualScores = [75,43,103,87,12]
var teamScore = 0
for score in individualScores {
    if(score > 50) {
        teamScore += 3
    } else {
        teamScore += 1
    }
}
print(teamScore)

// (if let) works with optionals which are set by a (?'
var optionalString: String? = "Hello" // Explicit String optional
print(optionalString == nil) // Shows if optional has a value (true or false)
//> Experiment: If (optionalName) is changed to nil, (if let) statement that follows will not run <//
var optionalName: String? = "John Appleseed"
var greeting = "Hello!"
if let name = optionalName {
    greeting = "Hello, \(name)"
    print(greeting)
}
let nickName: String? = nil
let fullName: String = "John Appleseed"
let informalGreeting = "Hi \(nickName ?? fullName)" // nickName is nil, use fullName
print(informalGreeting)

let vegetable = "red pepper"
//> Experiment: If default case is removed, COMPILE ERROR: Switch must be exhaustive <//
switch vegetable { // Switch requires default option and exits upon case satisfied
case "celery":
    print("Add some raisins and make ants on a log.")
case "cucumber", "watercress":
    print("That would make a good tea sandwich.")
case let x where x.hasSuffix("pepper"): // ???? Checks for a certain suffix String in (vegetable'? ????
    print("Is it a spicy \(x)")
default:
    print("Everything tastes so good in soup.")
}

let interestingNumbers = [ // Implicit String:Int[] Dictionary
    "Prime": [2,3,5,7,11,13],
    "Fibonacci": [1,1,2,3,5,8],
    "Square": [1,4,9,16,25]
]
var largest = 0, largestKind = ""
var isInteger: Bool, isDouble: Bool, isFloat: Bool
//> Experiment: Add variable to track largest number type <//
for(kind,numbers) in interestingNumbers { // Use (kind) for String key and (numbers) for Int value[]
    for number in numbers { // Initialize (number) to current element value (Iterate through (numbers) array)
        if(number > largest) { // Checks if (number) is bigger then previous (largest'
            largestKind = kind
            largest = number
        }
    }
}
print("value: \(largest), kind: \(largestKind)")

var n = 2
while(n < 100) {
    n *= 2
}
print(n)

var m = 2
repeat {
    m *= 2
} while(m < 100)
print(m)

var total = 0
for i in 0..<4 { // ..< range of indexes; 0 + 1 + 2 + 3; Stops at 4
    total += i
}
print(total)

    //==> Section: Functions and Closures <==//
func greet(_ person: String, on day: String) -> String { // (_) = no argument and (on) = custom argument
    return "Hello \(person), today is \(day)."
}
print(greet("John",on:"Wednesday"))

// Tuple returns multiple values from a function
func calculateStatistics(scores: [Int]) -> (min: Int,max: Int,sum: Int) {
    var min = scores[0]
    var max = scores[0]
    var sum = 0
    for score in scores { // Iterates through scores[]
        if(score > max) { // Checks to see if the (scores[index]) is greater then previous max value
            max = score
        } else if(score < min) { // Checks to see if the (scores[index]) is greater then previous min value
            min = score
        }
        sum += score // Addes up all values
    }
    return(min,max,sum)
}

let statistics = calculateStatistics(scores:[5,3,100,3,9]) // Implicit tuple compound value
// Both print statements are the same
print("Min: \(statistics.min), Max: \(statistics.max), Sum: \(statistics.sum)")
print("Min: \(String(statistics.0)), Max: \(String(statistics.1)), Sum: \(String(statistics.2))")

// Functions are a first class type (Can return another function)
func returnFifteen() -> Int {
    var y = 10
    func add() -> Int{
        y += 5
        return y
    }
    return add()
}
print(returnFifteen())

// Closures are blocks of code that can be called later
// These have access to variables and functions
func hasAnyMatches(list: [Int], condition: (Int) -> Bool) -> Bool { // Takes in array and function(Int) -> Bool
    for item in list { // Iterates through (list) array values
        if(condition(item)) { // Uses array value in (condition(Int)) function
            return true
        }
    }
    return false
}
func lessThanTen(number: Int) -> Bool {
    return number < 10
}
var numbers = [20,19,7,12]
var answer = hasAnyMatches(list: numbers, condition: lessThanTen)
print("Are any of the numbers less then 10? \(answer)")

//> Experiment: Add functionality to return zero for all odd numbers <//
let mappedNumbers1 = numbers.map({ (number: Int) -> Int in
    let result: Int
    if(number % 2 == 0) { // Dectects even numbers and keeps then
        result = 3 * number
    } else { // Odd numbers turn to 0
        result = 0
    }
    print(result)
    return result
})
print(mappedNumbers1)
let mappedNumbers2 = numbers.map({ number in 3 * number})
print(mappedNumbers2)

let sortedNumbers1 = numbers.sorted { $1 < $0 } // Largest to smallest
print(sortedNumbers1)
let sortedNumbers2 = numbers.sorted { $0 < $1 } // Smallest to largest
print(sortedNumbers2)

    //==> Section: Objects Classes <==//
//> Experiment: Add constant property and add method that takes an element <//
class Shape {
    let constantProperty: Bool = true
    var numberOfSides = 0
    func simpleDescription() -> String {
        return "A shape with \(numberOfSides) sides."
    }
    func anotherMethod(const: Bool) {
        
    }
}
var shape = Shape()
shape.numberOfSides = 7
var shapeDescription = shape.simpleDescription()
print(shapeDescription)

class NamedShape {
    var name: String = "Shape"
    var numberOfSides: Int = 0
    init(name: String, numberOfSides: Int) {
        self.name = name
        self.numberOfSides = numberOfSides
    }
    func simpleDescription() -> String {
        return "A \(self.name) with \(self.numberOfSides) sides."
    }
    deinit { // This is performed before the object is dealocated
        // Code to complete before dealocation
    }
}

class Square: NamedShape {
    var sideLength: Double
    init(name: String, sideLength: Double) {
        self.sideLength = sideLength
        super.init(name: "Square", numberOfSides: 4)
    }
    func area() -> Double {
        return sideLength * sideLength
    }
    // Has to use the same conditions (String,Int)
    override func simpleDescription() -> String {
        return "A \(self.name) with \(self.numberOfSides) sides. How boring!"
    }
}
//> Experiment: Create Circle subclass to NamedShape; implement area() and simpleDescription() <//
class Circle: NamedShape {
    var radius: Double
    let pi: Double = 3.14
    init(name: String, radius: Double) {
        self.radius = radius
        super.init(name: "Circle", numberOfSides: 0)
    }
    func area() -> Double {
        return pi * pow(radius,2)
    }
    override func simpleDescription() -> String {
        return "A \(self.name) with \(self.numberOfSides) sides. Now that's smooth"
    }
}

let test = Square(name: "my test square", sideLength: 5.2)
let circ = Circle(name: "Square", radius: 5)
print(test.area())
print(test.simpleDescription())
print(circ.area())
print(circ.simpleDescription())

class EquilateralTriangle: NamedShape {
    var sideLength: Double = 0.0
    init(name: String, sideLength: Double) {
        self.sideLength = sideLength
        super.init(name: "Equilateral Triangle", numberOfSides: 3)
    }
    var perimeter: Double { // Get-set statement makes this variable dynamic depending on sideLength value
        get { // If called get code will be ran and a Double value will be returned as follows
            return 3.0 * self.sideLength
        } set(newValue) { // Perimeter is changed and the following code is ran (Implicit name is newValue)
            self.sideLength = newValue / 3.0
        }
    }
    override func simpleDescription() -> String {
        return "An equilateral triangle with sides of length \(self.sideLength)"
    }
}

var triangle = EquilateralTriangle(name: "a triangle", sideLength: 3.1)
print(triangle.perimeter)
triangle.perimeter = 9.9 // Sets sideLength to 3.3
print(triangle.sideLength)

class TriangleAndSquare {
    var triangle: EquilateralTriangle {
        willSet { // Will create an instance in the future
            square.sideLength = newValue.sideLength
        }
    }
    var square: Square {
        willSet { // Will create an instance in the future
            triangle.sideLength = newValue.sideLength
        }
    }
    init(size: Double, name: String) {
        square = Square(name: name, sideLength: size)
        triangle = EquilateralTriangle(name: name, sideLength: size)
    }
}
var triangleAndSquare = TriangleAndSquare(size: 10, name: "another test shape")
print(triangleAndSquare.square.sideLength)
print(triangleAndSquare.triangle.sideLength)
triangleAndSquare.square = Square(name: "larger square", sideLength: 50)
print(triangleAndSquare.triangle.sideLength)

let optionalSquare: Square? = Square(name: "optional square", sideLength: 2.5)
let sideLength = optionalSquare?.sideLength

    //==> Section: Enumerations and Scructures <==//
enum Rank: Int {
    // The raw value of these cases start at 0 since ace is 0 and the others aren't initialized
    // By default it starts the values at 0
    // Strings or Floating point numbers can also be used instead for rawValue
    case ace = 0
    case one, two, three, four, five, six, seven, eight, nine, ten // 1-10
    case jack, queen, king // 11-13
    func simpleDescription() -> String {
        switch self {
        case .ace:
            return "ace"
        case .jack:
            return "jack"
        case .queen:
            return "queen"
        case .king:
            return "king"
        default:
            return String(self.rawValue)
        }
    }
}
let ace = Rank.ace // Enum Rank ace case instance
let aceRawValue = ace.rawValue
let king = Rank.king // Enum Rank king case instance
let kingRawValue = king.rawValue
let three = Rank.three // Enum Rank three case instance
let threeRawValue = three.rawValue
print("'ace) case name: \(ace), (king) case name: \(king), (three) case name: \(three)")
print("Ace value: \(ace.rawValue), King value: \(king.rawValue), (three) value: \(three.rawValue)")
//> Experiment: Write a function that compares two Rank values by their raw values <//
if(ace.rawValue == king.rawValue) { // Compares Ints (case values)
    print("Their raw values are the same")
} else {
    print("They are different")
}

if let convertedRank1 = Rank(rawValue: 3) { // If (Rank) has a case with a value of (3) then set to name
    // convertedRank1 equals case name which is "three"
    // Uses switch statement in (Rank) enum with case "three" & converts rawValue Int 3 to String "3"
    let threeDescription = convertedRank1.simpleDescription() // "3"
    print(threeDescription)
}
if let convertedRank2 = Rank(rawValue: 0) { // If (Rank) has a case with a value of (0) then set to name
    // convertedRank2 equals case name which is "ace"
    // Uses switch statement in (Rank) enum with case "ace" & returns String "ace"
    let threeDescription = convertedRank2.simpleDescription() // "ace"
    print(threeDescription)
}

enum Suit {
    case spades, hearts, diamonds, clubs
    func simpleDescription() -> String {
        switch self {
        case .spades:
            return "spades"
        case .hearts:
            return "hearts"
        case .diamonds:
            return "diamonds"
        case .clubs:
            return "clubs"
        }
    }
    //> Experiement: Add color() method that returns String "red" or "black" depending on case <//
    func color() -> String {
        switch self {
        case .spades, .clubs: // Ether spades or clubs cases
            return "black"
        case .hearts, .diamonds: // Ether hearts or diamonds cases
            return "red"
        }
    }
}
let hearts = Suit.hearts // hearts enum case
let heartsDescription = hearts.simpleDescription() // "hearts"
let heartsColor = hearts.color() // "red"

enum ServerResponse {
    case result(String, String)
    case failure(String)
    //> Experiment: Add a thrid case <//
    case error(String)
}
let success = ServerResponse.result("6:00 am", "8:09 pm")
let failure = ServerResponse.failure("Out of cheese.")
let error = ServerResponse.error("Something went wrong.")

switch success {
case let .result(sunrise, sunset): // Uses enum result case and success values "6:00 am" & "8:09 pm"
    print("Sunrise is at \(sunrise) amd sunset is at \(sunset).")
case let .failure(message):
    print("Failure... \(message)")
case let .error(error):
    print(error)
} // Returns "Sunrise is at 6:00 am amd sunset is at 8:09 pm."
switch failure {
case let .result(sunrise, sunset):
    print("Sunrise is at \(sunrise) amd sunset is at \(sunset).")
case let .failure(message): // Uses enum result case and success values "Out of cheese."
    print("Failure... \(message)")
case let .error(error):
    print(error)
} // Returns "Failure... Out of cheese."
switch error {
case let .result(sunrise, sunset):
    print("Sunrise is at \(sunrise) amd sunset is at \(sunset).")
case let .failure(message): // Uses enum result case and success values "Out of cheese."
    print("Failure... \(message)")
case let .error(error):
    print(error)
} // Returns "Something went wrong."

// A Structure is just like classes, but are copied when passed (creates new instance)
// Classes on the other hand are passed by reference (uses same instance)
struct Card {
    var rank: Rank
    var suit: Suit
    func simpleDescription() -> String {
        return "The \(rank.simpleDescription()) of \(suit.simpleDescription())"
    }
    //> Experiment: add method that creates a full deck of cards in an array <//
    // Credit: https://stackoverflow.com/questions/32952248/get-all-enum-values-as-an-array
    func createDeck() -> [Card] {
        // Creates instances of each rank case in enum Rank
        let ranks = [Rank.ace, Rank.one, Rank.two, Rank.three, Rank.four, Rank.five, Rank.six, Rank.seven, Rank.eight, Rank.nine, Rank.ten, Rank.jack, Rank.queen, Rank.king]
        // Creates instances of each rank case in enum Suit
        let suits = [Suit.spades, Suit.hearts, Suit.diamonds, Suit.clubs]
        var deck = [Card]()
        // Uses instances of ranks and suits to add all types to the (deck) array of all the cards
        for suit in suits {
            for rank in ranks {
                deck.append(Card(rank: rank, suit: suit))
            }
        }
        return deck
    }
}
let threeOfSpades = Card(rank: .three, suit: .spades)
let threeOfSpadesDescription = threeOfSpades.simpleDescription()

var cards = Card(rank: .ace, suit: .spades) // Creates instance of Card structure to use createDeck method
var completeDeck: [Card] = cards.createDeck() // Creates full deck of cards

// ???? What is a protocol ???? (Swift's version of interfaces found in Java)
// Protocols are shorthanded classes without bodies ment to be implemented in others as a super class
// Can specify properties that must be implemented such as fields
// Implments value and(or) reference through the keyword (mutating) (structs and classes can implement it)
// Protocols can be combined using (protocol<ExampleProtocol1, ExampleProtocal2>'
protocol ExampleProtocol1 {
    var simpleDescription: String { get } // Must create simpleDescription of type String
    mutating func adjust() // Must create adjust method
}
protocol ExampleProtocol2 {
    var testString: String { get }
}

// Must implement ExampleProtocol1's stubs
class SimpleClass: ExampleProtocol1 {
    var simpleDescription: String = "A very simple class."
    var anotherProperty: Int = 69105
    func adjust() {
        simpleDescription += " Now 100% adjusted."
    }
}
var a = SimpleClass()
a.adjust()
let aDescription = a.simpleDescription

// Must implement ExampleProtocol1's stubs
struct SimpleStructure: ExampleProtocol1 {
    var simpleDescription: String = "A simple structure"
    mutating func adjust() { // ???? (mutating) is used for structs which creates it's own copy ????
        simpleDescription += " (adjusted by structure)"
    }
}
// Must implement ExampleProtocol1 & ExampleProtocol2's stubs
struct MultiProtoClass: ExampleProtocol1, ExampleProtocol2 {
    var simpleDescription: String = "Must implement this variable from ExampleProtocol1"
    mutating func adjust() {
        simpleDescription += "Same goes for this method"
    }
    var testString: String = "Same for this one, but because of protocol ExampleProtocol2"
}
var b = SimpleStructure()
b.adjust()
let bDescription = b.simpleDescription

//> Experiment: Write enum that uses ExampleProtocol1 <//
// Enum cannot implement ExampleProtocol1 since it cannot store values, such as String simpleDescription
//enum ConformedProtocol: ExampleProtocol1 {
//    
//}
extension Int: ExampleProtocol1 {
    var simpleDescription: String {
        return "The number \(self)"
    }
    mutating func adjust() {
        self += 42
    }
}
print(7.simpleDescription)
var adjustedValue: Int = 8
adjustedValue.adjust()
//7.adjust() // This cannot be done since it is immutable literal
print(adjustedValue) // 50

let protocolValue: ExampleProtocol1 = a // a = SimpleClass instance
print(protocolValue.simpleDescription)
// print(protocolValue.anotherProperty) // Error: no member of protocolValue instance named anotherProperty

    //==> Section: Error Handling <==//
// Custom error protocol that implements error class
enum PrinterError: Error {
    case outOfPaper
    case noToner // This case is called on second do-catch
    case onFire // This case is called on third do-catch
}
// (throws) marks a function that can throw
func send(job: Int, toPrinter printerName: String) throws -> String {
    if(printerName == "Out of Paper") {
        throw PrinterError.outOfPaper // throws an error
    }
    if(printerName == "Never Has Toner") {
        throw PrinterError.noToner // throws an error
    }
    if(printerName == "Paper of Fire") {
        throw PrinterError.onFire // throws an error
    }
    return "Job sent"
}
// do-catch is a way to handle an error
do {
    let printerResponse = try send(job: 1040, toPrinter: "Bi Sheng")
    print(printerResponse)
} catch { // error is an implicit variable
    print(error)
}
let printerSuccess = try? send(job: 1040, toPrinter: "Bi Sheng") // Handles error like do-catch above

//> Experiment: Change printer String input to "Never Has Toner" <//
// do-catch is a way to handle an error (this is one here)
do {
    let printerResponse = try send(job: 1041, toPrinter: "Never Has Toner")
    print(printerResponse)
} catch(PrinterError.noToner) { // error is an implicit variable
    print(error)
}
let printerFailure = try? send(job: 1041, toPrinter: "Never Has Toner") // nil is saved since error thrown

do {
    //> Experiment: throw an error inside the do block <//
    let printerResponse = try send(job: 1442, toPrinter: "Gutenberg")
//  throw PrinterError.onFire // First catch block will be called since it has a explicit error
//  throw PrinterError.noToner // Second catch block will be called since it has an explicit error protocol
//// ???? Couldn't find a way to call last catch block ????
    print(printerResponse)
} catch(PrinterError.onFire) {
    print("I'll just put this over here, with the rest of the fire.")
} catch let printerError as PrinterError {
    print("Printer error: \(printerError).")
} catch {
    print(error)
}

var fridgeIsOpen = false
let fridgeContent = ["milk", "eggs", "leftovers"]
func fridgeContains(_ food: String) -> Bool {
    fridgeIsOpen = true
    defer {
        fridgeIsOpen = false
    }
    let result = fridgeContent.contains(food) // ???? Where did the food variable come from ????
    return result
}
fridgeContains("banana")
print(fridgeIsOpen)

    //==> Section: Generics <==//
// Creates an array of items
func makeArray<Item>(repeating item: Item, numberOfTimes: Int) -> [Item] {
    var result = [Item]()
    // _ means there is no value used for an index in loop
    for _ in 0..<numberOfTimes {
        result.append(item)
    }
    return result
}
var itemArray = makeArray(repeating: "knock", numberOfTimes: 4)

// This reimplements the Swift standard library's optional type
enum OptionalValue<Wrapped> {
    case none
    case some(Wrapped)
}
var possibleInteger: OptionalValue<Int> = OptionalValue.none; // .none is the same
possibleInteger = OptionalValue.some(100) // Wraps Int 100; (.some(100)) is the same

// <T: Sequence> is the same as <T> ... where T: Equatable
func anyCommonElements<T: Sequence, U: Sequence>(_ lhs: T, _ rhs: U) -> Bool
    where T.Iterator.Element: Equatable, T.Iterator.Element == U.Iterator.Element {
    // where specifies requirements including implementing protocol for type and for the two (Sequence) types T and U to be the same.
        for lhsItem in lhs {
            for rhsItem in rhs {
                if lhsItem == rhsItem {
                    return true
                }
            }
        }
        return false
}
anyCommonElements([1, 2, 3], [3])

var array = [Int]() // creates a int array
// true since element Item (3) is in both
print(anyCommonElements([1, 2, 3], [3]))
// false since no Item element is the same in ether Item arrays
print(anyCommonElements([1, 2, 3], [4, 5, 6]))

