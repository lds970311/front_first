use hive_db;

select count(1) total
from emp;

select deptno, avg(sal)
from emp
group by deptno;

select e.ename,
       e.empno
from emp e
         join dept