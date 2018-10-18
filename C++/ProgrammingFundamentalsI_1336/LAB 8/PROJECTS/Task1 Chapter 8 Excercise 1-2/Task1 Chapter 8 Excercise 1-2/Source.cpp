// This program performs a linear search on a character array
// Place Your Name Here

#include <iostream>
using namespace std;

int searchList( char[], int, char ); // function prototype 
const int SIZE = 8;

int main()
{
    char word[SIZE] = "Harpoon";
    int found;
    char ch;
    cout << "Enter a letter to search for:" << endl;
    cin >> ch;

    found = searchList( word, SIZE, ch );

    if (found == -1)
        cout << "The letter " << ch << " was not found in the list" << endl;
    else
        cout << "The letter " << ch <<" is in the " << ( found + 1 ) << " position of the list" << endl;

    system("pause");

    return 0;
}

int searchList( char word[], int SIZE, char ch )
{
    for ( int count = 0; count < SIZE; ++count )
	    if ( word[count] == ch )
        {
            cout << "Character " << "\"" << ch << "\" " << "was found." << "\n";
            system ("pause");

            return count;
        }
        else
        {
            cout << "Character " << "\"" << ch << "\" " << "was not found." << "\n";
            system ("pause");
            return -1;
        }
}