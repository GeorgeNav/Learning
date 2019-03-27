#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
using namespace std;

struct carVariable
{
    char licensePlate[10];
    int time;
} cars[4][100]; //store cars data
static int max_car[4];
static int cars_used[4];

static char directions[][15] = {"Eastbound", "Southbound", "Westbound", "Northbound"};
int main()
{
    int initialDirection, maxCar, time, direction;
    int i, remainCar = 0;
    char carDirection, licensePlate[10];
    char lines[25];

    carDirection = getchar();

    //initial direction
    if (carDirection == 'E')
        initialDirection = 1;
    else if (carDirection == 'S')
        initialDirection = 2;
    else if (carDirection == 'W')
        initialDirection = 3;
    else
        initialDirection = 4;
    carDirection = getchar(); // to skip ' '

    carDirection = getchar();
    // max cars each time
    maxCar = (int)carDirection - 48;

    carDirection = getchar(); // to skip ' '

    while (fgets(lines, 24, stdin))
    {
        sscanf(lines, "%s %c %d", licensePlate, &direction, &time);

        //for indexing according to direction
        if (direction == 'E')
            i = 1;
        else if (direction == 'S')
            i = 2;
        else if (direction == 'W')
            i = 3;
        else
            i = 4;

        // for storing cars data into structure
        strcpy(cars[i][max_car[i]].licensePlate, licensePlate);
        cars[i][max_car[i]].time = time;
        max_car[i]++;
        remainCar++; // to count total cars
    }

    while (remainCar > 0)
    {
        i = maxCar;
        int firstTime = 1;
        while (i > 0 && remainCar > 0)
        {
            if (max_car[initialDirection] > cars_used[initialDirection])
            {
                if (firstTime)
                {
                    firstTime = 0;
                    cout << "Current direction: " << directions[initialDirection] << endl;
                }
                int used = cars_used[initialDirection]++;
                strcpy(licensePlate, cars[initialDirection][used].licensePlate);
                time = cars[initialDirection][used].time;

                cout << "Car " << licensePlate << " is using the intersection for " << time << " sec(s). " << endl;

                if (!fork()) //creating child process using fork.
                {
                    sleep(time); //make child process to sleep.
                    return 0;
                }
                else
                {
                    wait(NULL);
                    i--;
                    remainCar--;
                }
            }
            else
                i = 0;
        }
        initialDirection = (++initialDirection) % 4;
    }
}