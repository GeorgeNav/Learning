DROP TABLE Employee;
CREATE TABLE Employee (
    ename CHAR(30),
    dept CHAR(30),
    salary DECIMAL(15,2),
    PRIMARY KEY (ename) );

INSERT INTO Employee VALUES( 'CHUCK NORRIS', 'TOYS', 100000);
INSERT INTO Employee VALUES( 'JOHN SMITH', 'TOYS', 300000);
INSERT INTO Employee VALUES( 'HANK GREEN', 'TOYS', 200000);
INSERT INTO Employee VALUES( 'BOB WHITE', 'CS', 100000);
INSERT INTO Employee VALUES( 'CHRIS BROWN', 'CS', 50000);

DROP VIEW EmployeeNames;
CREATE VIEW EmployeeNames (ename) AS
    SELECT E.ename
        FROM Employee E;
DROP VIEW DeptInfo;
CREATE VIEW DeptInfo (dept, avgsalary) AS
    SELECT
        DISTINCT E.dept, AVG(E.salary) AS avgsalary
            FROM Employee E
                GROUP BY E.dept;
SELECT * FROM EmployeeNames;
SELECT * FROM DeptInfo;
