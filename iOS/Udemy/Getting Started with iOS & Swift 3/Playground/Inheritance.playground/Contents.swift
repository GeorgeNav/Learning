import UIKit

class Vehicle {
    var tires = 4
    var make: String?
    var model: String?
    var currentSpeed: Double = 0
    
    init() {
        print("I am the parent")
    }
    /* accelerates the vehicle */
    func drive(speedIncrease: Double) {
        currentSpeed += speedIncrease * 2
    }
    /* stops the vehicle */
    func brake() {
        
    }
}

// Inheritance
class SportsCar: Vehicle {
    override init() {
        super.init()
        print("I am the child")
        make = "BMW"
        model = "3 series"
    }
        
    override func drive(speedIncrease: Double) {
        currentSpeed += speedIncrease * 3
    }
}

let car = SportsCar()
// I am the parent
// I am the child

