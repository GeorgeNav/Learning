//This program illustrates the use of logical operators
//George Navarro

#include <iostream>

using namespace std;

int main()
{
	char employmentStatus;
	float performanceScore, salaryRaise;

	cout << "What's your employment status?" << "\n";
	cout << "Enter 1 (full-time), 2 (part-time), or 3 (temporary)" << "\n\n";
	cin >> employmentStatus;

	cout << "Now enter your performance score" << "\n";
	cin >> performanceScore;

	if (performanceScore >= 8.0 && employmentStatus == '1')
		salaryRaise = 1000.0;

	else if (employmentStatus != '1'|| performanceScore >= 6.0)
		salaryRaise = 150.0;

	else if (employmentStatus == '3')
		salaryRaise = 0;

	cout << "Your salary raise is: $" << salaryRaise << "\n";

	system("pause");
	return 0;
}