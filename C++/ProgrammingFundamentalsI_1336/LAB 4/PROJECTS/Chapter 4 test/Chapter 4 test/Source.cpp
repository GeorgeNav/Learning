#include <iostream>
#include <string>
using namespace std;

int main()
{
string customerStatus;
bool isPremiumCustomer;
int freeBooks, nbooksPurchased;

cout << "Enter 1 if Premium customer, 0 for normal: ";
cin >> isPremiumCustomer;
cout << "Enter number of books purchased: ";
cin >> nbooksPurchased;

if		(( isPremiumCustomer == 1 ) && ( nbooksPurchased >= 8 ))
		{
		freeBooks = 2;
		customerStatus = "Premium";
		}
if		(( isPremiumCustomer == 1 ) && ( nbooksPurchased < 8 ) && ( nbooksPurchased >= 5 ))
		{
		freeBooks = 1;
		customerStatus = "Premium";
		}
if		(( isPremiumCustomer == 0 ) && ( nbooksPurchased >= 12 ))
		{
		freeBooks = 2;
		customerStatus = "Normal";
		}
if		(( isPremiumCustomer == 0 ) && ( nbooksPurchased < 12 ) && ( nbooksPurchased >= 7 ))
		{
		freeBooks = 1;
		customerStatus = "Normal";
		}

	cout << "Number of books purchased: " << nbooksPurchased << "\n";
	cout << "Number of free books: " << freeBooks << "\n";
	cout << "Member status: " << customerStatus << "\n";
	system("pause");
	return 0;
}