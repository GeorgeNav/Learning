// This program will output the area and perimeter
// of a rectangle with a given length and width.

// George Navarro

#include <iostream>
using namespace std;

int main()
{

	double length, width, area, perimeter;

	// Program objective
	cout << "This program will compute the area and perimeter \nof a rectangle given the length and width.\n\n";

	// User fills in length
	cout << "Enter the length of this rectangle: ";
	cin >> length;

	// User fills in width
	cout << "Enter the width of this rectangle: ";
	cin >> width;

	// Calculate area and perimeter
	area = length * width;
	perimeter = (length + width) * 2;

	// Display area and perimeter
	cout << "Area = "<<area<<"\n";
	cout << "Perimeter = "<<perimeter<<"\n";
		system("pause");

	return 0;
}