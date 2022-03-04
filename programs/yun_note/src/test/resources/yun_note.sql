# Author : CSR丶SUSE
# Time : 2022-03-04  1:13
# TOOLS : INTELLIJ IDEA
# FILENAME : yun_note.sql
# STATEMENT:

show databases;
use yun_note;

select *
from yun_note.tb_note;

select count(*)
from yun_note.tb_note
where typeId = 1;