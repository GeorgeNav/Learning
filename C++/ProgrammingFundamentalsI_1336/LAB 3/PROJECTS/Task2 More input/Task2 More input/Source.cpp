// Calculates total price of items based on the $ amount and quantity

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
	string description;

	cout << "What is the name of your product in one Word?: " << "\n";
	cin >> description;

	float price;		// price of each item
	int quantity;		// number of items purchaced
	float totalPrice;	// total price of all items

	cout << "Enter the price of an item" << "\n" << "$";
	cin >> price;
	cout << "Enter the quantity" << "\n";
	cin >> quantity;
	cout << "\n\n\n";
	
	totalPrice = price * quantity;
	
	cout << "EverythingForSale.com" << "\n";
	cout << "Purchase receipt" << "\n";
	cout << "\t" << "Product description: " << "\t" << description << "\n";
	cout << "\t" << "Unit price: " << "\t\t$" << price << "\n";
	cout << "\t" << "Quantity: " << "\t\t" << quantity << "\n";
	cout << "\t" << "Total: " << "\t\t\t$" << totalPrice << "\n";
	system("pause");
	return 0;
}