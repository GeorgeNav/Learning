//: The Swift Programming Language (Swift 4 beta): Welcome to Swift (pages 5 - 43)

import UIKit

    //==> Section: Strings and Characters <==//
// String: series of characters which are unicode-compliant that can be accessed in multiple ways
// Unicode-compliant: encodes independent Unicode characters and supports accessing them in various unicode representations
// String concatenation: combining two strings with <#+#> operator
// String mutability: changing to String's contents
// String interpolation: inserting constants, literals, and expressions into longer strings
//> Note: String type is bridged with Foundation's NSString class
//> Note: When you import Foundation, you can access NSString methods without casting
    //==> Section: String Literals <==//
let someString = "Some string literal value" // String literal: <#"Some string literal value"#>
//> Note: It just says later it will cover using special characters in a String
// Multiline String: spans several lines surrounded by """
// alows for single quotations instead of using <#\#> like you would a normal string
let quotation = """
The White Rabbit put on his spectacles. "Where shall I begin, please your Majesty? he asked.
"Begin at the beginning," the King said gravely, "and go till you come to the end; then stop."
Escaping the first quote \"""
Escaping all three quotes \"\"\"
"""
// Both methods of escaping quotes work the same and will display """
print(quotation)
let singleLineString = "These are the same."
var multilineString = """
These are the same.
"""
// This will add a new line to the start and end of multilineString
multilineString = """

This string starts with a line feed (\n).
It also ends with a line feed (\n).

"""

    //==> Section: Intializing an Empty String <==//
// Creating an empty String value
var emptyString = "" // empty String literal
var anotherEmptyString = String() // initializer syntax to initialize to an empty String literal like above
// Check if a string is empty:
if emptyString.isEmpty {
    print("Nothing to see here") // Prints "Nothing to see here"
}

    //==> Section: String Mutability <==//
// String mutability: a String that can be modified
var variableString = "Horse"
variableString += " and carriage" // Same as <#variableString + " and carriage" = "Horse and carriage"#>
let constantString = "Highlander"
/* constantString += " and another Highlander" // Will not compile since a constant cannot be changed */
//> Note: Swift's String mutation is difference since you do not choose between two classes on whether you can change a String or not

    //==> Section: Strings Are Value Types <==//
// When passed to a function/method, or when it is assigned to a constant or variable, it is COPIED instead
// This insures that a function or method owns it and is not shared (can be modified by something else)

    //==> Section: Working with characters <==//
// Access character array String elements by inerating using a <#for-in#> loop
for character in "Dog!🐶" {
    // prints each character in String on seperate lines
    print(character)
}
// Stand-alone Character constant or variable
let exclamationMark: Character = "!"
// Constructing Strings by passing characters into it's character arrray
let catCharacters: [Character] = ["C", "a", "t", "!", "🐱"]
let catString = String(catCharacters)
print(catString)

    //==> Section: Concatenating Strings and Characters <==//
// Concatenating Strings using <#+#>
let string1 = "hello"
let string2 = " there"
var welcome = string1 + string2
// Appending a String value to an existing variable
var instruction = "look over"
instruction += string2
// Appending a Character to String variable
welcome.append(Character("!"))
//> Note: A Characters variable can only contain a single Character so it cannot be appened

    //==> Seciton: String Interpolation <==//
// Constructs new String value from a mix of constants, variables, literals, and expressions inside literal
// Can be done with both single and multiline String literals using <#\()#>
let multiplier = 3
let message = "\(multiplier) times 2.5 is \(Double(multiplier) * 2.5)"
//> Note: inside the interpolated parentheses \() a backslash, carriage return, or line feed cannot be used

    //==> Section: Unicode <==//
// International standard for encoding, representing, and processing text in a standardized form
    //-> Subsection: Unicode Scalars <-//
// Unique 21-bit number for a character or modifier such as U+0061 has a name of LATIN SMALL LETTER A ("a")
//> Note: Unicode code point range = U+0000 to U+D7FF inclusive or U+E000 to U+10FFFF inclusive
//> Note: No surrogate pair code points which is U+D800 to U+DFFF
    //-> Subsection: Special Characters in String Literals <-//
// String literals can include:
// null character <#\0#>, backslash <#\\#>, horizontal tab <#\t#>, line feed <#\n#>, carriage return <#\r#>,
// double quote <#\"#>, and single quote <#\'#>
// Unicode scalar input: <#\u{n}#> where <#n#> is a 1-8 digit hexadecimal number that is a valid Unicode code point
print("\"Imagination is more important than knowledge\" - Einstein")
let dollarSign = "\u{24}" // <#$#>
let blackHeart = "\u{2665}" // <#♥#>
let sparklingHeart = "\u{1F496}" // <#💖#>
    //-> Subsection: Extended Grapheme Clusters <-//
// Swift's Character type represents: one or more Unicode scalars that produce a single human-readable Char
let eAcute: Character = "\u{E9}" // <#é#> without the need for extended grapheme clusters
let combinedEAcute: Character = "\u{65}\u{301}" // <#e#> then <#'#> equals Character <#é#>
let enclosedEAcute: Character = "\u{E9}\u{20DD}" // <#é#> then enclosed in <#"⃝#> equals <#é⃝#>
let precomposed: Character = "\u{D55C}" // <#한#>
let decomposed: Character = "\u{1112}\u{1161}\u{11AB}" // <#ᄒ#> then <#ᅡ#> then <#ᆫ#> which equals <#한#> Character
let regionalIndicatorForUS: Character = "\u{1F1FA}\u{1F1F8}" // <#🇺🇸#>

    //==> Section: Counting Characters <==//
// Use <#.count#> property of a String to access Int value for how many characters it contains:
let unusualMenagerie = "Koala 🐨, Snail 🐌, Penguin 🐧, Dromedary 🐪"
print("unusualMenagerie has \(unusualMenagerie.count) characters")
// <#emptyString = ""#> as previously declared above
print("emptyStringg has \(emptyString.count) characters")
// When extended grapheme clusters are combined with current characters the character amount stays the same
var word = "cafe" // <#word.count = 4#>
word += "\u{301}" // Now <#word = café#>; Last character was modified but count stays the same <#word.count = 4#>
//> Note: Different characters and representations of the same character both can require different amounts of memory to store
//> Note: To calculate how much memory is required, you must iterate through the string to find the extended grapheme cluster boundaries

//==> Section: Accessing and Modifying a String ON PAGE 108
