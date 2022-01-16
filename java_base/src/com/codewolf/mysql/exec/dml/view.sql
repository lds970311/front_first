# Author : CSR丶SUSE
# Time : 2022-01-15  18:49
# TOOLS : INTELLIJ IDEA
# FILENAME : view.sql
# STATEMENT: 视图

#1. 使用表employees创建视图employee_vu，其中包括姓名（LAST_NAME），员工号（EMPLOYEE_ID），部门号(DEPARTMENT_ID)
use codewolfdb;
show tables;

create view employees_view as
select last_name, employee_id, department_id
from employees;

show tables;

#2. 显示视图的结构
select *
from employees_view;
#3. 查询视图中的全部内容
desc employees_view;

#4. 将视图中的数据限定在部门号是80的范围内
    alter view employees_view as select last_name, employee_id, department_id
                                 from employees
                                 where employees.department_id <= 80;

select *
from employees_view;

# part2
CREATE TABLE emps_view
AS
SELECT *
FROM codewolfdb.employees;

select *
from emps_view;

alter table emps_view rename emps;
#1. 创建视图emp_v1,要求查询电话号码以‘011’开头的员工姓名和工资、邮箱
create view emp_v1 as
select *
from emps;
# 2. 要求将视图 emp_v1 修改为查询电话号码以‘011’开头的并且邮箱中包含 e 字符的员工姓名和邮箱、电话号码
select *
from emp_v1;

alter view emp_v1 as select *
                     from employees
                     where phone_number like '011%'
                       and email regexp '[e]';

#3. 向 emp_v1 插入一条记录，是否可以(no)
INSERT INTO emp_v1
VALUES ('Tom', 'tom@126.com', '1322321312');

# 修改emp_v1中员工的工资，每人涨薪1000
update emp_v1
set salary = salary + 1000;

#5. 删除emp_v1中姓名为Olsen的员
delete
from emp_v1
where last_name = 'OLsen';

#6. 创建视图emp_v2，要求查询部门的最高工资高于 12000 的部门id和其最高工资
create view emp_v2 as
select department_id, max(salary)
from employees
group by department_id
having max(salary) > 12000;

select *
from emp_v2;

#7. 向 emp_v2 中插入一条记录，是否可以(no)
insert into emp_v2
values (110, 21000);

#8. 删除刚才的emp_v2 和 emp_v1
drop view if exists emp_v2, emp_v1;