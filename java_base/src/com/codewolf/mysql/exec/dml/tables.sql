# Author : CSR丶SUSE
# Time : 2022-01-14  20:25
# TOOLS : INTELLIJ IDEA
# FILENAME : tables.sql
# STATEMENT: 创建和管理表

#1. 创建数据库test01_office,指明字符集为utf8。并在此数据库下执行下述操作
create database if not exists test01_office charset 'utf8';
#2. 创建表dept01

/*
字段      类型
id       INT(7)
NAME     VARCHAR(25)
*/

use test01_office;
create table if NOT exists dept01
(
    `id`   int(7),
    `name` varchar(25)

);
show tables;

#3. 将表departments中的数据插入新表dept02中
create table if not exists dept02 as
select *
from codewolfdb.departments;
desc dept02;
#4. 创建表emp01

/*
字段         类型
id          INT(7)
first_name  VARCHAR (25)
last_name   VARCHAR(25)
dept_id     INT(7)
*/
create table if not exists emp01
(
    id         int(7),
    first_name varchar(25),
    last_name  varchar(25),
    dept_id    int(7)
) engine = 'innodb';
show tables;

#5. 将列last_name的长度增加到50
alter table emp01
    modify first_name varchar(50);
#6. 根据表employees创建emp02
create table if not exists emp02 as
select *
from codewolfdb.employees;
show tables;

#7. 删除表emp01
drop table if exists emp01;
show tables;

#8. 将表emp02重命名为emp01
alter table emp02 rename emp01;

#9.在表dept02和emp01中添加新列test_column，并检查所作的操作
alter table dept02
    add test_column varchar(10) after location_id;
alter table emp01
    add test_column varchar(10) after email;

#10.直接删除表emp01中的列 department_id
alter table emp01
    drop department_id;