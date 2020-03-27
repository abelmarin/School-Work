/*
Abel Marin
CSC 355 Section 501
Assignment 7 Problem 2
March 10, 2020
*/

CREATE OR REPLACE TRIGGER payrollCheck AFTER INSERT OR UPDATE ON payroll

declare
    totalHighSalaries integer;

begin
    select count(esalary)
    into totalHighSalaries
    from payroll
    where esalary > 10000;

    if totalHighSalaries > 3 then
        RAISE_APPLICATION_ERROR(-20001, 'Too many employee salarys over 10000');
    end if;
end;
/