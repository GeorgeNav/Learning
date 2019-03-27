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

-- Adds column to a existing table
ALTER TABLE Product
        ADD COLUMN SalePrice DECIMAL(6,2) AFTER p_photo;

-- Alter table field contents
    UPDATE Product P
        SET SalePrice = (P.p_standard_price - P.p_standard_price * 0.15)
            WHERE P.p_standard_price < 400;