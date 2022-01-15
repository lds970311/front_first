# Author : CSR丶SUSE
# Time : 2022-01-13  19:43
# TOOLS : INTELLIJ IDEA
# FILENAME : 04.sql
# STATEMENT: 多表查询1

# 1.显示所有员工的姓名，部门号和部门名称。
select e.first_name, e.department_id, d.department_name
from employees e
         LEFT join departments d
                   on e.department_id = d.department_id;

# 2.查询90号部门员工的job_id和90号部门的location_id
select e.`1`, l.location_id
from employees e
         left join departments d on e.department_id = d.department_id
         left join locations l on d.location_id = l.location_id
where e.department_id <=> 90;
# 3条


# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
select e.last_name as '名字', d.department_name as '部门名称', l.location_id as '坐标id', l.city as '城市'
from employees e
         left join departments d on e.department_id = d.department_id
         left join locations l on d.location_id = l.location_id
where e.commission_pct is not null;

# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name
select e.last_name, e.`1`, d.department_name, d.department_id
from employees e
         join departments d on e.employee_id = d.manager_id
         join locations l on d.location_id = l.location_id
where l.city = 'Toronto';
#Hartstein

# 5.查询员工所在的部门名称、部门地址、姓名、工作、工资，其中员工所在部门的部门名称为’Executive’
select d.department_name, l.city, e.first_name, j.job_title, e.salary
from employees e
         join departments d on e.department_id = d.department_id
         join locations l on d.location_id = l.location_id
         join jobs j on e.`1` = j.job_id
where d.department_name <=> 'Executive';
#3

# 6.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
SELECT emp.last_name   employees,
       emp.employee_id "Emp#",
       mgr.last_name   manager,
       mgr.employee_id "Mgr#"
FROM employees emp
         LEFT OUTER JOIN employees mgr
                         ON emp.manager_id = mgr.employee_id;

# 7.查询哪些部门没有员工(16)
select d.department_name
from employees e
         RIGHT join departments d on e.department_id = d.department_id
where e.department_id IS NULL;

# 8. 查询哪个城市没有部门(16)
select l.city
from departments d
         right join locations l on d.location_id = l.location_id
where d.location_id is NULL;

# 9. 查询部门名为 Sales 或 IT 的员工信息(34)
select *
from employees e
         join departments d on e.department_id = d.department_id
where d.department_name <=> 'Sales'
   or d.department_id <=> 'IT';