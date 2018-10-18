#include <iostream>

using namespace std;
int main()
{
	int hoursWorked
	;double hourlyPayRate;
	double wage;
	

	cout << "Program to compute employee wage given the hourly pay rate and the numbr of hours worked"<<endl<<endl;

	// Prompt user to enter input
	cout << "Enter the number of hours worked: ";
	cin >> hoursWorked;
	cout << "Enter the hourly pay rate: ";
	cin >> hourlyPayRate;

	// Calculate wage
	wage = hoursWorked * hourlyPayRate;

	// Output result
	cout <<"The wage is: "<< wage<<endl;

	cin.get(); cin.get();

	return 0;
}