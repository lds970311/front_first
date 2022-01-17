# Author : CSR丶SUSE
# Time : 2022-01-17  11:33
# TOOLS : INTELLIJ IDEA
# FILENAME : usr_table.sql
# STATEMENT:

show databases;
use my_jdbc;
show tables;

select *
from `order`;

# add
insert into `order`(order_name, order_date)
values ('马车', '2021-10-02');
