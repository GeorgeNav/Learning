<!-- PHP: server side language
Browser link to run php file
    http://localhost:4000/PHP/classes.php
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="htf-8">
        <title></title>
    </head>
    <body>
        <?php
            class Book {
                private $title; // var and public are the same
                private $author;
                private $pages;
                function __construct($t, $a, $p) {
                    $this->setTitle($t);
                    $this->setAuthor($a);
                    $this->setPages($p);
                    echo $this->getTitle(); echo "<br>";
                    echo $this->getAuthor(); echo "<br>";
                    echo $this->getPages(); echo "<br>";
                }
                public function getTitle() { return $this->title; }
                public function getAuthor() { return $this->author; }
                public function getPages() { return $this->pages; }
                public function setTitle($t) { $this->title = $t; }
                public function setAuthor($a) { $this->author = $a; }
                public function setPages($p) { $this->pages = $p; }
            }
            class Comic extends Book {
                private $color;
                function __construct($t, $a, $p, $c) {
                    $this->setTitle($t);
                    $this->setAuthor($a);
                    $this->setPages($p);
                    $this->setColor($c);
                    echo $this->getTitle(); echo "<br>";
                    echo $this->getAuthor(); echo "<br>";
                    echo $this->getPages(); echo "<br>";
                    echo $this->getColor(); echo "<br>";
                }
                public function getColor() {
                    if($this->color)
                        echo "Color";
                    else
                        echo "Black and White";
                }
                public function setColor($c) { $this->color = $c; }
            }

            $book1 = new Book("Fun", "Bob", 10);
            $book2 = new Book("Not Fun", "Luis", 5000);
            echo "Get title of book1: ";
                echo $book1->getTitle(); echo "<br>";
            echo "Get author of book2: ";
                echo $book2->getAuthor(); echo "<br>";
            $comicBook = new Comic("Spider Man", "Peter", 50, true);
        ?>
    </body>
</html>