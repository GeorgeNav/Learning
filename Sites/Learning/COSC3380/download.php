<html>
    <head>
        <title>Download File From MySQL</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>

    <body>
        <?php
            include 'library/config.php';
            include 'library/opendb.php';

            $query = "SELECT id, name FROM upload";
            $result = mysql_query($query) or die('Error, query failed');
            if(mysql_num_rows($result) == 0)
            {
                echo "Database is empty <br>";
            }
            else
{
	while(list($id, $name) = mysql_fetch_array($result))
	{
?>
        <!--<a href="download.php?id=<?php echo urlencode($id);?>"><?php echo urlencode($name);?></a> <br>-->
        <a href="download.php?id=<?php echo $id; ?>"><?php echo $name;?></a> <br>
<?php
	}
            }
            include 'library/closedb.php';
        ?>

        <a href=javascript:history.back()> Go Back to Upload </a>
    </body>
</html>