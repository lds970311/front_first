use part;

create table dept_partition
(
    deptno int,
    dname  string,
    loc    string
)
    partitioned by (day string)
    row format delimited fields terminated by ' ';