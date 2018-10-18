// Calculates total price of items based on the $ amount and quantity

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
	string description;
	cout << "What is the name of your product in three words or less?: " << "\n";
	getline(cin, description);

	std::cout<<std::fixed;
	std::cout<<std::setprecision(2);

	float price;		// price of each item
	int quantity;		// number of items purchaced
	float totalPrice;	// total price of all items

	cout << "Enter the price of an item" << "\n" << "$";
	cin  >> price;
	cout << "Enter the quantity" << "\n";
	cin  >> quantity;
	cout << "\n\n\n";
	
	totalPrice = price * quantity;
	
	cout << "EverythingForSale.com" << "\n";
	cout << "Purchase receipt" << "\n";
	cout << "\t" << "Description" << "\t\t" << "Quantity" << "\t" << "Unit Price" << "\t" << "Total Price" << "\n";
	cout << "\t" << description;
	cout << "\t" << quantity << "\t\t" << price << "\t\t" << totalPrice << "\n\n";
	system("pause");
	return 0;
}