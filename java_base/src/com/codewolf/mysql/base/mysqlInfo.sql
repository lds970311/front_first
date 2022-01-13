# Author : CSR丶SUSE
# Time : 2022-01-12  19:11
# TOOLS : INTELLIJ IDEA
# FILENAME : mysqlInfo.sql
# STATEMENT:
show databases;
use mysql;
create database mydb;
use mydb;
show tables;

create table man
(
    id   int,
    name varchar(16)
) engine = "INNODB";

desc man;

show create table man; # 查询创建表的信息

show variables like 'character_%';