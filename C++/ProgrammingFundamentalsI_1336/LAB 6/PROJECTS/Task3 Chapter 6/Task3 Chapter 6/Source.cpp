#include <iostream>
#include <iomanip>

using namespace std;

void getData( int& , float& );

int main()
{
	int hoursWorked = 0;
	float payRate = 0, wage = 0;

	cout << fixed << showpoint << setprecision(2);

	getData( hoursWorked, payRate );

	wage = ( hoursWorked * payRate );
	
	cout<< "\n" << setw(10) << hoursWorked
				<< setw(10) << payRate
				<< setw(10) << wage << "\n\n";

	system("pause");
	return 0;
}

void getData( int& h, float& r )
{
	cout << "Enter the amount of hours worked this week: ";
	cin >> h;
	cout << "Enter the Hourly Rate: ";
	cin >> r;

	system("pause");
}