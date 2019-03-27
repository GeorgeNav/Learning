<!-- PHP: server side language
Browser link to run php file
    http://localhost:4000/PHP/checkboxes.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>
        <form action = "checkboxes.php" method = "post">
            Student: <input type = "text" name = "student"> <br>
            <!-- multiple checkboxes -->
            Apples:  <input type = "checkbox" name = "fruits[]" value = "apples"> <br>
            Oranges: <input type = "checkbox" name = "fruits[]" value = "oranges"> <br>
            Pears:   <input type = "checkbox" name = "fruits[]" value = "pears"> <br>
            <input type = "submit">
        </form> <br>
        <?php
        /* Normal array */
            $fruits = $_POST["fruits"]; // Stores all the fruits the user checked into the fruits array
            for($i = 0; $i < count($fruits); $i++) // Shows the contents of the array
                echo $fruits[$i];
            echo "<br>";

        /* Associative array */
            $grades = array("Jim"=>"A+", "Pam"=>"B-", "Oscar"=>"C+"); // "Key"=>"value"
            if(isset($_POST["student"])) {
                echo $_POST["student"];
                echo "'s grade = "; echo $grades[$_POST["student"]]; echo "<br>";
            }
        ?>
    </body>
</html>