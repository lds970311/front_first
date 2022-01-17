# Author : CSR丶SUSE
# Time : 2022-01-17  12:05
# TOOLS : INTELLIJ IDEA
# FILENAME : user.sql
# STATEMENT:

show tables;
select *
from user;

update user
set name = '梁静茹'
where id = 4;

delete
from user
where id = 1;

select name, password, address, phone
from user;