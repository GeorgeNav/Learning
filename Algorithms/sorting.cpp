// Sorting algorithms and the number of comparisons
#include <iostream>
#include <string>
#include <math.h>
using namespace std;

void SimpleSort(int*, int); // Sorts array using SimpleSort (pg.66)
void MergeSort(int*, int, int); // Sorts array using Mergesort (pg.72)
    void Merge(int*, int, int, int, int); // Merges two subarrays
void QuickSort(int*, int, int); // Sorts array using QuickSort (pg.73)
    int Partition(int*, int, int); // Returns a pivot index
    void ShiftLeft(int*, int, int); // Shift elements left

void Swap(int*, int, int); // Swaps elements in array
void PrintArr(int*, int, int); // Prints array

int comparisons = 0;

int main() {
    const int size = 8;
    int ASimpleSort[size] = {8,2,6,7,5,1,4,3};
    int AMergeSort[size] = {8,2,6,7,5,1,4,3};
    int AQuickSort[size] = {8,2,6,7,5,1,4,3};

    cout << endl << "Array before sort: ";
    PrintArr(ASimpleSort, 0, size);
    cout << endl << endl;

    SimpleSort(ASimpleSort, size);
    PrintArr(ASimpleSort, 0, size);
    cout << " -> SimpleSort comparisons: " << comparisons << endl;
    comparisons = 0;

    MergeSort(AMergeSort, 0, size-1);
    PrintArr(AMergeSort, 0, size);
    cout << " -> MergeSort comparisons: " << comparisons << endl;
    comparisons = 0;

    QuickSort(AQuickSort, 0, size-1);
    PrintArr(AQuickSort, 0, size);
    cout << " -> QuickSort comparisons: " << comparisons << endl;
    comparisons = 0;    
}

void SimpleSort(int S[], int n) {
    for(int i = 0; i < n; i++)
        for(int j = i + 1, temp; j < n; j++) {
            comparisons++;
            if(S[j] < S[i]) {
                // Exchange S[i] and S[j]
                temp = S[i];
                S[i] = S[j];
                S[j] = temp;
            }
        }
}

void MergeSort(int S[], int i, int j) {
    if (i < j) {
        int m = (i + j) / 2; // Middle of subarray
        MergeSort(S, i, m); // Sort left subarray
        MergeSort(S, m + 1, j); // Sort left subarray
        Merge(S, i, m, m + 1, j); // Merging two subarrays
    }
}
void Merge(int S[], int l1, int r1, int l2, int r2) {
    const int tempSize = r2+1; // Size needed for merge array
    int Temp[tempSize]; // Where the merged sorted subarry (l1,...r2) will be placed 
    int i = l1, j = l2, k = 0;

    while (i <= r1 && j <= r2) { // Compare elements from left and right subarrays (r2-1 comparisons)
        comparisons++;
        if (S[i] < S[j]) 
            Temp[k++] = S[i++]; // Next available element Temp set to S[i], increment i,k
        else
            Temp[k++] = S[j++]; // Next available element Temp set to S[j], increment j,k
    }
    while (i <= r1) // Copy remaining (if any) elements in left subarray over to Temp
        Temp[k++] = S[i++];
    while (j <= r2) // Copy remaining (if any) elements in right subarray over to Temp
        Temp[k++] = S[j++];
    for (i = l1, j = 0; i <= r2; i++, j++) // Copy array contents from Temp to subarray section (l1,...r2) of original array
        S[i] = Temp[j];
}

void QuickSort(int S[], int l, int r) {
    if(l != r) {
        int pivotPos = Partition(S, l, r);
        if((r-l) <= 1)
            return;
        /*cout << "  *QS( S[" << l << ",..." << pivotPos-1 << "] )" << endl;*/ 
        QuickSort(S, l, (pivotPos-1));
        /*cout << "  *QS( S[" << pivotPos+1 << ",..." << r << "] )" << endl;*/
        QuickSort(S, pivotPos+1, r);
    } // else array only has 1 element so no sorting needed
}
int Partition(int S[], int l, int r) {
    int pivot = S[l]; // Let y be the first element in S (y == S[0])
/*
    cout << "   P - pivotVal: " << pivot << ", l: " << l << ", r: " << r; cin.get();
    cout << "    Before partition: "; PrintArr(S, l, r+1); cout << endl;
*/
    int i = l;
    for(int j = l+1; j <= r; j++, comparisons++) // Swap elements around future pivot location
        if(S[j] < pivot && i != j) {
            S[i] = S[j];
            ShiftLeft(S,j,i);
            i++;
        }
    S[i] = pivot;
    /*cout << "    After partition:  "; PrintArr(S, l, r+1); cout << endl;*/
    return i;
}
void ShiftLeft(int S[], int start, int end) {
    for(int i = start; i-1 >= end; i--)
        Swap(S, i, i-1);
}

void Swap(int S[], int a, int b) {
    int temp = S[a];
    S[a] = S[b];
    S[b] = temp;
}

void PrintArr(int S[], int i, int n) {
    cout << "[";
    for(int i = 0; i < n; i++) {
        cout << S[i];
        if(i != n-1)
            cout << ", ";
    } cout << "]";
}
