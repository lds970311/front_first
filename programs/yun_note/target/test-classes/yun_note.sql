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

select count(1)
from tb_note n
         inner join tb_note_type tnt on n.typeId = tnt.typeId
where tnt.userId = 1;

select n.noteId, n.title, n.content, n.typeId, n.pubTime, n.lon, n.lat
from tb_note n
         inner join tb_note_type tnt on n.typeId = tnt.typeId
where tnt.userId = 1
limit 5,2;


select date_format(pubTime, '%Y年%m月') as `groupName`, count(1) as noteCount
from tb_note n
         inner join tb_note_type tnt on n.typeId = tnt.typeId
where userId = 1
group by date_format(pubTime, '%Y年%m月')
order by groupName desc;

select tn.typeId, count(1) as noteCount, tnt.typeName as groupName
from tb_note tn
         inner join tb_note_type tnt on tn.typeId = tnt.typeId
where tnt.userId = 1
group by tnt.typeName
order by noteCount desc;

select *
from tb_note
where noteId = 1;


select typeName
from tb_note_type
where typeId = 1;

select distinct date_format(pubTime, '%Y年%m月')
from tb_note tn
         inner join tb_note_type tnt on tn.typeId = tnt.typeId
where userId = 1
order by date_format(pubTime, '%Y年%m月') asc;

select count(1)
from tb_note tn
         inner join tb_note_type tnt on tn.typeId = tnt.typeId
where userId = 1
group by date_format(pubTime, '%Y年%m月')
order by date_format(pubTime, '%Y年%m月');

select lon, lat
from tb_note
         left join tb_note_type tnt on tnt.typeId = tb_note.typeId
where userId = 2;