import UIKit

var arrayOne = [String]()
arrayOne = ["a","b","c"]
var arrayTwo = [String]()
arrayTwo = ["bo","ro","me"]
var combinedArray = [String]()

for index in 0...(arrayOne.count-1) {
    combinedArray.append(arrayOne[index])
    combinedArray.append(arrayTwo[index])
}
print(combinedArray)
