#include <iostream>
#include <queue> // Added
#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <unistd.h>
using namespace std;

void display_details(string plate_number, char direction, int time) {
    if(direction == 'E')
        cout << "Current Direction:Eastbound";
    else if(direction == 'W')
        cout << "Current Direction:Westbound";
    else if(direction == 'N')
        cout << "Current Direction:Northbound";
    else if(direction == 'S')
        cout << "Current Direction:Southbound";

    cout << " Car " << plate_number << " is using the intersection for " << time << " sec(s) ";
}

struct Car {
    string plate;
    char dir;
    int wait;
    Car(string p, char d, int w) : plate(p), dir(d), wait(w) {}
};

int main() {
    pid_t pid;
    string line;
    queue<Car> north;
    queue<Car> east;
    queue<Car> south;
    queue<Car> west;
    char initial_direction;
    int max_cars;

    if(east == north)
        cout << "hello";

    south.empty();

    if(getline(cin, line))
        initial_direction = line[0];
    if(getline(cin, line))
        max_cars = atoi(line.c_str());
    string plate;
    char dir;
    int wait;
    while(getline(cin, line)) {
        int dirIndex = -1;
        for(int i = 0; i < line.length(); i++)
            if(line[i] == ' ') {
                dir = line[i+1];
                dirIndex = i+1;
                break;
            }

        if(dir == 'N') north.push(Car(line.substr(0,dirIndex-1), dir, atoi(line.substr(dirIndex+2,line.npos).c_str())));
        else if(dir == 'E') east.push(Car(line.substr(0,dirIndex-1), dir, atoi(line.substr(dirIndex+2,line.npos).c_str())));
        else if(dir == 'S') south.push(Car(line.substr(0,dirIndex-1), dir, atoi(line.substr(dirIndex+2,line.npos).c_str())));
        else if(dir == 'W') west.push(Car(line.substr(0,dirIndex-1), dir, atoi(line.substr(dirIndex+2,line.npos).c_str())));
    }

    // Put your code here

    return 0;
}
