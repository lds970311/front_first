# Author : CSR丶SUSE
# Time : 2022-02-10  21:47
# TOOLS : INTELLIJ IDEA
# FILENAME : add_constrains.sql
# STATEMENT:

show databases;
use mybatis;
show tables;

create table tbl_dept
(
    id        int auto_increment primary key,
    dept_name varchar(64)
);

alter table tbl_employee
    add column dept_id int(10);
desc tbl_employee;

alter table tbl_employee
    add constraint fk_dept foreign key (dept_id) references tbl_dept (id);