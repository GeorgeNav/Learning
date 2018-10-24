-- Change root password
ALTER USER 'root'@'localhost' IDENTIFIED BY 'yournewpassword';
-- Show databases
SHOW DATABASES;
-- Create a database
CREATE DATABASE NameOfDatabase;
-- Start the command line interface (CLI)
mysql-ctl cli;
-- Shows the database currently being used
SELECT DATABSE();
-- Shows tables in current database
SHOW TABLES;
-- Shows column specifics for a table (all do the same thing)
SHOW COLUMNS FROM tableName;
DESCRIBE tableName;
DESC tableName;
