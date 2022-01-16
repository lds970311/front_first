# Author : CSR丶SUSE
# Time : 2022-01-15  21:47
# TOOLS : INTELLIJ IDEA
# FILENAME : procedure.sql
# STATEMENT:

#0.准备工作
CREATE DATABASE test15_pro_func;
USE test15_pro_func;
show tables;

CREATE TABLE admin
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(15) NOT NULL,
    pwd       VARCHAR(25) NOT NULL
);
desc admin;

CREATE TABLE beauty
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    NAME  VARCHAR(15) NOT NULL,
    phone VARCHAR(15) UNIQUE,
    birth DATE
);
INSERT INTO beauty (NAME, phone, birth)
VALUES ('朱茵', '13201233453 ', '1982-02-12 '),
       ('孙燕姿 ', '13501233653', ' 1980-12-09'),
       ('田馥甄', '13651238755', '1983-08-21'),
       ('邓紫棋', '17843283452',
        '1991-11-12'),
       ('刘若英', '18635575464', '1989-05-18'),
       ('杨超越', '13761238755', '1994-05-11');

select *
from beauty;

#1. 创建存储过程insert_user(),实现传入用户名和密码，插入到admin表中
create procedure insert_user(in usr_name varchar(20), in pwd varchar(20))
begin
    insert into admin(user_name, pwd) values (usr_name, pwd);
end;

call insert_user('Joel', '1234556');

set @usr := 'Sam';
set @pwd1 := '99887766';
call insert_user(@usr, @pwd1);

select *
from admin;

#2. 创建存储过程get_phone(),实现传入女神编号，返回女神姓名和女神电话
create procedure get_phone(in no int, out n varchar(14), out tel varchar(15))
begin
    select NAME, phone into n,tel from beauty where id = no;
end;

set @n = '';
set @tel = '';
call get_phone('2', @n, @tel);
select @n;
select @tel;

#3. 创建存储过程date_diff()，实现传入两个女神生日，返回日期间隔大小
drop procedure if exists date_diff;
create procedure date_diff(in d1 DATE, in d2 DATE, out gap int)
begin
    select DATEDIFF(d1, d2) into gap;
end;

SET @birth1 = '1992-09-08';
SET @birth2 = '1989-01-03';
call date_diff(@birth1, @birth2, @result);
select @result;



# 存储函数练习

#0. 准备工作
USE test15_pro_func;
CREATE TABLE employees
AS
SELECT *
FROM codewolfdb.`employees`;
CREATE TABLE departments
AS
SELECT *
FROM codewolfdb.`departments`;
show tables;
show create table departments;
#无参有返回
#1. 创建函数get_count(),返回公司的员工个数
create function get_count()
    returns int
begin
    return (select count(*) from employees);
end;

select get_count();

#有参有返回
#2. 创建函数ename_salary(),根据员工姓名，返回它的工资
create function ename_salary(n varchar(16))
    returns double(8, 2)
begin
    return (select salary from employees where first_name = n);
end;

select ename_salary('Pat');

#3. 创建函数dept_sal() ,根据部门名，返回该部门的平均工资

create function dept_sal(dept_name varchar(16))
    returns double(8, 2)
begin
    return (select avg(salary)
            from employees
            group by department_id
            having department_id = (
                select department_id
                from departments
                where department_name = dept_name
            ));
end;

select dept_sal('Marketing');

#4. 创建函数add_float()，实现传入两个float，返回二者之和
drop function if exists add_float;
create function add_float(a float, b float)
    returns float
begin
    return (select a + b);
end;

select add_float(1.2, 3.4);

show function status;
show procedure status;
#0. 准备工作
#无参有返回
