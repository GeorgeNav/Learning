import UIKit

var firstName = "Jack" // Type inference
var lastName = "Bauer" // Type inference
var age = 45
var fullName = firstName + " " + lastName
var fullName2 = "\(firstName) \(lastName) is \(age)" // String interpolation
fullName.append(" III")

var bookTitle = "revent of the crab cakes"
bookTitle = bookTitle.capitalized

var chatroomAnnoyingCapsGuy = "PLEASE HELP ME NOW! HERE IS MY 100 LINES OF CODE"
var lowercasedChat = chatroomAnnoyingCapsGuy.lowercased()

// Oh My Heck, Fetch
var sentence = "what the fetch?! Heck that is crazy!"
if sentence.contains("fetch") || sentence.contains("Heck") {
    sentence.replacingOccurrences(of: "fetch", with: "tuna")
    sentence.replacingOccurrences(of: "Heck", with: "Playa")
}
