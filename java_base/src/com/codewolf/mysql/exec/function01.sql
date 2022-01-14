# Author : CSR丶SUSE
# Time : 2022-01-13  23:18
# TOOLS : INTELLIJ IDEA
# FILENAME : function01.sql
# STATEMENT: 单行函数

# 1.显示系统时间(注：日期+时间)
select NOW();

# 2.查询员工号，姓名，工资，以及工资提高百分之20%后的结果（new salary）
select employee_id, first_name, salary, salary * 12 as new_salary
from employees;

# 3.将员工的姓名按首字母排序，并写出姓名的长度（length）
select first_name, length(first_name)
from employees
order by LENGTH(first_name) desc;

# 4.查询员工id,last_name,salary，并作为一个列输出，别名为OUT_PUT
select concat(employee_id, '-', last_name, '-', salary) as OUT_PUT
from employees;

# 5.查询公司各员工工作的年数、工作的天数，并按工作年数的降序排序
select datediff(now(), hire_date)    as 'DAYS',
       YEAR(NOW()) - YEAR(hire_date) AS 'YEARS'
from employees
ORDER BY YEARS DESC;

# 6.查询员工姓名，hire_date , department_id，满足以下条件：雇用时间在1997年之后，department_id
select hire_date, department_id
from employees
where YEAR(hire_date) > 1997;


# 7.查询公司中入职超过10000天的员工姓名、入职时间
select concat(first_name, last_name) as 'NAME'
FROM employees
where datediff(now(), hire_date) > 10000;

# 8.做一个查询，产生下面的结果:<last_name> earns <salary> monthly but wants <salary*3>
select concat(last_name, ' earns ', salary, ' monthly but wants ', salary * 3) as 'res'
FROM employees;

# 9.使用case-when，按照下面的条件：
select last_name,
       CASE job_id
           when 'AD_PRES' then 'A'
           when 'ST_MAN' then 'B'
           when 'IT_PROG' then 'C'
           when 'SA_REP' then 'D'
           when 'ST_CLERK' then 'E'
           ELSE 'F'
           END 'Grade'
from employees
