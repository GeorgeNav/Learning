#include <iostream>

using namespace std;
int main()
{
	double score1, score2, score3, average;
	int numberOfScores = 3;
	

	cout << "Program to computes average of trhee scores"<<endl<<endl;

	// Prompt user to enter input
	cout << "Enter score1: ";
	cin >> score1;
	cout << "Enter score2: ";
	cin >> score2;
	cout << "Enter score3: ";
	cin >> score3;

	// Calculate average
	average = (score1 + score2 + score3)/numberOfScores;

	// Output result
	cout <<"The average is: "<< average<<endl;

	cin.get(); cin.get();

	return 0;
}