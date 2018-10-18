// Basic Arithmetic, type coercion, type casting, increment and decrement

#include <iostream>
using namespace std;

int main()
{
	cout << 2 + 3 * 5 << "\n";
	cout << (2 + 3) * 5 << "\n";
	cout << 3 * 7 - 6 + 2 * 5 / 4 + 6 << "\n";
	cout << 12.8 - 17.5 - 34.50 << "\n";
	cout << 12.8 - (17.5 - 34.50) << "\n";
	cout << 2 + 3.5 << "\n";
	cout << static_cast<int>(2 + 3.5) << "\n";
	cout << 17 / 3 << "\n";
	cout << 17.0 / 3 << "\n";
	cout << static_cast<float>(17) / 3 << "\n";
	cout << static_cast<float>(17 / 3) << "\n";
	cout << 17 % 3 << "\n";
	system("pause");

	int x = 5;
	x++;
	cout << x << "\n";

	x = 5;
	++x;
	cout << x << "\n";

	x = 5;
	cout << x++ << "\n";

	x = 5;
	cout << ++x << "\n";

	system("pause");
	return 0;
}