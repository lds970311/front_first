# Author : CSR丶SUSE
# Time : 2022-01-14  22:58
# TOOLS : INTELLIJ IDEA
# FILENAME : cud2.sql
# STATEMENT:

use dbtest11;

# 2. 创建表格pet
create table if not exists pet
(
    name    varchar(20) comment '宠物名称',
    owner   varchar(20) comment '主人',
    species varchar(20) comment '种类',
    sex     char(1) comment '性别',
    birth   year comment '出生日期',
    death   year comment '死亡日'
);

# 3. 添加记录
INSERT INTO pet
VALUES ('Fluffy', 'harold', 'Cat', 'f', '2013', '2010');
INSERT INTO pet(`name`, `owner`, species, sex, Birth)
VALUES ('Claws', 'gwen', 'Cat', 'm', '2014');
INSERT INTO pet(`name`, species, sex, Birth)
VALUES ('Buffy', 'Dog', 'f', '2009');
INSERT INTO pet(`name`, `owner`, species, sex, Birth)
VALUES ('Fang', 'benny', 'Dog', 'm', '2000');
INSERT INTO pet
VALUES ('bowser', 'diane', 'Dog', 'm', '2003', '2009');
INSERT INTO pet(`name`, species, sex, birth)
VALUES ('Chirpy', 'Bird', 'f', '2008');

select *
from pet;

#4. 添加字段:主人的生日owner_birth DATE类型
alter table pet
    add owner_birth date after death;
desc pet;

# 5. 将名称为Claws的猫的主人改为kevin
update pet
set owner = 'kevin'
where name = 'Claws';

# 6. 将没有死的狗的主人改为duck
update pet
set owner = 'duck'
where death is null;
select *
from pet;
update pet
set owner = null
where name = 'Buffy'
   or name = 'Chirpy';

# 7. 查询没有主人的宠物的名字；
select name
from pet
where owner is null;
