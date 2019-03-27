<!-- PHP: server side language
Browser link to run php file
    http://localhost:4000/PHP/secureForm.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>
        <form action = "secureForm.php" method = "post">
            Password: <input type = "password" name = "password"> <br>
            <input type = "submit">
        </form>
        <br>
        <?php
            if(isset($_POST["password"]))
                echo $_POST["password"];
        ?>
    </body>
</html>