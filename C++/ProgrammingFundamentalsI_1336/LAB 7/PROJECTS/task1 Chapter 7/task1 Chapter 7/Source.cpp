// Program Reverse reads numbers into an array
// and prints them out in reverse order.
#include <iostream>
#include <fstream>

using namespace std;
const int MAX = 10;

int main ()
{
int numbers[MAX];
ifstream inData;
int value;
int index;

inData.open("reverse.txt");

for ( index = 0; index < MAX; index++ )
{
	// FILL IN Code to read value from file inData
	// and store it in array numbers at position indicated by variable index
	inData >> numbers[index];
}

for ( index = MAX - 1; index >= 0; index-- )
{
	// FILL IN Code to write numbers on the screen
	cout << numbers[index] << "\n";
}

system("pause");
return 0;
}