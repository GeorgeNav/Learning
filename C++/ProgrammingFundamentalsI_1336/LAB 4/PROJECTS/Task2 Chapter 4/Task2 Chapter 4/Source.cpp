// This program displays course grade based on the average score
// using the standard grading formula:
// average ≥ 90  A;  80 ≤ average < 90  B;  70 ≤ average < 80  C ;
// 60 ≤ average < 70  D; average < 60   F
// George Navarro

#include <iostream>
using namespace std;

int main()
{
	float avgScore; // holds the grade average
	char grade;    // holds a letter grade  
	
	cout << "Input your average:" << endl;
	cin >> avgScore;   

	if ( avgScore >= 90 )
		grade ='A';
	else if ( avgScore >= 80 )
		grade = 'B';
	else if ( avgScore >= 70 )
		grade = 'C';
	else if ( avgScore >= 60 )
		grade = 'D';
	else if (( avgScore < 60 ) && ( avgScore >= 0 ))
		grade = 'F';

	cout << "Your grade is: " << grade << endl;
	system("pause");
	return 0;  
}  