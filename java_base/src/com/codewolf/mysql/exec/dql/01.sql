# Author : CSR丶SUSE
# Time : 2022-01-12  21:30
# TOOLS : INTELLIJ IDEA
# FILENAME : 01.sql
# STATEMENT: 基本的SELECT

# 1.查询员工12个月的工资总和，并起别名为ANNUAL SALARY
select first_name, salary * 12 * (1 + ifnull(commission_pct, 0)) as "total_salary"
from employees;

# 2.查询employees表中去除重复的job_id以后的数据
select distinct `1`
from employees;

# 3.查询工资大于12000的员工姓名和工资
select first_name, salary
from employees
where salary > 12000;

# 4.查询员工号为176的员工的姓名和部门号
select first_name, department_id
from employees
where employee_id = 176;
# Jonathon 80

# 5.显示表 departments 的结构，并查询其中的全部数据
desc departments;
select *
from departments;


select 'codewolf' regexp '^c';