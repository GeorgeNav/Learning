#include <string>
#include <iostream>
#include "stack.cpp"

void towerOfHanoi(int, Stack&, int);
void threeDisks(int, Stack&, Stack&, Stack&);

int main() {
    int n;
    int disk;
    std::cout << "Enter the # of disks: ";
    std::cin >> n;
    disk = n;

    Stack start = Stack(n, "Start"); // Max amount of disks on one peg is n
    while(disk != 0) // Load starting stack
        start.push(disk--);

    towerOfHanoi(n, start, 3);

    return 0;
}

void towerOfHanoi(int n, Stack& start, int pegs) { // Chooses which algorithm to use based on # of pegs
    if(pegs == 3) { // Disks can move to any peg if smaller than top
        Stack A = Stack(n, "Aux"); // Max amount of disks on one peg is n
        Stack D = Stack(n, "Dest"); // Max amount of disks on one peg is n
        threeDisks(n, start, A, D); // 3 disks algorithm 
    }
}

void threeDisks(int n, Stack& S, Stack& A, Stack& D) {
    if(n == 1) {
        std::cout << S.getName() + " -> " + D.getName() + "\n";
        D.push(S.pop());
    } else {
        threeDisks(n-1, S, D, A);
        std::cout << S.getName() + " -> " + D.getName() + "\n";
        D.push(S.pop());
        threeDisks(n-1, A, S, D);
    }
}
