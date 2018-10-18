// This program will input American money and convert it to foreign currency 
// George Navarro

#include <iostream> 
#include <iomanip> 
using namespace std;

float convertToYen( float&, float );
float convertToEuros( float&, float );

int main ()
{ 
	float dollars; float euros = 1;  float yens = 1;
	cout << fixed << showpoint << setprecision(2);
	cout << "Please input the amount of American Dollars you want converted " << "\n";
	cout << "to euros and yen" << "\n";
	cin >> dollars;

	convertToYen( yens, dollars );
	convertToEuros( euros, dollars );

	cout << "Yen amount: " << yens << "\n";
	cout << "Euro amount: " << euros << "\n";

	system( "pause" );
	return 0; 
}

float convertToYen( float& yens, float dollars )
{
	cout << "The function convertToYen was called with " << dollars <<" dollars" << "\n\n";
	yens = ( dollars * 123.16 );
	return yens;
}

float convertToEuros( float& euros, float dollars )
{
	cout << "The function convertToEuros was called with " << dollars << " dollars" << "\n\n";
	euros = ( dollars * 0.93 );
	return euros;
}