#include <iostream>
#include <string>

using namespace std;

int main()
{
string currentWord = "";
string previousWord = "";
int dupeAlready = 0, n;

n = 0;

while ( currentWord != "xxxxx" )
	{
		cin >> currentWord; //fish bird reptile reptile bird bird bird mammal fish xxxxx

		if ( currentWord != previousWord && currentWord != "xxxxx" )
			{
				n++;
				dupeAlready = 0;
			}
              
		if ( currentWord == previousWord && currentWord != "xxxxx" && n != 0 )
			{
				if ( dupeAlready!=1 )
					{
						n--;
						dupeAlready = 1;
					}
			}

		previousWord = currentWord;
	}
	
	cout << n;
	system("pause");
	return 0;
}