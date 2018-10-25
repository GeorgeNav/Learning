<!-- PHP: server side language
HTML and PHP can be used in this type of file

Terminal Commands
    Create php webserver
        > cd /Users/georgenav/GoogleDrive/Development/Site; php -S localhost:4000
Browser link to run php file
    http://localhost:4000/PHP/firstSite.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>
        <!-- Form tag
        Attributes
            action (from where)
            method (what we want to do with the form)
        -->
        <form action = "firstSite.php" method = "get">
            <!-- Input tag: can be used with forms
            Attributes
                type = "text" or "submit"
                name = "nameToReference"
            -->
            Name: <input type = "text" name = "name"> <br>
            Age: <input type = "number" name = "age"> <br>
            <input type = "submit">
        </form>
        <br>
        <!-- PHP tag: PHP commands are ran from server in order -->
        <?php
        /* Data types */
            $name = $_GET["name"]; // Gathers input from 'name' in form
            $age = $_GET["age"]; // Declares integer variable and stores the value 26
            $decimalNum = 26.0; // Declares a flooting point variable and stores the value 26.0
            $male = true; // Declares boolean variable and stores true (can store true and false)

            echo "Hello World"; // Writes text into html code
        /* Writes html tags and contents */
            echo "<h1>$name's Site</h1>";
            echo "<hr>"; // Creates line
            echo "<p>I am $name, I am $age, and this is my first PHP site</p>";
            $age++; // Updates variable
            echo "I turn $age next year! <br>";

        /* String functions */
            echo "String to lower and uppeer case functions: ";
                echo strtolower($name); // String to lowercase
                echo ", ";
                echo strtoupper($name); // String to uppercase
                echo "<br>";
            echo "# of characters in $name: ";
                echo strlen($name); // String length (# of characters)
                echo "<br>";
            echo "First character in $name: ";
                echo $name[0]; // Prints first character in string
                echo "<br>";
            echo "First character in string 'Mike': ";
                echo "Mike"[0]; // Prints first character in string
                echo "<br>";
            
            $firstChar = $name[0]; // Stores original character
            $name[0] = "F"; // Changed first index of string to F
            echo "Original name first character index changed to F: ";
                echo $name;
                echo "<br>Changed first index back to original character...";
            $name[0] = $firstChar[0]; // Changes first index of string to orginal character
            echo "$name <br>";
            echo "Changing a substring (last name) in string to a different string value (Nav): ";
                echo str_replace("Navarro", "Nav", $name); // (replace X, with Y, in the string Z)
                echo "<br>";
            echo "Getting substring from character index 7 (2 methods): ";
                echo substr($name, 7, 7); // (get substring from X, from index Y including Y, # of characters)
                echo ", ";
                echo substr($name, 7); // (get substring from X, from index Y including Y to end of string)
                echo "<br>";
        /* Math functions */
            echo "5 + 9 * 10 = "; echo 5 + 9 * 10; echo "<br>";
            echo "(5 + 9) * 10 = "; echo (5 + 9) * 10; echo "<br>";
            echo "Remainder of 10/3 = "; echo 10 % 3; echo "<br>";
            $num = 10;
            $num++; // Increments original integer
            $num += 10; // Adds 10 to original integer
            $num -= 100; // Adds 10 to original integer
            echo "Absolute value of $num = "; echo abs($num); echo "<br>";
            echo "2 to the 4th power = "; echo pow(2,4); echo "<br>"; // (base, power)
            echo "Square root of 144 = "; echo sqrt(144); echo "<br>"; // sqrt of (value)
            echo "Max of 2 and 10 = "; echo max(2,10); echo "<br>"; // max value of (val1, val2)
            echo "Min of 2 and 10 = "; echo min(2,10); echo "<br>"; // max value of (val1, val2)
            echo "Round 3.5 = "; echo round(3.5); echo "<br>"; // Round if tenths place is 5 or greater
            echo "Ceiling 3.2 = "; echo ceil(3.2); echo "<br>"; // Round up if there is tenths place value that is not 0
            echo "Floor 3.5 = "; echo floor(3.5); echo "<br>"; // Round down if there is tenths place value that is not 0
        /* Get User input with a form (middle man between html and php)*/

        ?>
    </body>
</html>