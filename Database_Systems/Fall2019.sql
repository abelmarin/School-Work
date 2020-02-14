/*
	Fall2019.sql
	Eric J. Schwabe
	CSC 355 Winter 2020

	for review purposes only -- do copy, post, or distribute
*/

-- drop any existing tables
DROP TABLE ENROLLMENT CASCADE CONSTRAINTS;
DROP TABLE SECTION CASCADE CONSTRAINTS;
DROP TABLE STUDENT CASCADE CONSTRAINTS;
DROP TABLE COURSE CASCADE CONSTRAINTS;
-- table of courses
CREATE TABLE COURSE
(
	CourseNumber	VARCHAR2(7),
	CourseName	VARCHAR2(36),

	CONSTRAINT PK_COURSE
		PRIMARY KEY (CourseNumber)
);
INSERT INTO COURSE VALUES
	('CSC 241', 'Introduction to Computer Science I');
INSERT INTO COURSE VALUES
	('CSC 300', 'Data Structures in Java I');
INSERT INTO COURSE VALUES
	('CSC 355', 'Database Systems');
INSERT INTO COURSE VALUES
	('IT 130', 'Introductory Computing for the Web');
INSERT INTO COURSE VALUES
	('IT 240', 'Introduction to Desktop Databases');
-- table of sections, linked to courses
CREATE TABLE SECTION
(
	SectionID	CHAR(5),
	CourseNumber	VARCHAR2(7),
	SectionNumber	CHAR(3),
	CONSTRAINT PK_SECTION
		PRIMARY KEY (SectionID),
	CONSTRAINT FK_SECTION_COURSE
		FOREIGN KEY (CourseNumber)
		REFERENCES COURSE(CourseNumber)
);
INSERT INTO SECTION VALUES
	('11111', 'CSC 355', '601');
INSERT INTO SECTION VALUES
	('22222', 'CSC 355', '602');
INSERT INTO SECTION VALUES
	('33333', 'CSC 300' , '910');
INSERT INTO SECTION VALUES
	('44444', 'IT 130', '602');
INSERT INTO SECTION VALUES
	('55555', 'CSC 241', '601');
INSERT INTO SECTION VALUES
	('66666', 'CSC 241', '902');
INSERT INTO SECTION VALUES
	('77777', 'IT 240', '601');
-- table of students
CREATE TABLE STUDENT
(
	StudentID	CHAR(7),
	FirstName	VARCHAR2(20),
	LastName	VARCHAR2(20),
	CONSTRAINT PK_STUDENT
		PRIMARY KEY (StudentID)
);
INSERT INTO STUDENT VALUES
	('1234567', 'Paul', 'Konrad');
INSERT INTO STUDENT VALUES
	('2345678', 'Robin', 'Baumgarten');
INSERT INTO STUDENT VALUES
	('3456789', 'Larry', 'Potash');
INSERT INTO STUDENT VALUES
	('4567890', 'Pat', 'Tomasulo');
INSERT INTO STUDENT VALUES
	('5678901', 'Sarah', 'Jindra');
INSERT INTO STUDENT VALUES
	('6789012', 'Ana', 'Belaval');
INSERT INTO STUDENT VALUES
	('7890123', 'Dean', 'Richards');
-- table of enrollments, linked to students and sections
CREATE TABLE ENROLLMENT
(
	StudentID	CHAR(7),
	SectionID	CHAR(5),
	CONSTRAINT PK_ENROLLMENT
		PRIMARY KEY (StudentID, SectionID),
	CONSTRAINT FK_ENROLLMENT_STUDENT
		FOREIGN KEY (StudentID)
		REFERENCES STUDENT(StudentID),
	CONSTRAINT FK_ENROLLMENT_SECTION
		FOREIGN KEY (SectionID)
		REFERENCES SECTION(SectionID)
);
INSERT INTO ENROLLMENT VALUES
	('1234567', '11111');
INSERT INTO ENROLLMENT VALUES
	('1234567', '33333');
INSERT INTO ENROLLMENT VALUES
	('2345678', '22222');
INSERT INTO ENROLLMENT VALUES
	('3456789', '22222');
INSERT INTO ENROLLMENT VALUES
	('3456789', '33333');
INSERT INTO ENROLLMENT VALUES
	('3456789', '55555');
INSERT INTO ENROLLMENT VALUES
	('5678901', '33333');
INSERT INTO ENROLLMENT VALUES
	('5678901', '77777');
INSERT INTO ENROLLMENT VALUES
	('5678901', '11111');
INSERT INTO ENROLLMENT VALUES
	('6789012', '33333');
INSERT INTO ENROLLMENT VALUES
	('6789012', '11111');
INSERT INTO ENROLLMENT VALUES
	('7890123', '22222');
INSERT INTO ENROLLMENT VALUES
	('7890123', '66666');
INSERT INTO ENROLLMENT VALUES
	('7890123', '77777');
-- display all tables
SELECT * FROM COURSE;
SELECT * FROM SECTION;
SELECT * FROM STUDENT;
SELECT * FROM ENROLLMENT;

select FirstName, LastName, CourseName, SectionNumber 
    from (student S left outer join enrollment E on s.StudentID=E.StudentID)
        left outer join section X on E.SectionID=X.SectionID
        left outer join course C on C.CourseNumber=X.CourseNumber;

select FirstName, LastName, S.StudentID, count(CourseName)
    from (student S left outer join enrollment E on s.StudentID=E.StudentID)
        left outer join section X on E.SectionID=X.SectionID
        left outer join course C on C.CourseNumber=X.CourseNumber
    group by S.StudentID, FirstName, LastName
    order by LastName, FirstName;
    
    

commit;

