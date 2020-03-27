DECLARE
/* VARIABLE DECLARATIONS… */
values123 dowjones.value%type;
cursor currentValue is select value from dowjones;

changeInfo change%rowtype;
cursor changes is select direction, amount from change;


BEGIN
/* PL/SQL CODE TO BE EXECUTED… */
open currentValue;
fetch currentValue into values123;
close currentValue;

for changeInfo in changes loop
if changeInfo.direction = 'Up' then
values123 := values123 + changeInfo.amount;
elsif changeInfo.direction = 'Down' then
values123 := values123 - changeInfo.amount;
end if;
end loop;

update dowjones set value = values123;
















END;
/

