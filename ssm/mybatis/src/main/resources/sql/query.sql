# Author : CSR丶SUSE
# Time : 2022-02-10  22:07
# TOOLS : INTELLIJ IDEA
# FILENAME : query.sql
# STATEMENT:

show tables;
select e.id, last_name, gender, email, d.id as did, d.dept_name
from tbl_employee e
         inner join tbl_dept d on e.dept_id = d.id;