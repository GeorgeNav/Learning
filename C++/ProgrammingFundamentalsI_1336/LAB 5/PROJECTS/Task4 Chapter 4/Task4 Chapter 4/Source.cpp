#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	const int SENTINEL = -1;
	signed int count, dataItems;
	double dollars, total, average;
	
	ifstream inFile;
	inFile.open("Salesdata.txt");

	count = 0;
	dollars = 0;
	total = 0;
	average = 0;
	dataItems = 0;
	
	if ( inFile )
	{
		cout << "File works";
		do
			{
			inFile >> dollars;

			if ( dollars != -1 )
				{
					total += dollars;
					dataItems++;
				}

			}while ( inFile >> dollars && dollars != SENTINEL ); // SENTINEL: }while ( dollars != SENTINEL );
	}

	average = total / dataItems;

	cout << "Total amount: " << total << "\n";
	cout << "Average: " << average << "\n";
	system("pause");
	return 0;
}