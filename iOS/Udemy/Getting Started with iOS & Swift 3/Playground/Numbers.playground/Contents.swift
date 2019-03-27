import UIKit

// Numbers
var age = 30 // Integer (Type inference)
var weight: Int = 200 // Integer (Explicitly declared)

var milesRan = 56.45 // Double (default to double since decimals are present)
var pi: Float = 3.14 // Float
/* pi = milesRan */ // Cannot assign a double to a float variable

// Arithmetic Operators + - / *
var area = 15 * 20
var sum = 5 + 6
var diff = 10 - 3
var div1 = 12 / 3
var div2 = 13 / 5 // Only uses whole number; 2 not 2.6
var div3 = 13 % 5 // The remainer after dividing = [13 - (5 * div2)]; div2 = 2 (as shown on the above line)

var result = "\(div1), \(div2), \(div3)"
