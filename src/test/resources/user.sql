create table if not exists user
(
    id int not null auto_increment primary key,
    userName varchar(50) not null,
    balance int not null,
    created int not null,
    updated int not null
);

delete from user where 1=1;

insert into user (id, userName, balance, created, updated)
values (1, 'aaa', 1, 3000, 3000),
       (2, 'bbb', 2, 4000, 4000),
       (3, 'ccc', 3, 5000, 5000);