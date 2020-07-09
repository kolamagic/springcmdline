create table if not exists log
(
    level varchar(30) not null,
    message varchar(100) not null,
    userid int not null,
    created int not null
);