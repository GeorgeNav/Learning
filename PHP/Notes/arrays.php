<!-- PHP: server side language
Browser link to run php file
    http://localhost:4000/PHP/arrays.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>
        <?php
            $stuff = array("Kevin", 1, false, 'c'); // Can contain different data types
            $values = array("Kevin", "Karen", "Oscar", "Jim");
            echo $values[0]; echo "<br>";
            echo $stuff[3]; echo "<br>";
            echo "Number of elements in array values: "; echo count($values); echo "<br>";
        ?>
    </body>
</html>