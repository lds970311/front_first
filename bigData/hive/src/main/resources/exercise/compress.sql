use business;

select count(name)
from score;


-- 开启 Map 输出阶段压缩（MR 引擎）
set hive.exec.compress.intermediate=true;
set mapreduce.map.output.compress=true;
set mapreduce.map.output.compress.codec= org.apache.hadoop.io.compress.SnappyCodec;

-- 开启 Reduce 输出阶段压缩
set hive.exec.compress.output=true;
set mapreduce.output.fileoutputformat.compress=true;
set mapreduce.output.fileoutputformat.compress.codec = org.apache.hadoop.io.compress.SnappyCodec;
set mapreduce.output.fileoutputformat.compress.type=BLOCK;

explain extended
select *
from score;