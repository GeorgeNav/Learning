import UIKit

/* Excersize arrays */
var array = [String]() // 1
var explicitArray: [Double] = [0,2,4,6] // 2
var fiveArray = [1, 2.0, 20, 50] // 3

// 4
for index in 1...5 {
    array.append("Hello")
    explicitArray.append(2.0)
    fiveArray.append(1)
}
print(array)
print(explicitArray)
print(fiveArray)

// 5
array.remove(at: 0)
explicitArray.remove(at: 0)
fiveArray.remove(at: 0)

array.removeAll() // 6
var typeArray = [3, "Swift", 2.0] as [Any] // 7

/* Exercise loops */
var oddNumbers = [Int]() // 1

// 2
for index in 0...100 {
    if(index%2 != 0) {
        oddNumbers.append(index)
    }
}
print(oddNumbers)

var sums = [Int]() // 3
// 4
for index in oddNumbers {
    sums.append(index+5)
}
print(sums)

// 5
for index in 0...(sums.count-1) {
    print("The sum for element \(index) is: \(sums[index])")
}
