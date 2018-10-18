// This program displays course grade based on the average score
// using the standard grading formula:
// average ≥ 90  A; 80 ≤ average < 90  B; 70 ≤ average < 80  C ;
// 60 ≤ average < 70  D; average < 60  F
// George

#include <iostream>
using namespace std;

int main()
{
	float avgScore;		// holds the grade average 
	char grade;			// holds a letter grade

	cout << "Input your average:" << endl;
	cin >> avgScore;
	
	if (( avgScore >= 90 ) || ( avgScore <= 100 ))
			grade = 'A';
	if (( avgScore >= 80 ) || ( avgScore <= 100 )) 
			grade = 'B';
	if (( avgScore >= 70 ) || ( avgScore <= 100 )) 
			grade = 'C';
	if (( avgScore >= 60 ) || ( avgScore <= 100 )) 
			grade = 'D';
	else 
			grade = 'F';

	cout << "Your grade is: " << grade << endl; 
	system("pause"); 
	return 0;

}