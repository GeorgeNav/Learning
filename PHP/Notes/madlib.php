<!-- PHP: server side language
Browser link to run php file
    http://localhost:4000/PHP/madlib.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>
        <form action = "madlib.php" method = "get">
            Color: <input type = "text" name = "color"> <br>
            Plural Noun: <input type = "text" name = "pluralNoun"> <br>
            Celebrity: <input type = "text" name = "celebrity"> <br>
            <input type = "submit">
        </form>
        <br>
        <?php
            if(isset($_GET["color"]) && isset($_GET["pluralNoun"]) && isset($_GET["celebrity"])) {
                $color = $_GET["color"];
                $pluralNoun = $_GET["pluralNoun"];
                $celebrity = $_GET["celebrity"];
                echo "Roses are $color <br>";
                echo "$pluralNoun are blue <br>";
                echo "I love $celebrity <br>";
            }
        ?>
    </body>
</html>