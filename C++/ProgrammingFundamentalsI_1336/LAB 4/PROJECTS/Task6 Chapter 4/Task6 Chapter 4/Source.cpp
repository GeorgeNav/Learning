// This program finds the largest of three test scores and
// displays it.
// George Navarro

#include <iostream>
using namespace std;

int main()
{
float testScore1, testScore2, testScore3;

cout <<"Enter score for test 1: " << "\n";
cin >> testScore1;

cout << "Enter score for test 2: " << "\n";
cin >> testScore2;

cout <<"Enter score for test 3: " << "\n";
cin >> testScore3;

	if (testScore1 > testScore2 && testScore1 > testScore3)
		cout << "Test score 1 is the largest" << "\n";

	else if ( testScore2 > testScore1 && testScore2 > testScore3 )
		cout << "Test score 2 is the largest" << "\n";

	else if ( testScore3 > testScore1 && testScore3 > testScore2 )
		cout << "Test score 3 is the largest" << "\n";

	else if ( testScore3 == testScore1 && testScore1 == testScore2 )
		cout << "All test scores are equal" << "\n";

system("pause");
return 0; 
}