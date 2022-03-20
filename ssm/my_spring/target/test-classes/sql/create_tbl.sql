show databases;
create database jdbctemplate;

use jdbctemplate;

create table book
(
    id     int unsigned auto_increment primary key,
    name   varchar(64) default '' comment '书名',
    author varchar(64) default '' comment '作者'
) engine = 'innodb';

show tables;
show create table book;

desc book;
select *
from book;

insert into book (name, author)
values ('西游记', '吴承恩');