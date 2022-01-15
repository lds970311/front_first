# Author : CSR丶SUSE
# Time : 2022-01-14  17:37
# TOOLS : INTELLIJ IDEA
# FILENAME : sub_query.sql
# STATEMENT: 子查询

#1.查询和Zlotkey相同部门的员工姓名和工资
select first_name, salary
from employees
where department_id = (
    select department_id
    from employees
    where last_name = 'Zlotkey'
);

#2.查询工资比公司平均工资高的员工的员工号，姓名和工资。
select employee_id, first_name, salary
from employees
where salary > (
    select avg(salary)
    from employees
);

#3.选择工资大于所有JOB_ID = 'SA_MAN'的员工的工资的员工的last_name, job_id, salary
select last_name, job_id, salary
from employees
where salary > ALL (
    select salary
    from employees
    where job_id <=> 'SA_MAN'
);


#4.查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
select employee_id, last_name
from employees
where department_id = ANY (
    select distinct department_id
    from employees
    where last_name like '%u%'
);

#5.查询在部门的location_id为1700的部门工作的员工的员工号
select distinct employee_id
from employees
where department_id IN (select department_id
                        from departments
                        where location_id <=> 1700
);

#6.查询管理者是King的员工姓名和工资
select last_name, salary
from employees
where manager_id IN (
    select employee_id
    from employees
    where last_name <=> 'king'
);

#7.查询工资最低的员工信息: last_name, salary
select last_name, salary
from employees
where salary = ALL (
    select min(salary)
    from employees
);

#8.查询平均工资最低的部门信息
select department_id, department_name
from departments
where department_id = (
    select employees.department_id
    from employees
    group by employees.department_id
    having avg(salary) <= ALL (
        select avg(salary)
        from employees
        group by department_id
    )
);


#9.查询平均工资最低的部门信息和该部门的平均工资（相关子查询）
select department_id, department_name
from departments
where department_id = (
    select department_id
    from employees
    group by department_id
    having avg(salary) <= ALL (
        select avg(salary)
        from employees
        group by department_id
    )
);

#10.查询平均工资最高的 job 信息
SELECT *
FROM jobs
WHERE job_id = (
    SELECT job_id
    FROM employees
    GROUP BY job_id
    HAVING AVG(salary) >= ALL (
        SELECT AVG(salary)
        FROM employees
        GROUP BY job_id
    )
);
#11.查询平均工资高于公司平均工资的部门有哪些?
select department_name, department_id
from departments
where department_id IN (
    select department_id
    from employees
    group by employees.department_id
    having avg(salary) >= ALL (
        select avg(salary)
        from employees
    )
);

SELECT department_id
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING AVG(salary) > (
    SELECT AVG(salary)
    FROM employees
);


#12.查询出公司中所有 manager 的详细信息
select first_name, employee_id
from employees
where employee_id IN (
    select distinct manager_id
    from employees
    where manager_id is not null
);

#13.各个部门中 最高工资中最低的那个部门的 最低工资是多少?
select min(salary)
from employees
where department_id = (
    select department_id
    from employees
    group by department_id
    having max(salary) <= ALL (
        select max(salary)
        from employees
        group by department_id
    )
);

#14.查询平均工资最高的部门的 manager 的详细信息: last_name, department_id, email, salary
select last_name, department_id, email, salary
from employees
where employee_id IN (
    select manager_id
    from employees
    where department_id = (
        select department_id
        from employees
        group by department_id
        having AVG(salary) >= ALL (
            select avg(salary)
            from employees
            group by department_id
        )
    )
);

#15. 查询部门的部门号，其中不包括job_id是"ST_CLERK"的部门号
select distinct department_id
from departments
where department_id not in (
    select employees.department_id
    from employees
    where job_id <=> 'ST_CLERK'
);


#16. 选择所有没有管理者的员工的last_name
select last_name
from employees
where manager_id is null;

#17．查询员工号、姓名、雇用时间、工资，其中员工的管理者为 'De Haan'
select employee_id, last_name, hire_date, salary
from employees
where manager_id = (
    select employee_id
    from employees
    where last_name <=> 'De Haan'
);

#18.查询各部门中工资比本部门平均工资高的员工的员工号, 姓名和工资（相关子查询）
select employee_id, last_name, salary
from employees
where salary > (
    select avg(salary)
    from employees e2
    where e2.department_id = employees.department_id
);
#19.查询每个部门下的部门人数大于 5 的部门名称（相关子查询）
SELECT department_name, department_id
FROM departments d
WHERE 5 < (
    SELECT COUNT(*)
    FROM employees e
    where d.department_id = e.department_id
);
#20.查询每个国家下的部门个数大于 2 的国家编号（相关子查询
select country_id
from locations l
where 2 < (select count(*)
           from departments d
           where d.location_id = l.location_id
);