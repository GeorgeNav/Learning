#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	const int SENTINEL = -1;
	signed int count, dataItems;
	double dollars, total, average;
	
	ifstream infile;
	infile.open("C:\GOOGLE DRIVE\SCHOOL\LONESTAR\PROGRAMMING FUNDAMENTALS I 1336\LABS\LAB 5\PROJECTS\Task2 and 3 Chapter 5\Salesdata.txt");

	count = 0;
	dollars = 0;
	total = 0;
	average = 0;
	dataItems = 0;

	do
		{
			cout << "What is the positive amount for this item: ";
			cin >> dataItems;
		}while  ( dataItems < 0 );

		cout << "\n";
		cout << "Enter -1 to finish..." << "\n";
	do
		{
			count += 1;
			cout << "What is the amount for this item #" << count << ": ";
			cin >> dollars;
			cout << "\n";

		if ( dollars != -1 )
			{
				total += dollars;
			}

		}while ( count != dataItems && dollars != SENTINEL ); // SENTINEL: }while ( dollars != SENTINEL );

	average = total / dataItems;

	cout << "Total amount: " << total << "\n";
	cout << "Average: " << average << "\n";
	system("pause");
	return 0;
}