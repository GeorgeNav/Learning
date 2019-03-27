import UIKit

// Defined class
class Vehicle {
    var tires = 4
    var headlights = 2
    var horsepower = 468
    var model = ""
    
    /* accelerates the vehicle */
    func drive() { }
    /* stops the vehicle */
    func brake() { }
}

let bmw = Vehicle() // Creates instance
bmw.model = "328i"

let ford = Vehicle() // Creates instance
ford.model = "F150"
ford.brake()

func someFunction(vehicle: Vehicle) {
    vehicle.model = "Cheese"
}
print(ford.model)
someFunction(vehicle: ford) // Passed by reference
print(ford.model)

var someonesAge = 20
func passByValue(age: Int) {
    age = 10
}
passByValue(age: someonesAge) // Passes someonesAge value but does not change it
