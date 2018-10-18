#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    const double PI = 3.14159;
    double radius=0.0;
    double area=0.0;
    double length=0.0;
    double width=0.0;
    double base=0.0;
    double height=0.0;
    int choice=0;

    cout << "Geometry Calculator\n";
    cout << "\n";
    cout << "1. Calculate the area of a Circle\n";
    cout << "2. Calculate the area of a Rectangle\n";
    cout << "3. Calculate the area of a Triangle\n";
    cout << "4. Quit\n\n";
    cout << "Enter your choice (1-4): ";
    cin >> choice;
    
    if (choice>=1 && choice<=4)
    {    
        switch (choice)
        {
            case 1:
                cout << "\n";
                cout << "Enter the circle's radius: " << "\n";
                cin >> radius;
                
                if (radius>0)
                {    
                    area = PI * radius * radius;
                    cout << "The area is " << area;
                }
                else
                {
                    cout << "The radius can not be less than zero." << "\n";
                }
                break;
            case 2:
                cout << "\n";
                cout << "Enter the rectangle's length: ";
                cin >> length;
                cout << "Enter the rectangle's width: ";
                cin >> width;
                
                if (length>0 && width>0)
                {    
                    area = length * width;
                    cout << "\n" << "The area is " << area << "\n";
                }
                else
                {
                    cout << "\nOnly enter positive values for length and width.";
                }
            
                break;
            case 3:
                cout << "Enter the length of the base: ";
                cin >> base;
                cout << "Enter the triangle's height: ";
                cin >> height;
                
                if (base>0 && height>0)
                {    
                    area = (base * height)/2;
                    cout << "\nThe area is " << area;
                }
                else
                {
                    cout << "\nOnly enter positive values for base and height.";
                }
                break;
            case 4:
                cout << "Program ending.";
                break;
        }
    }
    else
    {
        cout << "The valid choices are 1 through 4. Run the\nprogram again and select one of those." << "\n";
    }

    return 0;
}