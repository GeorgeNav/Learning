// This program uses a selection sort to arrange an array of integers in
// ascending order
//PLACE YOUR NAME HERE

#include <iostream>
#include <string>
using namespace std;

// function prototypes
void displayArray( string[], int[], int );
void smallestToLargestSort( string[], int[], int );
void largestToSmallestSort( string[], int[], int );
void largestString( string[], int[], int );

const int SIZE = 5;

int main()
{
	int pos[] = {false, false, false, false, false}
	string values[SIZE] = {"Abby","Jessica","Tom","Victor","Zane"};

	cout << "The values before the smallest to largest sort is performed are:" << endl;
	displayArray(values,pos,SIZE);

	smallestToLargestSort(values,pos,SIZE);

	cout << "The values after the selection sort is performed are:" << endl;
	displayArray(values,pos,SIZE);
system("pause");

	cout << "The values before the largest to smallest sort is performed are:" << endl;
	displayArray(values,pos,SIZE);

	largestToSmallestSort(values,pos,SIZE);

	cout << "The values after the selection sort is performed are:" << endl;
	displayArray(values,pos,SIZE);
system("pause");
return 0;	
}