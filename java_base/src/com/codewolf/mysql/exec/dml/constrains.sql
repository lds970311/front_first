# Author : CSR丶SUSE
# Time : 2022-01-15  16:39
# TOOLS : INTELLIJ IDEA
# FILENAME : constrains.sql
# STATEMENT:
CREATE DATABASE test04_emp;
show databases;
use test04_emp;

CREATE TABLE emp2
(
    id       INT,
    emp_name VARCHAR(15)
);

CREATE TABLE dept2
(
    id        INT,
    dept_name VARCHAR(15)
);

show tables;
alter table emp2
    add primary key (id);
desc emp2;

# 2. 向表dept2的id列中添加PRIMARY KEY约束
alter table dept2
    add primary key (id);
desc dept2;

# 3. 向表emp2中添加列dept_id，并在其中定义FOREIGN KEY约束，与之相关联的列是dept2表中的id列
alter table emp2
    add dept_id int;
alter table emp2
    add foreign key (dept_id) REFERENCES dept2 (id);

# 创建表
create table if not exists library
(
    id      int,
    name    varchar(50),
    author  varchar(100),
    price   decimal(10, 2),
    pubdate YEAR,
    note    varchar(100),
    num     int
) engine = 'innodb';

alter table library
    add primary key (id);
alter table library
    modify id int auto_increment;
alter table library
    modify `name` varchar(50) not null;

show tables;