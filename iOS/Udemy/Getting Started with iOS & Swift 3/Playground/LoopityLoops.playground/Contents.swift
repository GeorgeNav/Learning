import UIKit

var salaries = [45000.00, 100000.00, 54000.00, 20000.00]
var index: Int = 0

// Repeat while loop
repeat {
    salaries[index] = salaries[index] + (salaries[index] * 0.10) // Gives employee 'index' a 10% raise
    index += 1
} while (index < salaries.count)
print(salaries)

// For in loop with a range
for index in 0...4 {
    print("Index: \(index)")
}

// For in loop with a range using variable
for index in 0..<salaries.count {
    print("Index using salary count: \(index)")
}

// For in loop for and array
for index in salaries {
    print("Salary using array loop: \(index)")
}
