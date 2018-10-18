// Calculate rainfall average

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
	int nAge;
	string nPerson, nCity, nCollege, nProfession, nAnimal, nPetName;

	cout << "Enter name: ";
	getline (cin, nPerson);
	cout << "Enter city: ";
	getline (cin, nCity);
	cout << "Enter age: ";
	cin >> nAge;
	cout << "Enter college: ";
	getline (cin, nCollege);
	cout << "Enter profession: ";
	getline (cin, nProfession);
	cout << "Enter animal: ";
	getline (cin, nAnimal);;
	cout << "Enter pet name: ";
	getline (cin, nPetName);

	cout << "There once was a person named " << nPerson << " who lived in " << nCity << ".\n";
	cout << "At the age of " << nAge << ", " << nPerson << " went to college at " << nCollege << ".\n";
	cout << nPerson << " graduated and went to work as a " << nProfession << ".\n";
	cout << "Then, " << nPerson << " adopted a(n) " << nAnimal << " named " << nPetName << ".\n";
	cout << "They both lived happily ever after!\n";
	system("pause");
	return 0;
}