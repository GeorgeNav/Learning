<!-- PHP: server side language
Browser link to run php file
    http://localhost:4000/PHP/functions.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>

        <?php
            echo sayHi("George", 26); echo "<br>";
            echo "Cube of 3 = "; echo cubeNum(3); echo "<br>";

            if(false) {
                echo "if";
            } else if(false) {
                echo "else if";
            } else {
                echo "else";
            }
            
            function sayHi($name, $age) {
                echo "Hello $name, you are $age";
            }
            function cubeNum($num) {
                return pow($num, 3);
            }
        ?>
    </body>
</html>