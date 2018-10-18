//PLACE YOUR NAME HERE
//Date: 
// Program simulates the number guessing game 
#include<iostream>
using namespace std;

const int MAX = 1000;

int main()
{
	char ch;
	
	cout << "Think of an integer number between 0 and " << MAX<<endl;
	cout << "Write it down on a piece of paper then hit a key to continue"<<endl<<endl;
	cin.get(ch);

	cout << endl<<"I am going to guess the number you picked... " ;
	cout << "You just need to give me some hints"<<endl<<endl;
	cout <<"Hit any key when you're ready..."<<endl<<endl;
	cin.get(ch);
	
	int first = 0;	// First element of list.  
	int last = MAX;	// last element of the list
	int middle;		// variable containing the current  middle value of the list
	int count = 1;

	while (count <= 10)
	{
		middle = first + (last - first) / 2; 
		
		do
		{
		cout <<" Is it: "<< middle <<"?" <<endl<<endl;
		cout <<"Press y for Yes or N for No:";
		cin >> ch;
		ch = toupper(ch);
		}while(ch != 'Y' && 'N');
		/* ADD A LOOP TO VALIDATE INPUT IS EITHER 'Y' or 'N'*/

		if (ch == 'Y') 
		{
			cout <<"Bingo...I did it!!!"<<"in "<< count <<" guesses!!" <<endl; 
			cout <<"Goodbye"<< endl;
			cin.get(ch); cin.get(ch);
		}
		else 
		{
			cout <<"Umm!  Is your number higher or lower than "<< middle<< "?";
			cout <<endl << endl;
			cout <<"Press H for higher and L for lower:";
			cin >> ch;
			ch = toupper(ch);

			/* ADD A LOOP TO VALIDATE INPUT IS EITHER 'H' or 'L'*/

			if (ch == 'H' )  // if number > guessed value then number 
  	 				   // is in [middle+1 ... last]
				first = middle + 1;

			else  if (ch == 'L' ) // if number < guessed value then number is 
  						 // in [first ... middle-1]
				last = middle -1;

		}
		count ++;                            
	do
		{
		cout << "Would you like to Continue (C)? Or Stop(S)? ";
		cin >> ch;
		ch = toupper(ch);
		}while(ch != 'S' && ch != 'C');

		if (ch == 'S')
			break;
		else if (ch == 'C')
			continue;	
	}
	return 0;
}