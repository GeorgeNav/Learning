DELIMITER $$ -- Change delimiter from ; to $$
DROP PROCEDURE IF EXISTS procedureName$$
CREATE PROCEDURE procedureName() -- Input can go in here (<here>)
    BEGIN
        -- Code
    END$$
DELIMITER;