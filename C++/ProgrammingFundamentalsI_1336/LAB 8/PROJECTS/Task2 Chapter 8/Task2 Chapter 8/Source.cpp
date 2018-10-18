// This program demonstrates a Binary Search
// PLACE YOUR NAME HERE

#include <iostream>
using namespace std;
int binarySearch( int [], int, int ); // function prototype 
int defineNumPos( int num[], bool position[], int SIZE, int number );
const int SIZE = 16;

int main()
{
	int lookups1, lookups2, number;
	int array[SIZE] = {34,19,19,18,17,13,12,12,12,11,9,5,3,2,2,0};  // array to be searched
	bool position[SIZE] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

	cout << "Enter an integer to search for:" << endl;
	cin >> number;

	lookups1 = binarySearch( array, SIZE, number );				// function call to perform the binary search
    lookups2 = defineNumPos( array, position, SIZE, number );	// on array looking for an occurrence of value 

	cout << "Number of Binary look ups: " << lookups1 << "\n";
	cout << "Number of Linear look ups: " << lookups2 << "\n";

	system ("pause");

	return 0;
}
//*******************************************************************
// binarySearch
//
// task: This searches an array for a particular value
// data in: List of values in an orderd array, the number of
// elements in the array, and the value searched for
// in the array
// data returned: Position in the array of the value or -1 if value
// not found
//
//******************************************************************
int binarySearch(int array[],int numElems,int value) //function heading
{
	int first = 0; // First element of list
	int last = numElems - 1; // last element of the list
	int middle; // variable containing the current middle value of the list
	int occurences = 0;

	while (first <= last)
	{
		middle = first + (last - first) / 2;
		if (array[middle] == value)
			return middle; // if value is in the middle, we are done
		else if (array[middle] < value)
			last = middle - 1;	// toss out the second half of the array 
								//and search the first
		else
			first = middle + 1; // toss out the first half of  the array 
		++occurences;			//and search the second
	}

	return occurences; // indicates that value is not in the array
}

int defineNumPos( int num[], bool position[], int SIZE, int number )
{
	int occurences = 0;

    for ( int count = 0; count < SIZE; ++count )
	{
		++occurences;
	    if ( num[count] == number )
		{
			position[count] = true;
        }
	}

    for ( int count = 0; count < SIZE; ++count )
	    if ( position[count] == true )
        {
			cout << "Number " << "\"" << num[count] << "\" " << "was found." << "\n\n";
            system ("pause");
			return occurences;
        }

    cout << "Number " << "\"" << number << "\" " << "was not found." << "\n";
    system ("pause");
    return occurences;
}