# Author : CSR丶SUSE
# Time : 2022-02-12  21:36
# TOOLS : INTELLIJ IDEA
# FILENAME : delete.sql
# STATEMENT:

use mybatis;
show tables;
select *
from tbl_employee;
delete
from tbl_employee
where id > 10;

update mybatis.tbl_employee
set status = 'login';