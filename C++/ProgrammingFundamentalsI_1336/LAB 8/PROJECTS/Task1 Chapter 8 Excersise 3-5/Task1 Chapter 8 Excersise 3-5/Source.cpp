// This program performs a linear search on a character array
// Place Your Name Here

#include <iostream>
using namespace std;

int defineNumPos( int[], bool[],int, int ); // function prototype 

int main()
{
	const int SIZE = 16;
	int num[SIZE] = {34,19,19,18,17,13,12,12,12,11,9,5,3,2,2,0};
	bool position[SIZE] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    int found;
    int number;

    cout << "Enter a number to search for:" << endl;
    cin >> number;

    found = defineNumPos( num, position, SIZE, number );

    if (found == -1)
        cout << "The number " << number << " was not found in the list" << endl;
    else
        cout << "The number " << number <<" is in position(s): " << "\n";
		for ( int count = 0; count < SIZE; ++count )
		{
			if ( position[count] == true )
				cout << ( count + 1 ) << "\n";
		}

	system("pause");
    return 0;
}

int defineNumPos( int num[], bool position[], int SIZE, int number )
{
    for ( int count = 0; count < SIZE; ++count )
	    if ( num[count] == number )
        {
			position[count] = true;
        }
     
    for ( int count = 0; count < SIZE; ++count )
	    if ( position[count] == true )
        {
			cout << "Number " << "\"" << num[count] << "\" " << "was found." << "\n\n";
            system ("pause");
			return 0;
        }

    cout << "Number " << "\"" << number << "\" " << "was not found." << "\n";
    system ("pause");
    return -1;
}