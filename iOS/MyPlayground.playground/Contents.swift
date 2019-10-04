class Bastard {
    func suck_it_up() {
        print("Bastard")
    }
}

class BlogPost : Bastard {
    var title = ""
    var body = ""
    var author = ""
    
    override init() {
        self.suck_it_up()
    }
}

BlogPost()

