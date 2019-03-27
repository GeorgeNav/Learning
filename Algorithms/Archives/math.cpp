// Example program
#include <iostream>
#include <string>
#include <math.h>
using namespace std;

int gcd(int, int); // Returns gcd for two integers
int MySqrt(int, int, int); // Returns sqrt of a number recursively
int FibonacciRecursive(int, int, int); // Fibonacci Sequence Recursively
int FibonacciDP(int, int, int); // Fibonacci Sequence with Dynamic Programming
void PrintArr(int*, int, int); // Prints array
int Maxsum(int*, int);
    int Max(int, int);
int M(int*, int);

int calcs = 0;

int main() {
    int a, b, c, n;
    int gcdVal;
    int mySqrtVal;
    const int size = 10;
    int S[size] = {1,-2,4,43,-30,60,-50,58,-200,20};

    cout << "Enter an a and b for gcd(a,b)" << endl;
    cout << "a: "; cin >> a;
    cout << "b: "; cin >> b;
    gcdVal = gcd(a, b);
    cout << "gcd(" << a << "," << b << ") = " << gcdVal << endl;

    cout << endl << "Enter a value c for MySqrt(c,1,c): ";
    cin >> c;
    mySqrtVal = MySqrt(c, 0, c);
    cout << "MySqrt(" << c << "): " << mySqrtVal << endl << endl;

    cout << endl << "Enter a value for a, b, and n where..." << endl << "a_2 = a + b    and..." << endl << "a_n = a_(n-1) + a_(n-2))" << endl;
    cout << "a: "; cin >> a;
    cout << "b: "; cin >> b;
    cout << "n: "; cin >> n;
    cout << "FibonacciRecursive(" << a << "," << b << "," << n << "): " << FibonacciRecursive(a,b,n) << " -> calculations: " << calcs << endl; calcs = 0;
    cout << "FibonacciDP(" << a << "," << b << "," << n << ")..." << endl;
    cout << FibonacciDP(a,b,n) << " -> calculations: " << calcs  << endl; calcs = 0;

    cout << endl << "Maxsum: " << Maxsum(S,size) << endl;
    cout << "MaxsumRecursion: " << Maxsum(S, size);

    cout << endl;
}

int gcd(int a, int b) {
    /*cout << "  a: " << a << ", b: " << b << endl;*/
    if(b == 0) {
        /*cout << "    Reached base case. Now that b is " << b << " return a (" << a << ") as the GCD" << endl;*/
        return a;
    }
    return gcd(b, a%b);
}
/* FIXME: does not work for input of 1 */
int MySqrt(int n, int a, int b) { // MySqrt(n, 0, n)
    int mid;
    mid = floor( (a+b)/2 );
    cout << "  a: " << a << ", b: " << b << endl;
    if(mid*mid <= n) {
        if((mid+1)*(mid+1) > n)
            return mid;
        else
            return MySqrt(n, mid, b);
    }
    return MySqrt(n,a,mid);
}

/* Fibonacci Sequence Recursively
a_n = a_(n-1)+a_(n-2)

rFibNum(2,3,4) = 13 .. .  .
a2 = a1 + a0 = 3 + 2
a3 = a2 + a1 = 5 + 3
a4 = a3 + a2 = 8 + 5
   = 13
*/
int FibonacciRecursive(int a, int b, int n) { // TODO: find O(f(n)) recursive fibonacci
    if(n == 0)
        return a;
    else if(n == 1)
        return b;
    calcs++;
    return FibonacciRecursive(a,b,n-1) + FibonacciRecursive(a,b,n-2);
}

int FibonacciDP(int a, int b, int n) { // O(n) calculations
    const int size = n + 1;
    int* table = new int[size];
    for(int i = 0; i < size; i++, PrintArr(table, 0, size), cout << endl) {
        if(i == 0)
            table[i] = a;
        else if(i == 1)
            table[i] = b;
        else {
            calcs++;
            table[i] = table[i - 2] + table[i - 1];
        }
    }
    return table[n];
}

// Maxsum subarrays: since there has to be two indices such that A[i,...j], then Choose(2,n) different ways where 1 <= i <= j <= n 
//   subproblems (2n or O(n) because of Max(Mini and Mouti)): Min[i] = (sum of A[1,...i], sum of A[1,...i-1] from array A[1,...i])
/*int Maxsum(int S[], int size) {
    int Mouti = INT_MIN, Mini = 0;
    cout << "Array is "; PrintArr(S,0,size); cout << endl;
    for(int i = 0; i < size; i++) {
        Mini += S[i];
        cout << "Mouti: " << Mouti << ", Mini: " << Mini << endl;
        if(Mouti < Mini)// Compare sum of a[0,...(i-1)] elements to a[0,...i] elements and if sum is less a[0,...(i-1)] then... 
            Mouti = Mini;
        if(Mini < 0)
            Mini = 0;
        cout << "    Mouti: " << Mouti << ", Mini: " << Mini << endl;
    } cout << endl;
    return Mouti;
}*/
int Maxsum(int S[], int n) {
        int solution[n+1];
        int result;

        solution[0] = 0;
        result = solution[0];
        cout << "Original array: "; PrintArr(S, 0, (n)); cout << endl;

        for (int i = 1; i < (n+1); i++) {
            solution[i] = Max(solution[i-1]+S[i-1],S[i-1]);
            if(result < solution[i])
                result = solution[i];
        }

        cout << endl << "Solution array: "; PrintArr(solution, 0, (n+1)); cout << endl;
        return result;
    }
int Max(int a, int b) {
    if(a > b)
        return a;
    return b;
}

/*
int M_in(int S[], int i) {
    if(i == 0)
        return S[0];
    else
        return Max(M_in(i-1) + S[i], S[i]);
}
int M_out(int S[], int i) {
    if(i == 0)
        return S[0];
    else
        return M
}
int M(int S[], int i) {

}
*/

void PrintArr(int S[], int i, int n) {
    cout << "[";
    for(int i = 0; i < n; i++) {
        cout << S[i];
        if(i != n-1)
            cout << ", ";
    } cout << "]";
}
