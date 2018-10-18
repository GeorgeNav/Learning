//: Playground - noun: a place where people can play

import UIKit

var lotteryWinnings: Int? // ? = this variable may or may not have a value

// Unrapping optional
if(lotteryWinnings != nil) { // this if statment is required
	print(lotteryWinnings!) // ! = unrapping an optional
}
// Best way to unrap optional
if let winnings = lotteryWinnings {
    print(winnings)
}

class Car {
    var model: String?
}

var vehicle: Car? // Object declaration of a class that might have a value later
// Unrap object variable
if let v = vehicle {
    if let m = v.model {
        print(m)
    }
} else {
    print("no values for vehicle object")
}

print(vehicle?.model) // prints if there is a value and doesn't if not
vehicle = Car() // creates a car object
vehicle?.model = "Bronco" // ? tells the compiler that the object might not have a value
// Best way to unrap object variable
if let v = vehicle, let m = v.model {
    print(m)
}

var cars: [Car]?
cars = [Car]() // Creates an array of car objects
if let carArr = cars, carArr.count > 0 { // Same as if let carArr = cars where carArr.count > 0
    // only execute if not nil and if more than 0 elements
} else {
    cars?.append(Car())
    print(cars?.count)
}

// Class variables without using constructors
class Person {
    var tempAge: Int! // Implicitly unwrapped optional: can be accessed with out failing if empty
    var age: Int { // Computed property
        if tempAge == nil {
            tempAge = 2
        }
        return tempAge
    }
    func setAge(newAge: Int) {
        self.tempAge = newAge
    }
}
var jack = Person()
print(jack.tempAge) // nil
print(jack.age) // 2
print(jack.tempAge) // 2

// Class variables using variables
class Dog {
    var species: String
    init(someSpecies: String) { // Constructer
        self.species = someSpecies
    }
}

var lab = Dog(someSpecies: "Black Lab")
print(lab.species)
