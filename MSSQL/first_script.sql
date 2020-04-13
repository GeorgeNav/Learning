CREATE TABLE Employee (
    id INT NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    salary MONEY,
    PRIMARY KEY(id)
);

INSERT INTO Employee VALUES (123, 'Navarro', 'George', 15.50);
INSERT INTO Employee VALUES (321, 'Billings', 'Doug', 15.50);
INSERT INTO Employee VALUES (321, 'Philips', 'Matt', 15.50);

-- DROP TABLE Employee;