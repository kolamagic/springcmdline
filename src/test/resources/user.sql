create table if not exists user
(
    id int not null auto_increment primary key,
    userName varchar(50) not null,
    balance int not null,
    created int not null,
    updated int not null
);

delete from user where 1=1;

insert into user (userName, balance, created, updated)
values ('aaa', 1, 3000, 3000),
       ('bbb', 2, 4000, 4000),
       ('ccc', 3, 5000, 5000);