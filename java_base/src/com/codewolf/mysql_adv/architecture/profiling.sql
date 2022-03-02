# Author : CSR丶SUSE
# Time : 2022-03-01  19:55
# TOOLS : INTELLIJ IDEA
# FILENAME : profiling.sql
# STATEMENT:

select @@profiling;

set profiling = 1;

use codewolfdb;

select * from employees;

show profiles; # 显示最近的几次查询

show profile;

show variables like 'innodb_buffer_pool_size';

show engines;

set default_storage_engine = 'innodb';