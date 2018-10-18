// This program illustrates the use of the switch statement for a menu driven interface. 
// PLACE YOUR NAME HERE 
#include <iostream> 
using namespace std; 

int main() 
{ 
	const double ADULT = 40.0, CHILD = 30.0, SENIOR = 15.0, FAMILY = 60.0; // Club membership monthly costs
	int months;		// length of membership
	int choice; 

	cout << "Please select one of the membership options below: " << endl; 
	cout << '\t'<< "1.  Adult Membership"<<endl;
	cout << '\t'<< "2.  Child Membership"<<endl;
	cout << '\t'<< "3.  Senior Citizen Membership"<<endl;
	cout << '\t'<< "4.  Family Membership"<<endl;
	cout << '\t'<< "5.  Quit the program"<<endl<<endl;
	cout << "Enter your choice: ";
	cin >> choice; 

	switch( choice ) // This is where the switch statement begins 
	{ 
		case 1: cout << "\n For how many months? "<< endl; 
				cin >> months;
				cout <<"Your total membership cost is: $"<< months * ADULT << endl;
				break;

		case 2: cout << "\n For how many months? "<< endl; 
				cin >> months;
				cout <<"Your total membership cost is: $"<< months * CHILD << endl;
				break;

		case 3: cout << "\n For how many months? "<< endl; 
				cin >> months;
				cout <<"Your total membership cost is: $"<< months * SENIOR << endl;
				break;

		case 4: cout << "\n For how many months? "<< endl; 
				cin >> months;
				cout <<"Your total membership cost is: $"<< months * FAMILY << endl;
				break;

		case 5: cout << "No membership was selected....";
				cout <<"Good bye!"<<endl;
				break;

		default: cout << "The valid choices are 1 though 4" << endl; 
				 cout <<"Run the program again and make a valid selection"<<endl;
	} 

	system("pause");
	return 0; 
}