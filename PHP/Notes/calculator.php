<!-- PHP: server side language
Browser link to run php file
    http://localhost:4000/PHP/calculator.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>
        <form action = "calculator.php" method = "get">
            <!-- step = "placeValueAccepted" -->
            Number: <input type = "number" step = "0.01" name = "num1">
            Op:<input type = "text" name = "op">
            Number:<input type = "number" step = "0.01" name = "num2"> <br>
            <input type = "submit">
        </form>
        <br>
        <?php
            if(isset($_GET["num1"]) && isset($_GET["op"]) && isset($_GET["num2"])) { // Check if a value exists for num1 and num2 before trying to add them
                $val1 = $_GET["num1"];
                $op = $_GET["op"];
                $val2 = $_GET["num2"];
                echo "Using if statement: ";
                    if($op == "+")
                        echo $val1 + $val2;
                    else if($op == "-")
                        echo $val1 - $val2;
                    else if($op == "*")
                        echo $val1 * $val2;
                    else if($op == "/")
                        echo $val1 / $val2;
                    else
                        echo "Invalid Input";
                    echo "<br>";
                echo "Using switch statement: ";
                    switch($op) {
                        case "+": echo $val1 + $val2; break; // break used other wise it would check for all other remaining cases
                        case "-": echo $val1 - $val2; break;
                        case "*": echo $val1 * $val2; break;
                        case "/": echo $val1 / $val2; break;
                        default: echo "Invalid Operator"; // when none of the cases are true
                    } echo "<br>";
            }
        ?>
    </body>
</html>