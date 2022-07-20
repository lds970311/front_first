use business;

select name,
       subject,
       score,
       rank() over (partition by subject order by score desc)       rp,
       dense_rank() over (partition by subject order by score desc) drp,
       row_number() over (partition by subject order by score desc) rmp
from score;

select unix_timestamp("2022-07-12", "yyyy-MM-dd");

select `current_date`();

select year(unix_timestamp());

desc function unix_timestamp;

select day("2022-07-12 22:11:00") day;

select months_between("2022-07-12", "2035-12-01");

SELECT regexp_replace('2020/10/25', '/', '-');

select floor(3.14);

select lpad('atguigu', 9, 'g');

show functions;

drop
temporary
function my_len;

