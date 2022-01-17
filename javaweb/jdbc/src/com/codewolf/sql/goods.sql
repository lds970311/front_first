# Author : CSR丶SUSE
# Time : 2022-01-17  22:10
# TOOLS : INTELLIJ IDEA
# FILENAME : goods.sql
# STATEMENT:

CREATE TABLE goods
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(20)
);

desc goods;

insert into goods(NAME)
VALUES ('name');

delete
from goods;