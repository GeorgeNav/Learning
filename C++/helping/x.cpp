#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <stdio.h>
#include <unistd.h>
using namespace std;

string change_direction(string current_direction)
{
    if (current_direction == "E")
        return "S";
    if (current_direction == "W")
        return "N";
    if (current_direction == "N")
        return "E";
    if (current_direction == "S")
        return "W";

    return "";
}
void display_details(string plate_number, string direction, int time)
{
    if (direction == "E")
        cout << "Current Direction:Eastbound";
    if (direction == "W")
        cout << "Current Direction:Westbound";
    if (direction == "N")
        cout << "Current Direction:Northbound";
    if (direction == "S")
        cout << "Current Direction:Southbound";

    cout << " Car " << plate_number << " is using the intersection for " << time << " sec(s) ";
}

int main()
{
    string line;
    string initial_direction;
    int max_cars;
    string car_plates[1000];
    string direction[1000];
    int time[1000];
    bool crossed[1000];
    ifstream file("input1.txt");

    int line_number = 1;
    int i = 0;
    if (file.is_open())
    {
        while (getline(file, line))
        {
            stringstream s(line);
            if (line_number == 1)
            {
                s >> initial_direction;
            }
            if (line_number == 2)
            {
                s >> max_cars;
            }
            else
            {
                s >> car_plates[i] >> direction[i] >> time[i];
                crossed[i] = false;
                i++;
            }
            line_number++;
        }
        file.close();
    }
    else
        cout << "Error Opening File!";

    int total_cars = i - 1;
    int cars_so_far = 0;
    int cars_per_intersection = 0;
    string current_direction = initial_direction;
    bool carfound = false;
    while (cars_so_far != total_cars)
    {
        carfound = false;
        for (int j = 1; j < i; j++)
        {
            if (cars_per_intersection == max_cars)
            {
                cars_per_intersection = 0;
                current_direction = change_direction(current_direction);
            }
            if (crossed[j] == false && direction[j] == current_direction)
            {
                pid_t p = fork();
                if (p == 0)
                {
                    crossed[j] = true;
                    cars_per_intersection++;
                    carfound = true;
                    cars_so_far++;
                    display_details(car_plates[j], direction[j], time[j]);
                    break;
                }
                else
                {
                }
            }
        }
        if (!carfound)
        {
            current_direction = change_direction(current_direction);
        }
    }

    return 0;
}