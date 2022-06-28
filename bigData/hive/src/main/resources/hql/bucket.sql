use part;

create table stu_buck
(
    id   int,
    name string
)
    clustered by (id)
        into 4 buckets
    row format delimited fields terminated by ' ';


select *
from stu_buck;

-- 抽样查询
select *
from stu_buck tablesample (bucket 2 out of 4);