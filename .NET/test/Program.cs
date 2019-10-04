using System;

namespace NumberGuesser// Namespace
{
    class Program // Main class
    {
        static void Main(string[] args) // Entry point
        {
            String appAuthor = "George Navarro";

            Console.ForegroundColor = ConsoleColor.Green; // Change text color
            Console.WriteLine($"Hey there {appAuthor}!"); // adds enter to end of line
            Console.WriteLine("Hey there {0}!", appAuthor); // adds enter to end of line

            int number = 0;
            int guess = 1;
            Random r = new Random();
            while(guess != number) {
                Console.Write("Could not guess your number.. "); // does not add enter to end of line
                Console.Write("Enter a number: "); // does not add enter to end of line
                if(!int.TryParse(Console.ReadLine(), out number)) {
                    Console.WriteLine("NOT A VALID NUMBER"); // does not add enter to end of line
                    continue;
                }
                guess = r.Next(0,10); // gets random integer from 0 - 10
            }
            Console.ResetColor();
            Console.WriteLine("I guessed your number! "); // does not add enter to end of line
        }
    }
}
