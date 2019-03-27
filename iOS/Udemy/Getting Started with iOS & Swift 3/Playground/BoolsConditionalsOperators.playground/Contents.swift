import UIKit

var amITheBestTeacherEver: Bool = true
amITheBestTeacherEver = false

if(true == false || true == true) { // if ether condition is true print "WTFish"
    print("WTFish")
}
//Both lines are the same
var hasDataFinishedDownloading: Bool = false
hasDataFinishedDownloading = (1 == 2)

// Equal to '=='
// Not equal to '!='
// Greater than '>'
// Greater than or equal to '>='
// Less than or equal to '<='
// Less than '<'

var title1 = "Hey There"
var title2 = "Hey There"

if(title1 != title2) { // Do both titles say different things? False
    print("Please check title. They aren't the same")
} else if(title2.characters.count > 10) { // Do the characters exceed 8? False
    print("find a new title for the book")
} else { // Were the if statments false? True
    print("Book title(s) are spelt correctly")
}
