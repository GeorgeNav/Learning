#include <stdio.h>

void max(int [], int);

int main(void) {
    int size = 5;
    int arr[size];
    arr[0] = 16;
    arr[1] = 50;
    arr[2] = 2;
    arr[3] = 23;
    arr[4] = 6;

    max(arr, size);

    return 0;
}

/* Get the maximum value (not index) from an array
Time Complexity (# of statements)
    Worse-case: 2n - 1 = (n - 1) + n
        comparisons: (n - 1)
        assignments: n = 1 + (n - 1)
    Best-case: n = (n - 1) + 1
        comparisons: (n - 1)
        assignments: 1 = 1 + 0
Space Complexity (additional space needed + input space)
    n + 2 units = input + tempMax + i units
        input: n units
        tempMax: 1 unit
        i: 1 unit
*/
void max(int arr[], int size) { // statement count: n = 1 + (n - 1)
    int tempMax = arr[0]; // assignments: 1
    for(int i = 1; i <  size; i++) // comparisons: (n - 1)
        if(tempMax < arr[i]) // assignments: 0 (best case) to n-1 (worst case)
            tempMax = arr[i];
    printf("%d\n",tempMax);
}