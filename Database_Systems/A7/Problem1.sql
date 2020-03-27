/*
Abel Marin
CSC 355 Section 501
Assignment 7 Problem 1
March 10, 2020
*/

DECLARE
    r1 withhold.rate1%type;
    r2 withhold.rate2%type;
    threshold withhold.threshold%type;
    cursor rates is select * from withhold;

    payrollInfo payroll%rowtype;
    cursor payrollPtr is select eid, esalary from payroll;

    tax integer := 0;

    total integer := 0;
    
BEGIN
    open rates;
    fetch rates into r1, threshold, r2;
    close rates;

    dbms_output.put_line('Rates: ' || r1 || ', ' || r2);
    dbms_output.put_line('Threshold: ' || threshold || '');
    dbms_output.new_line;

    for payrollInfo in payrollPtr loop
        if payrollInfo.esalary <= threshold then
            tax := payrollInfo.esalary * (r1/100);
        else
            tax := threshold * (r1/100);
            tax := tax + ((payrollInfo.esalary-threshold) * (r2/100));
        end if;

        dbms_output.put_line(payrollInfo.eid || ': ' || payrollInfo.esalary 
            || ' ' || tax || ' ' || (payrollInfo.esalary-tax));
        
        total := total + tax;
    end loop;

    dbms_output.new_line;
    dbms_output.put_line('Total tax: ' || total);
END;
/