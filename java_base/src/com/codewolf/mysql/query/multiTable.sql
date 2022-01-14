# Author : CSR丶SUSE
# Time : 2022-01-13  18:46
# TOOLS : INTELLIJ IDEA
# FILENAME : multiTable.sql
# STATEMENT: 多表

select *
from job_grades;

#非等值
select last_name, salary, grade_level
from employees e,
     job_grades j
where e.salary between j.lowest_sal and j.highest_sal;

#自连接
select em.last_name, em.employee_id, mgr.last_name, mgr.employee_id
from employees em,
     employees mgr
where em.manager_id = mgr.employee_id;