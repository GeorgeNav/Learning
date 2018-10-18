#include <iostream>
using namespace std;

void displayStartBox( int, char );

int main()
{
	int number;
	char character;

	do
	{
		cout << "What character would you like to use?: ";
		cin >> character;

		cout << "\n" << "Enter the number of stars for the top; Enter 0 to quit: ";
		cin >> number;
		cout << "\n";

	} while ( number < 0 );

	while ( number > 0 )
	{
		displayStartBox( number, character );
		break;
	}

	system( "pause" );
	return 0;
}

void displayStartBox( int n, char x )
/*
(Documentation)
Task: Display a rectangle with a length and width of 11 stars
Data In: (* or $ or a) & (10 or 13)
Data Out: 11
Data Returned: Correct
*/
{
	int row, column;

	for ( row = ( n / 2 ); row > 0; row-- )
	{
		if ( row == ( n / 2 ) || row == 1 )
		{
			for ( column = 0; column < n; column++ )
			{
					cout << x;
			}
		}

		else
		{
			column = 0;

			if ( column == 0 )
			{
					cout << x;
			}

			do
			{
				cout << " ";
				column++;
			} while ( column >= 1 && column <= ( n - 3 ) );

			column = n;

			if ( column == n )
			{
				cout << x;
			}
		}

		cout << "\n";
	}

	cout << "\n";
}