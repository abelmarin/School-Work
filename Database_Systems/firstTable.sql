-- first sql script --

-- drop any existing table

drop table INFO;

create table INFO (
    StudentID   CHAR(3)     primary key,
    first       VARCHAR(20),
    last        VARCHAR(20),
    ExamDate    DATE,
    Score       NUMBER(3,0) check (0 <= Score AND Score <= 100)
);

-- populate the table

insert into INFO values ('779', 'Abel', 'Marin', date '1999-09-14', 100);

insert into INFO values ('123', 'Steven', 'Bell', date '1999-09-17', 99);


select * from INFO;

commit;