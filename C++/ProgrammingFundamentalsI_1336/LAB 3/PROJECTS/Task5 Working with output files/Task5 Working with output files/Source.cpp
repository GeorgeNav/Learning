// This program will input the value of two sides of a right triangle and then
// determine the size of the hypotenuse
//George Navarro

#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

int main()
{
	float a, b;		// the smaller two sides of the triangle
	float hyp;		// the hypotenuse calculated by the program
	
	std::cout<<std::fixed;
	std::cout<<std::setprecision(2);

	cout << "Please input the value of the two sides" << "\n";
	cout << "Side \"a\": ";
	cin >> a;
	cout << "Side \"b\": ";
	cin >> b;
	
	hyp = sqrt((a * a) + (b * b));

	cout << "The sides of the right triangle are \"a\" = " << a << " and \"b\" = " << b << "\n";
	cout << "The hypotenuse is " << hyp << "\n";
	system("pause");
	return 0;
}