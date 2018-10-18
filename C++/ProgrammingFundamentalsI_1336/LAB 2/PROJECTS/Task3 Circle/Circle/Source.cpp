// This program will output the circumference and area
// of the circle with a given radius.

// George Navarro

#include <iostream>
using namespace std;

const double PI = 3.14;

int main()
{

	double radius, circumfrence, area;

	// User fills in radius
	cout << "Enter the radius of this circle: ";
	cin << radius;

	// Calculate circumference
	circumfrence = 2 * PI * radius;

	// Fill in the code to output the circumference
	cout << "The circumfrence of a circle of radius "<<radius<<"ft is: "<<circumfrence<<"ft\n";
		system("pause");

	// Fill in the code to calculte area of circle
	area = PI * radius * radius;
	// Fill in the code to output  the area of the circle
	cout << "The area of a circle of radius "<<radius<<"ft is: "<<area<<"ft\n";
		system("pause");

	return 0;
}