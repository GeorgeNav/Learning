// This program will output Total sales for each individual style of chair given
//George Navarro

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
	int quant1, quant2, quant3;
	float price1, price2, price3;		
	float totalValue1, totalValue2, totalValue3, totalValue4;
	string chair1, chair2, chair3;

	std::cout<<std::fixed;
	std::cout<<std::setprecision(2);

	chair1 = "American Colonial";
	chair2 = "Modern";
	chair3 = "French Classical";

	price1 = 85.00;
	price2 = 57.50;
	price3 = 127.75;

	cout << "Please input the number of " << chair1 << " chairs sold" << "\n";
	cin >> quant1;
	cout << "Please input the number of " << chair2 << " chairs sold" << "\n";
	cin >> quant2;
	cout << "Please input the number of " << chair3 << " chairs sold" << "\n";
	cin >> quant3;

	totalValue1 = price1 * quant1;
	totalValue2 = price2 * quant2;
	totalValue3 = price3 * quant3;
	totalValue4 = totalValue1 + totalValue2 + totalValue3;

	cout << "The total sales of " << chair1 << " chairs: $" << totalValue1 << "\n";
	cout << "The total sales of " << chair2 << " chairs: $" << totalValue2 << "\n";
	cout << "The total sales of " << chair3 << " chairs: $" << totalValue3 << "\n";	
	cout << "The total sales of all chairs: $" << totalValue4 << "\n";
	system("pause");
	return 0;
}