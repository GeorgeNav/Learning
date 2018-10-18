// Program Favorit surveys users to determine the favorite soft drink.
#include <iostream>
#include <iomanip>

using namespace std;
enum Drinks { COKE, PEPSI, SPRITE, DR_PEPPER };

void Prompt();

int main ()
{
double percent = 0;
int total = 0;
int favorites[4]; //holds sum of users who favor each drink
int number;
Drinks index;

// FILL IN Code to initialize array favorites to all zeros
for ( int i = 0; i < 4; i++ )
{
	favorites[i] = 0;
}

Prompt();
cin >> number;

while ( number != 4 )
{
	// FILL IN Code to increment the proper drink favorites based on user selections
	// e.g. if user enter 0 increment favorites[COKE] etc.
	if ( number == COKE )
	{
		++( favorites[COKE] );
	}
	if ( number == PEPSI )
	{
		++( favorites[PEPSI] );
	}
	if ( number == SPRITE )
	{
		++( favorites[SPRITE] );
	}
	if ( number == DR_PEPPER )
	{
		++( favorites[DR_PEPPER] );
	}
	Prompt();
	cin >> number;
}

// FILL IN THE Code to write out the totals in the format:
// Drink Number of favorites

for ( int i = 0; i < 4; i++ )
{
	total += favorites[i];
}

for ( int i = 0; i < 4; i++ )
{
	cout << showpoint << setprecision(2) << fixed;
	percent = double ( favorites[i] * 100 ) / total;	
	if ( i == 0 )
		cout << "# of Cokes: " << favorites[i] << "\n" << "Precent: " << percent << "\n";
	if ( i == 1 )
		cout << "# of Pepsi: " << favorites[i] << "\n" << "Percent: " << percent << "\n";
	if ( i == 2 )
		cout << "# of Sprites: " << favorites[i] << "\n" << "Percent: " << percent << "\n";
	if ( i == 3 )
		cout << "# of Dr.Peppers: " << favorites[i] << "\n" << "Percent: " << percent << "\n";
}

system("pause");
return 0;
}

//This Function displays options for a favorite drink
void Prompt()
{
cout << "Enter a 0 if your favorite is a Coke." << "\n";
cout << "Enter a 1 if your favorite is a Pepsi." << "\n";
cout << "Enter a 2 if your favorite is a Sprite." << "\n";
cout << "Enter a 3 if your favorite is a DrPepper." << "\n";
cout << "Enter a 4 if you wish to quit the survey." << "\n";
}