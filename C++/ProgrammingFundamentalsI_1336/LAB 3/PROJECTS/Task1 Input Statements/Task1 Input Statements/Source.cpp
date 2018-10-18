// Calculates total price of items based on the $ amount and quantity

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	float price;		// price of each item
	int quantity;		// number of items purchaced
	float totalPrice;	// total price of all items

	cout << "Enter the price of an item" << "\n";
	// Write an input statement to read value entered by user and
	// store it in variable price.
	cin >> price;

	// Propt user to enter the quantity
	cout << "Enter the quantity" << "\n";
	
	// Write statement to read input for the quantity
	cin >> quantity;
	
	// Write a statement to calculate the total price and assign it to totalPrice.
	totalPrice = price * quantity;
	
	// Write an output statement to display the output with proper label e.g, 
	// Total Price is: $1762.34 return 0;
	cout << "Total Price is: $" << totalPrice << "\n";
	system("pause");
	return 0;
}