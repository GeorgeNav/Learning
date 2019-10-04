// import UIKit // for iOS
// 8326641429
import AppKit // for MacOS

class Person {
    var name: String = ""
    var age: Int = 0

    init(n:String, a:Int) {
        self.name = n
        self.age = a
    }
}

var a = Person(n: "George", a: 27)
a.name
a.age

class BlogPost {
    var fullTitle:String {
        if title != nil && author != nil {
            return title! + " by " + author!.name
        }
        else if title != nil {
            return title!
        }
        return "No Title"
    }
    var title:String?
    var body = "hey"
    var author:Person?
    var numberOfComments:Int = 0
}

let post = BlogPost()

print(post.fullTitle)
post.title = "Hello There"
post.author = a
print(post.fullTitle)
post.title = "Greatings"
print(post.fullTitle)

var e: [String]
e = ["mouse", "dog"]
e.remove(at: 1)

var dic: Dictionary<String, Double> = [
    "pi": 3.14,
    "hehe": 42.0
]

for (key, value) in dic {
    print(key + ": " + "\(value)")
}

switch 5 {
    case 0...5: // Checks this condition
        print("Yup")
        fallthrough // Checks rest of conditions
    case 0...10:
        print("Yup")
    default:
        print("Nope")
}


