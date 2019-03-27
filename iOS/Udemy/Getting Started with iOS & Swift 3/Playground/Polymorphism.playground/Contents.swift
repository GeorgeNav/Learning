import UIKit

class Shape {
    var area: Double?
    
    func calculateArea(valA: Double, valB: Double) {
        
    }
}
// Polymorphic class
class Triangle: Shape {
    override func calculateArea(valA: Double, valB: Double) {
        area = (valA * valB) / 2
    }
}
// Polymorphic class
class Rectangle: Shape {
    override func calculateArea(valA: Double, valB: Double) {
        area = valA * valB
    }
}
