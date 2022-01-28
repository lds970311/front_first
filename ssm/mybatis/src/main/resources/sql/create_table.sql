# Author : CSR丶SUSE
# Time : 2022-01-28  1:47
# TOOLS : INTELLIJ IDEA
# FILENAME : create_table.sql
# STATEMENT: 建表

create database if not exists mybatis;
use mybatis;

create table tbl_employee
(
    id        int primary key auto_increment,
    last_name varchar(128),
    gender    char(1),
    email     varchar(255)
) engine = 'innodb';