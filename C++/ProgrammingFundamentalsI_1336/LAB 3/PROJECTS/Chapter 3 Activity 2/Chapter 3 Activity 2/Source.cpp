// Calculate rainfall average

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
	int age;
	string person, city, college, profession, animal, petName;
	
	cout << "Enter name: ";
	getline (cin,person);
	
	cout << "Enter city: ";
	cin >> city;
	
	cout << "Enter age: ";
	cin >> age;
	
	cout << "Enter college: ";
	cin.ignore (100,'\n');
	getline (cin,college);
	
	cout << "Enter profession: ";
	cin >> profession;
	
	cout << "Enter animal: ";
	cin >> animal;
	
	cout << "Enter pet name: ";
	cin >> petName;

	cout << "\n\nThere once was a person named " << person << " who lived in " << city << ".\n";
	cout << "At the age of " << age << ", " << person << " went to college at " << college << ".\n";
	cout << person << " graduated and went to work as a " << profession << ".\n";
	cout << "Then, " << person << " adopted a(n) " << animal << " named " << petName << ".\n";
	cout << "They both lived happily ever after!\n";
	system("pause");
	return 0;
}