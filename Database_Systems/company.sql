/*
	company.sql
	Eric J. Schwabe
	CSC 355 Winter 2020

	for review purposes only
	do not copy, post, or distribute
*/

-- First, set up table of workers' names (just letters),
-- department numbers (just digits), and salaries, and
-- display both the table and the total of the salaries

DROP TABLE WORKER;


CREATE TABLE WORKER
(
	Name		CHAR(1),
	Dept		NUMBER(3,0),
	Salary		NUMBER(8,2),

	CONSTRAINT PK_WORKER
		PRIMARY KEY (Name)
);

INSERT INTO WORKER VALUES('A', 555, 30000); 
INSERT INTO WORKER VALUES('B', 222, 45000); 
INSERT INTO WORKER VALUES('C', 555, 70000);
INSERT INTO WORKER VALUES('D', 222, 55000); 
INSERT INTO WORKER VALUES('E', 111, 25000); 
INSERT INTO WORKER VALUES('F', 333, 90000); 
INSERT INTO WORKER VALUES('G', 444, 90000); 
INSERT INTO WORKER VALUES('H', 222, 39000); 
INSERT INTO WORKER VALUES('I', 111, 36000); 
INSERT INTO WORKER VALUES('J', 333, 60000); 
INSERT INTO WORKER VALUES('K', 555, 76000); 
INSERT INTO WORKER VALUES('L', 333, 40000); 
INSERT INTO WORKER VALUES('M', 444, 85000); 
INSERT INTO WORKER VALUES('N', 111, 39000); 
INSERT INTO WORKER VALUES('O', 222, 42000);

SELECT * FROM WORKER;
