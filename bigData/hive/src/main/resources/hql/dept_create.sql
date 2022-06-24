use hive_db;

create table if not exists dept
(
    deptno int,
    dname  string,
    loc    int
) row format delimited fields terminated by ' ';

create table if not exists emp
(
    empno    int,
    ename    string,
    job      string,
    mgr      int,
    hiredate string,
    sal      double,
    comm     double,
    deptno   int
)
    row format delimited fields terminated by ' ';