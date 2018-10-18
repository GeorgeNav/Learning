import UIKit

// Creates airports dictionary with type Int key and a type String value
var namesOfIntegers = [Int: String]() // Dictionary (Hash table)
namesOfIntegers[3] = "three" // Name of dictionary element at value 3
namesOfIntegers[44] = "forty four" // Name of dictionary element at value 44
namesOfIntegers = [:] // Clears dictionary

// Creates airports dictionary with type String key and a type String value
var airports: [String: String] = ["YYZ": "Toronto Pearson", "LAX": "Los Angeles International"]
print("The airports dictionary has: \(airports.count) items")

if(airports.isEmpty) {
    print("The airport dictionary is empty!")
}

airports["LHR"] = "London"
airports["LHR"] = "London (updated)" // Updated dictionary element
airports["DEV"] = "Devslope International"
airports["DEV"] = nil // Deletes dictionary element

// Topol: data type or data construct that has 2 or more elements types
for(key, val) in airports { // key and val are temporary variables for airport dictionary keys and values
    print("\(key): \(val)")
}
for key in airports.values {
    print("Key: \(key)")
}
for val in airports.values {
    print("Value: \(val)")
}
