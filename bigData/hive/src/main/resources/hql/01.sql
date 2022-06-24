create table person
(
    name     string,
    friends  array<string>,
    children map<string, int>,
    address  struct<street : string, city : string>
)
    row format delimited fields terminated by ','
        collection items terminated by '_'
        map keys terminated by ':'
        lines terminated by '\n';


use default;

truncate table student_par;