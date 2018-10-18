#include <iostream>
using namespace std;

int main()	
{
	int value1, remainder;

	for ( value1 = 2; value1 <= 200; value1++ )
		{
		remainder = value1 % 2;
		if ( remainder == 0 )
			cout << value1 << " ";
	
		remainder = value1 % 3;
		if ( remainder == 0 )
			cout << value1 << " ";
		}
	system("pause");
	return 0;
}