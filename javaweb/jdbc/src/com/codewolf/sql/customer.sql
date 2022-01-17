# Author : CSR丶SUSE
# Time : 2022-01-17  19:08
# TOOLS : INTELLIJ IDEA
# FILENAME : customer.sql
# STATEMENT:

use my_jdbc;

select *
from customers;

select name, email, birth
from customers
where id = 1;
