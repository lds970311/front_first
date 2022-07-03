use dept;
-- （1）查询在 2017 年 4 月份购买过的顾客及总人数
select name, count(*) over ()
from business
where substring(orderdate, 1, 7) = '2017-04'
group by name;

-- （2）查询顾客的购买明细及月购买总额
select name, orderdate, cost, sum(cost) over (partition by month(orderdate))
from business;

-- （3）上述的场景, 将每个顾客的 cost 按照日期进行累加
select name,
       orderdate,
       cost,
       sum(cost) over ()                                     as sample1,--所有行相加
       sum(cost) over (partition by name)                    as sample2,--按 name 分组，组内数据相加
       sum(cost) over (partition by name order by orderdate) as sample3,--按 name分组，组内数据累加
       sum(cost) over (partition by name order by orderdate rows between
           UNBOUNDED PRECEDING and current row )             as sample4,--和 sample3 一样,由起点到当前行的聚合
       sum(cost) over (partition by name order by orderdate rows between 1
           PRECEDING and current row)                        as sample5, --当前行和前面一行做聚合
       sum(cost) over (partition by name order by orderdate rows between 1
           PRECEDING AND 1 FOLLOWING )                       as sample6,--当前行和前边一行及后面一行
       sum(cost) over (partition by name order by orderdate rows between current
           row and UNBOUNDED FOLLOWING )                     as sample7 --当前行及后面所有行
from business;

-- （4）查询每个顾客上次的购买时间
select name,
       orderdate,
       cost,
       lag(orderdate, 1, '1900-01-01') over (partition by name order by orderdate )
                                                                     as time1,
       lag(orderdate, 2) over (partition by name order by orderdate) as
                                                                        time2
from business;

-- （5）查询前 20%时间的订单信息
select *
from (select name, orderdate, cost, ntile(5) over (order by orderdate) sorted
      from business) t
where sorted = 1;