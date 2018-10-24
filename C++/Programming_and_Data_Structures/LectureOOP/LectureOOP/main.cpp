//
//  main.cpp
//  LectureOOP
//
//  Created by George Navarro on 1/29/18.
//  Copyright © 2018 Navality. All rights reserved.
//

#include <iostream>
#include <ostream>
using namespace std;

class Account {
private: int pin;
    
    bool checkPin(int) {
        return true;
    }
};

class savingAccount {
    double interestRate;
    
    void computeInterest() {
        
    }
};

class rectangleType {
    
};

class clockType {
    // Prototype
    // operator = defines new overloaded action of the given operator
    friend ostream& operator << (ostream&, const rectangleType&);
    friend iostream& operator << (iostream&, const rectangleType&);
    
    void setTime(int hours, int minutes, int seconds);
    void getTime(int& hours, int& minutes, int& seconds) const;
    void incrementHours();
    bool equalTime(const clockType& otherClock) const;
    
private:
    int hr;
    int min;
    int sec;
};

int main(int argc, const char * argv[]) {
    rectangleType rec1, rec2;
    
    // Template function
    template rectangleType Type larger(Type rec1, Type rec2) {
        if (rec1>=rec2)
            return rec1;
        else
            return rec2;
    }
}
