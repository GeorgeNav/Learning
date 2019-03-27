import UIKit

// Logical NOT operator - unary prefix operator
let allowedEntry = false // Constant

if(!allowedEntry) {
    print("ACCESSED DENIED")
}

let enteredDoorCode = true
let passedRetinaScan = false
let iAmTomCruise = true
if( (enteredDoorCode && passedRetinaScan) || iAmTomCruise) {
    print("Welcome")
} else {
    print("ACCESS DENIED AGAIN")
}

let hasDoorKey = false
let knowsOverridePassword = true

if(hasDoorKey || knowsOverridePassword) {
    print("Welcome")
} else {
    print("ACCESS DENIED")
}
