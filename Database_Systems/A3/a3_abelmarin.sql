/*
Abel Marin
CSC 355 Section 501
Assignment 3
January 30, 2020
*/

-- 1
select city 
    from customer
    group by city
    order by city;

-- 2
select title, price
    from item
    order by price;

-- 3
select title, type, price
    from item
    where price < 15
    order by price desc;

-- 4
select title
    from item
    where title like '%West%'
    order by title;

-- 5
select cid
    from purchase
    where pdate > '31-DEC-2018' and pdate < '01-JAN-2020' 
    group by cid
    order by cid;

-- 6
select cid, max(pdate)
    from purchase
    group by cid;
    
-- 7
select type, min(price)
    from item
    group by type; 

-- 8
select pdate, count(cid)
    from purchase
    group by pdate
    order by count(cid) desc;

-- 9
select pid, pdate
    from purchase inner join customer
        on purchase.cid = customer.id and name = 'Reed'
    order by pid;

-- 10
select pid, item.price * purchase.quantity
    from purchase inner join item
        on purchase.iid = item.id
    order by item.price * purchase.quantity desc;