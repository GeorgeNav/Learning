-- Deletes table reguardless of references
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists tableName;
SET FOREIGN_KEY_CHECKS = 1;

