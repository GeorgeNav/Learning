// This program uses a selection sort to arrange an array of integers in
// ascending order
//PLACE YOUR NAME HERE

#include <iostream>
using namespace std;

// function prototypes
void displayArray( int[], int );
void smallestToLargestSort( int [], int );
void largestToSmallestSort( int[], int );

const int SIZE = 5;

int main()
{
	int values[SIZE] = {9,2,0,11,5};

	cout << "The values before the smallest to largest sort is performed are:" << endl;
	displayArray(values,SIZE);

	smallestToLargestSort(values,SIZE);

	cout << "The values after the selection sort is performed are:" << endl;
	displayArray(values,SIZE);
system("pause");

	cout << "The values before the largest to smallest sort is performed are:" << endl;
	displayArray(values,SIZE);

	largestToSmallestSort(values,SIZE);

	cout << "The values after the selection sort is performed are:" << endl;
	displayArray(values,SIZE);
system("pause");
return 0;	
}

//******************************************************************
// displayArray
//
// task: to print the array
// data in: the array to be printed, the array size
// data out: none
//
//******************************************************************
void displayArray(int arr[], int elems) // function heading
{ // Displays array 

	for (int count = 0; count < elems; count++)
		cout << arr[count] << " ";

	cout <<endl;
	
}

//******************************************************************
// selectionSortArray
//
// task: to sort values of an array in ascending order
// data in: the array, the array size
// data out: the sorted array
//
//******************************************************************
void smallestToLargestSort(int arr[], int elems)
{
	int seek; // array position currently being put in order 
	int minCount; // location of smallest value found
	int minValue; // holds the smallest value found

	for ( seek = 0; seek < ( elems - 1 ); seek++ )	// outer loop performs the swap
													// and then increments seek
	{
		minCount = seek;
		minValue = arr[seek];
		for(int index = seek + 1; index < elems; index++)
		// inner loop searches through array starting at array[seek] searching
		// for the smallest value. When the value is found, the subscript is
		// stored in minCount. The value is stored in minValue.
		{
			if(arr[index] < minValue)
			{
				minValue = arr[index];
				minCount = index;
			}
		}
		// the following two statements exchange the value of the
		// element currently needing the smallest value found in the
		// pass(indicated by seek) with the smallest value found
		// (located in minValue)
		arr[minCount] = arr[seek];
		arr[seek] = minValue;
	}
}

void largestToSmallestSort(int arr[], int elems)
{
	int seek; // array position currently being put in order 
	int minCount; // location of smallest value found
	int maxValue; // holds the smallest value found

	for ( seek = 0; seek < ( elems - 1 ); seek++ )	// outer loop performs the swap
													// and then increments seek
	{
		minCount = seek;
		maxValue = arr[seek];
		for(int index = seek + 1; index < elems; index++)
		// inner loop searches through array starting at array[seek] searching
		// for the smallest value. When the value is found, the subscript is
		// stored in minCount. The value is stored in minValue.
		{
			if(arr[index] > maxValue)
			{
				maxValue = arr[index];
				minCount = index;
			}
		}
		// the following two statements exchange the value of the
		// element currently needing the smallest value found in the
		// pass(indicated by seek) with the smallest value found
		// (located in minValue)
		arr[minCount] = arr[seek];
		arr[seek] = maxValue;
	}
}
