// A crazy mixed up program

#include <iostream>
#include <string>
using namespace std;

int main() 
{

// Operator usees. Remainder (%)
	double eightFive = 5%2, sixSeven = 2, total;
	total = eightFive / sixSeven ;
		cout << total << "\n";
			system("pause");

// String variable declaration, "sizeof" usefullness, "auto" automatic data type choice per data
	float distance;
	double mass;
	short int hehe;
	sizeof mass, distance, hehe;
	auto matic = 'G';

	distance = 1.495979E11;
	mass = 1.989E30;
	hehe = 678;

		cout << distance << "\n" << mass << "\n";
			system("pause");

		cout << sizeof mass << "\n" << sizeof distance << "\n" << sizeof hehe << "\n" << sizeof matic << "\n";
		system("pause");

// String variable declaration
	string who;
	who = "My buddies";
		cout << "I Love " << who << "\n";
			system("pause");

// Character's variable declaration
	char middleName;
	middleName = 'G';
		cout << middleName << "\n";
			system("pause");

// Integer Literal Type. Does not require "LL" after interger Literal Numeric value
	long long int LLvalue;
	LLvalue = 9223372036854775807LL;
		cout << LLvalue << "\n";
			system("pause");

// Literal practice. Hello and World are in memory once both are declared
	char *my_string = "Hello";

	my_string = "World";
		cout << my_string;
			system("pause");

	my_string = "Hello";
		cout << my_string;
//		cin >> my_string;
		cout << my_string;
			system("pause");

// It's a mad, mad program
		cout << "Success\n";
		cout << "Success ";
		cout << "Success\n\n";
		cout << "Success\n";
		system("pause");

// escape sequence test
		cout << "In 1492 Columbus\n\n" << "\r" << "\n" << "sailed the ocean blue." << "\n";
			system("pause");

// signed vs unsigned integer test
	unsigned int pro;
	pro = -5;

		cout << pro << "\n";
			system("pause");

// character declaration test "a"
	char value;
	value = 97;

		cout << value << "\n";
			system("pause");

	return 0;
}