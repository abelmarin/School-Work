/*
Abel Marin
CSC 355 Section 501
Assignment 2
January 22, 2020
*/


-- Create Tables

drop table BOOKING;
drop table TRAVELER;
drop table TOUR;

create table TRAVELER (
    TrID        varchar(5) check (length(TrID) = 5),
    TrName      varchar(20),
    TrPhone     varchar(10) check (length(TrPhone) = 10),
    primary key (TrID)
);

create table TOUR (
    TID                 varchar(4) check (length(TID) = 4),
    DestinationName     varchar(20),
    TLength             number(3) check (TLength > 0),
    TCost               number(6,2) check (TCost >= 0 and TCost <= 9999.99),
    primary key (TID)  
);

create table BOOKING (
    TourID      varchar(4) check (length(TourID) = 4),
    TravelerID  varchar(5) check (length(TravelerID) = 5),
    TourDate    Date,
    primary key (TourID, TravelerID),
    foreign key (TourID) references TOUR(TID),
    foreign key (TravelerID) references TRAVELER(TrID)
);

-- Populate Tables

insert into TOUR values ('1234', 'Liberty City', 1, 99.99);
insert into TOUR values ('1498', 'Los Santos', 345, 9999.99);
insert into TOUR values ('3752', 'Vice City', 12, 499.99);
insert into TOUR values ('3333', 'San Fierro', 15, 89.95);

insert into TRAVELER values ('12345', 'Steven Bell', '1234567890');
insert into TRAVELER values ('45383', 'Michael Phoenix', '7492956382');
insert into TRAVELER values ('36482', 'Abel Marin', '4528463916');

insert into BOOKING values ('1234', '12345', date '1969-08-15');
insert into BOOKING values ('1234', '45383', date '1969-08-15');
insert into BOOKING values ('1498', '12345', date '2007-12-31');
insert into BOOKING values ('3333', '36482', date '2020-01-22');
insert into BOOKING values ('3752', '45383', date '1994-10-14');

-- Display Tables

select * from TRAVELER;
select * from TOUR;
select * from BOOKING;