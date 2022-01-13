# Author : CSR丶SUSE
# Time : 2022-01-12  23:36
# TOOLS : INTELLIJ IDEA
# FILENAME : 02.sql
# STATEMENT: 运算符

# 1.选择工资不在5000到12000的员工的姓名和工资
select first_name, salary
from employees
where salary not between 5000 and 12000;

# 2.选择在20或50号部门工作的员工姓名和部门号
select first_name, department_id
from employees
where department_id <=> 20
   or department_id <=> 50;

# 3.选择公司中没有管理者的员工姓名及job_id
select job_id
from employees
where manager_id IS NULL;

# 4.选择公司中有奖金的员工姓名，工资和奖金级别
select concat(first_name, last_name) as "name",
       salary,
       commission_pct
from employees
where commission_pct is NOT NULL;

# 5.选择员工姓名的第三个字母是a的员工姓名
select concat(first_name, last_name) as "name"
from employees
where first_name like '__a%';

# 6.选择姓名中有字母a和k的员工姓名
select concat(first_name, last_name) as "name"
from employees
where first_name like '%a%'
  and first_name like '%k%';

# 7.显示出表 employees 表中 first_name 以 'e'结尾的员工信息
select *
from employees
where first_name regexp 'e$';

# 8.显示出表 employees 部门编号在 80-100 之间的姓名、工种
select concat(first_name, last_name) as "name",
       employee_id
from employees
where department_id between 80 and 100;

# 9.显示出表 employees 的 manager_id 是 100,101,110 的员工姓名、工资、管理者id
select concat(first_name, last_name) as "name",
       salary,
       manager_id
from employees
where manager_id in (100, 101, 110);