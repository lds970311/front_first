# Author : CSR丶SUSE
# Time : 2022-01-14  13:46
# TOOLS : INTELLIJ IDEA
# FILENAME : function02.sql
# STATEMENT: 聚合函数

#1.where子句可否使用组函数进行过滤? (no,使用having)

#2.查询公司员工工资的最大值，最小值，平均值，总和
select max(salary), min(salary), avg(salary), sum(salary)
from employees;

#3.查询各job_id的员工工资的最大值，最小值，平均值，总和
select distinct count(job_id)
from employees;
select max(salary), min(salary), avg(salary), sum(salary)
from employees
group by job_id;

#4.选择具有各个job_id的员工人数
select job_id, count(*)
from employees
group by job_id;

# 5.查询员工最高工资和最低工资的差距（DIFFERENCE）
select max(salary) - min(salary) as 'difference'
from employees;

# 6.查询各个管理者手下员工的最低工资，其中最低工资不能低于6000，没有管理者的员工不计算在内
select min(salary)
from employees
where manager_id is not null
group by manager_id
having min(salary) > 6000;

# 7.查询所有部门的名字，location_id，员工数量和平均工资，并按平均工资降序
select d.department_name, d.location_id, count(e.employee_id), avg(e.salary)
from departments d
         left join employees e on d.department_id = e.department_id
group by d.department_id
order by avg(e.salary) desc;

# 8.查询每个工种、每个部门的部门名、工种名和最低工资
select e.job_id, d.department_name, min(e.salary)
from employees e
         right join departments d on e.department_id = d.department_id
group by d.department_name, e.job_id;