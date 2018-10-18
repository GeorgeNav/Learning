/*	Program TwoDim manipulates a two-dimensional array variable.  */
#include <iostream>
#include <fstream>
using namespace std;
const int ROW_MAX = 8;
const int COL_MAX = 10;
typedef int ItemType;
typedef ItemType Table[ROW_MAX][COL_MAX];

/*	Reads values and stores them in the table.  */
void getData( ifstream&, Table, int&, int& );
/*	Write values in the table to a file.  */
void printTable( ofstream&, const Table, int, int );
/*	Computes largest Table data  */

/*
void largestData( ofstream&, const Table, int, int );
void smallestData( ofstream&, const Table, int, int );
void sumOfData( ofstream&, const Table, int, int );
*/

int main ()
{
Table table;
int largestValue, smallestValue, sumOfValues;
int rowsUsed;
int colsUsed;
ifstream dataIn;
ofstream dataOut;

	dataIn.open("twod.txt");
	dataOut.open("twod.out");

	dataIn >> rowsUsed;
	dataIn >> colsUsed;

	cout << "rows: " << rowsUsed << "\n";
	cout << "columns: " << colsUsed << "\n";
system("pause");

	getData( dataIn, table, rowsUsed, colsUsed );
	printTable( dataOut, table, rowsUsed, colsUsed );

/*
	largestValue = largestData( dataOut, table, rowsUsed, colsUsed );
	smallestValue = smallestData( dataOut, table, rowsUsed, colsUsed );
	sumOfValues = sumOfData( dataOut, table, rowsUsed, colsUsed );
*/

	dataIn.close();
	dataOut.close();

return 0;
}

/*	Reads values and stores them in the table.  */
void getData( ifstream& data, Table table, int& rowsUsed, int& colsUsed )
// Pre: rowsUsed and colsUsed are on the first line of
// file data; values are one row per line
// beginning with the second line.
// Post: Values have been read and stored in the table.
{
	for ( int rows = 0; rows < rowsUsed; rows++ )
		for ( int cols = 0; cols < colsUsed; cols++ )
			data >> table[rows][cols];

	for ( int rows = 0; rows < rowsUsed; rows++ )
	{
		for ( int cols = 0; cols < colsUsed; cols++ )
		{
			data >> table[rows][cols];
			cout << table[rows][cols] << " ";
		}
		cout << "\n";
	}
	cout << "These values have been saved to two-dimensional array, Table (Rows X Column)." << "\n";

system("pause");
}

/*	Write values in the table to a file.  */
void printTable( ofstream& data, const Table table, int rowsUsed, int colsUsed )
// Pre: table contains valid data.
// Post: Values in array table have been sent to a file by row,
// one row per line.
{
	if ( table )
	{
		for ( int rows = 0; rows < rowsUsed; rows++ )
			for ( int cols = 0; cols < colsUsed; cols++ )
				data << table[rows][cols];		
	}

	for ( int rows = 0; rows < rowsUsed; rows++ )
	{
		for ( int cols = 0; cols < colsUsed; cols++ )
		{
			cout << table[rows][cols] << " ";
		}
		cout << "\n";
	}

system("pause");
}

/*
int largestData( ofstream& data, const Table table, int rowsUsed, int colsUsed )
{
int largestValue = 0;

	for ( int rows = 0; rows < rowsUsed; rows++ )
		for ( int cols = 0; cols < colsUsed; cols++ )
			{
				if ( table[rows][cols] > largestValue )
					largestValue = table[rows][cols];
			}
cout << "Largest value saved: " << largestValue << "\n";
system("pause");

return largestValue;
}

int smallestData( ofstream& data, const Table table, int rowsUsed, int colsUsed )
{
int smallestValue = 100;

	for ( int rows = 0; rows < rowsUsed; rows++ )
		for ( int cols = 0; cols < colsUsed; cols++ )
			if ( table[rows][cols] > smallestValue )
				smallestValue = table[rows][cols];

cout << "Largest value saved: " << smallestValue << "\n";
system("pause");

return smallestValue;
}

int sumOfData( ofstream& data, const Table table, int rowsUsed, int colsUsed )
{
int sumOfValues = 0;

	for ( int rows = 0; rows < rowsUsed; rows++ )
		for ( int cols = 0; cols < colsUsed; cols++ )
				sumOfValues += table[rows][cols];

cout << "Sum of values: " << sumOfValues << "\n";
system("pause");
return sumOfValues;
}
*/