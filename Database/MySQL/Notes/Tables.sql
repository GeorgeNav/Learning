-- Deletes table
DROP TABLE IF EXISTS tableName;

-- Deletes table reguardless of references
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS tableName;
SET FOREIGN_KEY_CHECKS = 1;

-- Table: create with a plural name
CREATE TABLE Tweets (
    username VARCHAR(15),
    content VARCHAR(140),
    favorites INT );