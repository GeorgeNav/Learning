<!-- PHP: server side language
Browser link to run php file
    http://localhost:4000/PHP/include.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>
        <?php include "include/header.html" ?> <!-- Place code from header.html file here -->
        <?php include "include/footer.html" ?> <!-- Then place code from footer.html file here -->
        <!-- Includes php code -->
        <?php
            $title = "My First Post";
            $author = "Mike";
            $wordCount = 400;
            include "include/article-header.php";
        ?>
    </body>
</html>