#include <iostream>
using namespace std;

int main()
{
unsigned int number, loopValue, total;

loopValue = 0;
total = 1;
number = -1;

cout << "This program will calculate the factorial of the number entered" << "\n";
system("pause");

while ( number >= 0 )

	{
		cout << "Enter a number greater than or equal to 0 to stop at: " << "\n";
		cin >> number;
	}

while ( loopValue == number )

	{
		loopValue += 1;
		total = loopValue * total;
	}

cout << "Here is the total: " << total;
return 0;
}