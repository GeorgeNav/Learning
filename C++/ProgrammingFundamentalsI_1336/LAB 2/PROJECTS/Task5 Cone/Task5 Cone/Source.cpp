// This program will output the surface area and volume
// of a cone with a given radius and height.

// George Navarro

#include <iostream>
using namespace std;

const double PI = 3.14159;

int main()
{

	double radius, height, surfaceArea, volume;

	// Program objective
	cout << "This program will compute the Surface Area and Volume \nof a Cone given the radius and height.\n\n";

	// User fills in radius
	cout << "Enter the radius of this rectangle: ";
	cin >> radius;

	// User fills in height
	cout << "Enter the height of this rectangle: ";
	cin >> height;

	// Calculate Surface Area and Volume
	surfaceArea = (radius + sqrt(height * height + radius * radius)) * PI * radius;
	volume = PI * radius * radius * (height/3);

	// Display Surface Area and Volume
	cout << "Surface Area = "<<surfaceArea<<"\n";
	cout << "Volume = "<<volume<<"\n";
		system("pause");

	return 0;
}