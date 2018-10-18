// Calculate rainfall average

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
	string month1, month2, month3;
	double rain1, rain2, rain3, totalRain;

	cout << "Enter month: ";
	cin >> month1;
	cout << "Enter rainfall for " << month1 << ": ";
	cin >> rain1;
	
	totalRain = rain1;

	cout << "Enter month: ";
	cin >> month2;
	cout << "Enter rainfall for " << month2 << ": ";
	cin >> rain2;

	totalRain *= rain2;

	cout << "Enter month: ";
	cin >> month3;
	cout << "Enter rainfall for " << month3 << ": ";
	cin >> rain3;

	totalRain *= rain3;
	totalRain /= 3;

	cout << "The average rainfall for ";
	cout << month1 << ", " << month2 << ", and " << month3 << " ";
	cout << "is " << totalRain<< " inches." << "\n";
	system("pause");
	return 0;
}