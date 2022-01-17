# Author : CSR丶SUSE
# Time : 2022-01-16  18:22
# TOOLS : INTELLIJ IDEA
# FILENAME : procedure2.sql

# 一. MySQL变量

#0.准备工作
CREATE DATABASE test_var_cur;
use test_var_cur;
CREATE TABLE employees
AS
SELECT *
FROM codewolfdb.`employees`;
CREATE TABLE departments
AS
SELECT *
FROM codewolfdb.`departments`;
show tables;
select *
from departments;
select *
from employees;


#无参有返回
#1. 创建函数get_count(),返回公司的员工个数
set global log_bin_trust_function_creators = 1;
create function get_count()
    returns int
begin
    declare count int default 0;
    select count(*) from employees into count;
    return count;
end;

select get_count();

#有参有返回
#2. 创建函数ename_salary(),根据员工姓名，返回它的工资
create function ename_salary(name varchar(32))
    returns double
begin
    declare sal double default 0.0;
    select salary from employees where first_name = name into sal;
    return sal;
end;

select ename_salary('Lex');

#3. 创建函数dept_sal() ,根据部门名，返回该部门的平均工资
drop function if exists dept_sal;
create function dept_sal(dept_name varchar(32))
    returns double
begin
    declare avg_sal double default 0.0;
    select avg(salary)
    into avg_sal
    from employees e
             left join departments d on e.department_id = d.department_id
    where d.department_name = dept_name;

    return avg_sal;
end;

select dept_sal('Contracting');


#4. 创建函数add_float()，实现传入两个float，返回二者之和
create function add_float(val1 int, val2 int)
    returns float
begin
    set @total = 0.0;
    select val1 + val2 into @total;
    return @total;
end;

select add_float(1.2, 6.4);
select @total;


# 二.流程控制
CREATE TABLE admin
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(25) NOT NULL,
    user_pwd  VARCHAR(35) NOT NULL
);
select *
from admin;


#1. 创建函数test_if_case()，实现传入成绩，如果成绩>90,返回A，如果成绩>80,返回B，如果成绩>60,返回
drop function test_if_case;
create function test_if_case(score int)
    returns char
begin
    declare grade char default '';
    case
        when score > 90 then set grade = 'A';
        when score > 80 then set grade = 'B';
        when score > 60 then set grade = 'C';
        else set grade = 'D';
        end case;
    return grade;
end;

select test_if_case(83);

#要求：分别使用if结构和case结构实现
#2. 创建存储过程test_if_pro()，传入工资值，如果工资值<3000,则删除工资为此值的员工，如果3000 <= 工资值 <= 5000,则修改此工资值的员工薪资涨1000，否则涨工资500
create procedure test_if_pro(in sal int)
begin
    declare emp_id int;
    select employee_id into emp_id from employees where salary = sal;
    if sal < 3000
    then
        delete from employees where employee_id = emp_id;
    elseif sal >= 3000 and sal <= 5000
    then
        update employees set salary = salary + 1000 where employee_id = emp_id;
    else
        update employees set salary = salary + 500 where employee_id = emp_id;
    end if;
end;
call test_if_pro(2100);

#3. 创建存储过程insert_data(),传入参数为 IN 的 INT 类型变量 insert_count,实现向admin表中批量插入insert_count条记录
create procedure insert_data(in insert_count int)
begin
    declare i int default 1;
    WHILE insert_count > 0
        DO
            INSERT INTO admin(user_name, user_pwd)
            VALUES (CONCAT('Rose-', i), ROUND(RAND() *
                                              100000));
            set insert_count = insert_count - 1;
            set i = i + 1;

        end while;
end;

truncate table admin;
call insert_data(1000);

# 三. 游标的使用
/*创建存储过程update_salary()，参数1为 IN 的INT型变量dept_id，表示部门id；参数2为 IN的INT型变量
change_sal_count，表示要调整薪资的员工个数。查询指定id部门的员工信息，按照salary升序排列，根
据hire_date的情况，调整前change_sal_count个员工的薪资*/
drop procedure if exists update_salary;
create procedure update_salary(in dept_id int, in change_sal_count int)
begin

    declare salary_rate double default 0.0;
    DECLARE emp_id INT;
    DECLARE emp_hire_date DATE;
    #定义游标
    declare my_cursor cursor for select employee_id, hire_date
                                 from employees
                                 where department_id = dept_id
                                 order by salary;
    #打开游标
    open my_cursor;
    while change_sal_count > 0
        DO
            #判断年份
            fetch my_cursor into emp_id,emp_hire_date;
            if year(emp_hire_date) < 1995 then
                set salary_rate = 1.2;
            elseif year(emp_hire_date) >= 1995 and year(emp_hire_date) <= 1998 then
                set salary_rate = 1.15;
            elseif year(emp_hire_date) > 1998 and year(emp_hire_date) <= 2001 then
                set salary_rate = 1.10;
            else
                set salary_rate = 1.05;
            end if;

            # 更新salary
            update employees set salary = salary * salary_rate where employee_id = emp_id;
            set change_sal_count = change_sal_count - 1;
        end while;
    close my_cursor;
end;

CALL update_salary(50, 2);