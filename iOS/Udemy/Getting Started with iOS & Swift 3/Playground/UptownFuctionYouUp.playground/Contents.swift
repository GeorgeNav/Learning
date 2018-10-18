import UIKit

/* function that calculates area of a rectangle with (length * width) that returns an Int variable */
func calculateArea(length: Int, width: Int) -> Int {
    return length * width
    
}

let shape1Area = calculateArea(length: 5, width: 4)
let shape2Area = calculateArea(length: 10, width: 20)

/* function that buys an item if you can afford it */
func purchaseItem(currentBalance: Double, itemPrice: Double) -> Double {
    if (itemPrice <= currentBalance) {
        print("Purchased item for: $\(itemPrice)")
        return currentBalance - itemPrice
    } else {
        print("You are broke. You should learn how to save money.")
        return currentBalance
    }
}

var bankAccountBalance = 500.00
var sigShoes = 350.00
var retroLunchBox = 40.00
bankAccountBalance = purchaseItem(currentBalance: &bankAccountBalance, itemPrice: sigShoes)
bankAccountBalance = purchaseItem(currentBalance: &bankAccountBalance, itemPrice: retroLunchBox)
