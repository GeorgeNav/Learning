import UIKit
// Declare and initilize Double array
var employeeSalaries: [Double] = [45000.00, 54000.00, 100000.00, 20000.00]

print(employeeSalaries.count) // 4
employeeSalaries.append(39000.34)
print(employeeSalaries.count) // 5
employeeSalaries.remove(at: 1)
print(employeeSalaries.count) // 4

var students = [String]() // Declare String array
print(students.count) // 0
students.append("John")
students.append("Berns")
students.append("Smith")
students.remove(at: 2)
print(students) // [John, Berns]
