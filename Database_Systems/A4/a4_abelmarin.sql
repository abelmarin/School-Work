/*
Abel Marin
CSC 355 Section 501
Assignment 3
February 6, 2020
*/

-- 1
select count(salary), avg(salary)
    from employee
    where salary >= 90000;

-- 2
select dname, dnumber, max(salary)
    from department D inner join employee E
        on D.dnumber = E.dno
    group by D.dname, dnumber
    order by dnumber;

-- 3
select last, salary
    from employee E inner join department D
        on E.dno = D.dnumber 
            and dname = 'Development' 
            and gender = 'M'
    order by salary;

-- 4
select min(salary)
    from employee
    where eid in (select employeeid
                from assignment
                where projectno = (select pnumber
                                from project
                                where pname = 'Automation'));

-- 5
select pname, hours
    from project P inner join assignment A on P.pnumber = A.projectno
        inner join employee E on A.employeeid = E.eid
    where E.first = 'Ahmed' and E.last = 'Salman'
    order by pname;

-- 6
select employeeid, count(projectno) 
    from assignment
    group by employeeid
    having count(projectno) >= 3; 

-- 7
select eid, E.first, E.last, D.first, D.age
    from employee E inner join dependent D 
        on eid = employeeid and relationship = 'Son'
    order by D.age;

-- 8
select pnumber, pname, nvl(sum(hours), 0)
    from project left outer join assignment
        on pnumber = projectno
    where plocation = 'Pittsburgh'
    group by pnumber, pname
    order by nvl(sum(hours), 0) desc;

