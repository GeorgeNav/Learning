// Classes and Data Structures
// Chapters skipped: Advanced File Operations
#include <iostream>
// For setprecision(numberOfDigits)
#include <iomanip>
#include <string>
using namespace std;

int main(int argc, const char * argv[]) {
    struct Month {
        int current = NULL;
    };
    // Declaring a struct and initializing all struct members of different types
    struct Time {
        int hour = 0;
        int minutes = 0;
        int seconds = 0;
        string ampm = NULL;
        Month month;
    };
    // Initializing struct members
    Time timeNow = {11,38,49,"am"}; // Accessing timeNow member using dot and member name
    Time sevenTimes[7] = {7,7,7,"pm"}; // Array of 7 structs of type Time
    sevenTimes[0].hour = 11; // Accessing array element 0 member using dot and member name
    sevenTimes[0].month.current = 12; // Initializing struct memeber inside a struct
    
    // Declaring an enum; similar to an array
    enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};
    Day workDay = MONDAY; // sets workDay to 0 since MONDAY is the 1st element
    workDay = static_cast<Day>(2); // sets workDay to WEDNESDAY since 2 is the 3rd element
    return 0;
}

class shape {
private:
    // private access by default
    // these can only be accessed by the same class's member FUNCTIONS
    double area;
    double perimeter;
// must specify public access
// private members can access these public members
public:
    // Constructor which initializes class's member variables
    shape() {
        area = 0.0;
        perimeter = 0.0;
    }
    void setArea(double a) {
        area = a;
    }
    void setPerimeter(double p) {
        perimeter = p;
    }
    double getArea() {
        return area;
    }
    double getPerimeter() {
        return perimeter;
    }
};

class rectangle: shape {
private:
    double length;
    double width;
public:
    rectangle() {
        length = 0.0;
        width = 0.0;
        shape::setArea(0.0);
        shape::setPerimeter(0.0);
    }
    // Deconstructor ??? gets called when object gets killed or goes out of scope ???
    ~rectangle() {
        cout << "Bye rectangle object" << endl;
    }
    void setLength(double l) {
        length = l;
        // Since area and perimeter are updated after length is updated then it's not stale
        setArea();
        setPerimeter();
    }
    void setWidth(double w) {
        width = w;
        // Since area and perimeter are updated after width is updated then it's not stale
        setArea();
        setPerimeter();
    }
    double setLength() {
        return length;
    }
    double setWidth() {
        return length;
    }
    // Mutator that Overrides function in shape since function signature setArea() did not change
    void setArea() {
        // area is stale data if it doesn't get updated when any of the variables change
        shape::setArea(length*width);
    }
    // Mutator Overrides function in shape since function signature setArea() did not change
    void setPerimeter() {
        shape::setPerimeter((2*length)+(2*width));
    }
    // ??? Accessor that cannot change any of the members inherited from shape ???
    double getArea() {
        return shape::getArea();
    }
    // ??? Accessor that cannot change any of the members inherited from shape ???
    double getPerimeter() {
        return shape::getPerimeter();
    }
};
