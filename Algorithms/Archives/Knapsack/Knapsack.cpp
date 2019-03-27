// Example program
#include <iostream>
#include <string>
#include <math.h>
using namespace std;

int KnapsackDP(int*, int*, int*, int, int);
int Max(int, int);
void PrintArr(int*, int, int); // Prints array
void Print2DArr(int, int);

const int n = 4, M = 7;
// Array for subproblem solutions
//   Where K[i][j] is the maximum attainable value of items
//   in the Knapsack with i available items and capacity of
//   knapsack being j
int K[n+1][M+1];

int main() {
    int x[n] = {0,0,0,0};
    int w[n] = {1,3,4,5};
    int p[n] = {1,4,5,7};
    cout << "Solve Knapsack (DP) problem for..." << endl;
    // cout << "  x"; PrintArr(x, 0, size); cout << endl;
    cout << "  w"; PrintArr(w, 0, n); cout << endl;
    cout << "  p"; PrintArr(p, 0, n); cout << endl;
    KnapsackDP(x, w, p, n, M);
}

int KnapsackDP(int x[], int w[], int p[], int n, int M) {
    // This will fill up the solution matrix (bottom-up)
    for(int i = 0; i <= n; i++) 
        for(int j = 0; j <= M; j++) {
            // There is no item, so no value can be attained
            // or... The bag cannot hold anything, so no item cannot be placed in it
            if(i == 0 || j == 0)
                K[i][j] = 0;
            // Check if the weight of the current i item is less than or equal to the remaining capacity
            // If so, take the maximum of including and not including the item
            else if(w[i-1] <= j)
                K[i][j] = Max(K[i-1][j-w[i-1]] + p[i-1], K[i-1][j]);
            else // Cannot include the current item since the weight exceeds the current capacity
                K[i][j] = K[i-1][j];
        }
    Print2DArr(n+1, M+1);
    cout << "Optimal solution: " << K[n][M] << endl << "Items taken... ";
    int i = n, j = M;
    while(i >= 0 && j >= 0) {
        if(K[i][j] != K[i-1][j]) { // Include item if top amount is not the same
            x[i-1] = 1;
            j = j - w[i-1]; // Move on to next item that may be included
        }
        i--;
    }
    PrintArr(x,0,n); cout << endl;
    return K[n][M];
}

int Max(int a, int b) {
    if(a > b)
        return a;
    return b;
}

void PrintArr(int S[], int i, int n) {
    cout << "[";
    for(int i = 0; i < n; i++) {
        cout << S[i];
        if(i != n-1)
            cout << ", ";
    } cout << "]";
}

void Print2DArr(int r, int c) {
    for(int i = 0; i < r; i++) {
        cout << "| ";
        for(int j = 0; j < c; j++, cout << " ")
            cout << K[i][j];
        cout << "|" << endl;
    }
}