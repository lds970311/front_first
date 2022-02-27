# Author : CSR丶SUSE
# Time : 2022-02-26  21:14
# TOOLS : INTELLIJ IDEA
# FILENAME : 01.character.sql
# STATEMENT:
show databases ;

use codewolfdb;

#查看表的字符集
show create table employees;

#查看表的比较规则
show table status from codewolfdb like 'employees';

#修改表的字符集和比较规则
ALTER TABLE employees DEFAULT CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

# 查看当前的sql_mode
select @@session.sql_mode;