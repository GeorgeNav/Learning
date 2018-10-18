// Search algorithms
#include <iostream>
#include <string>
#include <math.h>
using namespace std;

int BinarySearch(int*, int, int, int, int); // Returns index of value being searched for (-1 if not found) 
int MaxSearch(int*, int, int); // Returns index of max value in the array
int main() {
    const int size = 10;
    int S[size] = {1,3,7,20,34,100,1232,5299,39982,50023};
    int input;

    cout << endl << "What value would like like to search for in array {1,3,7,20,34,100,1232,5299,39982,50023}?: ";
    cin >> input;
    cout << "  Array index where " << input << " is stored: " << BinarySearch(S, input, 0, size-1, size) << endl;

    cout << endl << "Searching for max in array {1,3,7,20,34,100,1232,5299,39982,50023}.. .  " << MaxSearch(S,0,size-1);
    cout << endl << endl;
}

int BinarySearch(int S[], int input, int l, int r, int size) { // MUST USE SORTED ARRAY
    int mid;
    if(l <= r) {
        mid = floor( (l + r)/2 );
        if(S[mid] == input)
            return mid;
        else if(S[mid] > input)
            return BinarySearch(S, input, l, mid-1, size);
        else if(S[mid] < input)
            return BinarySearch(S, input, mid+1, r, size);
    }
    return (-1); // Cannot find input value
}

int MaxSearch(int S[], int l, int r) {
    int mid;
    if(l == (r-1)) {
        if(S[l] > S[r])
            return l;
        else
            return r;
    }
    mid = floor( (l+r)/2 );
    if(S[mid] > S[l])
        return MaxSearch(S, mid, r);
    else
        return MaxSearch(S, l, mid);
}
