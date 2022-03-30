CREATE DATABASE if not EXISTS books DEFAULT charset utf8;
use books;
Drop TABLE if EXISTS `t_book`;
CREATE TABLE `t_book`
(
    `id`        int(11)     not null auto_increment,
    `title`     VARCHAR(20) not NULL COMMENT '图书名称',
    `pub_date`  date        not NULL COMMENT '发布日期',
    `read`      int(11)     not null default '0' comment '阅读量',
    `comment`   int(11)     not null default '0' comment '评论量',
    `is_delete` TINYINT(1)  not NULL DEFAULT '0' COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8 COMMENT ='图书表';
INSERT into `t_book`
VALUES ('1', '射雕英雄传', '1980-05-01', '12', '34', '0');
INSERT into `t_book`
VALUES ('2', '天龙八部', '1986-07-24', '36', '40', '0');
INSERT into `t_book`
VALUES ('3', '笑傲江湖', '1995-12-24', '20', '80', '0');
Drop TABLE if EXISTS `t_hero`;
CREATE TABLE `t_hero`
(
    `id`          int(11)     not null auto_increment,
    `name`        VARCHAR(20) not NULL COMMENT '姓名',
    `gender`      SMALLINT(6) not NULL COMMENT '性别',
    `description` VARCHAR(200)         default NULL comment '描述',
    `is_delete`   TINYINT(1)  not NULL DEFAULT '0' COMMENT '逻辑删除',
    `book_id`     int(11)     not null comment '所属图书ID',
    PRIMARY KEY (`id`),
    key `t_hero_book_id` (`book_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8 COMMENT ='英雄人物表';
INSERT into `t_hero`
VALUES ('1', '郭靖', '1', '降龙十八掌', '0', '1');
INSERT into `t_hero`
VALUES ('2', '黄蓉', '0', '打狗棍法', '0', '1');
INSERT into `t_hero`
VALUES ('3', '乔峰', '1', '降龙十八掌', '0', '2');
INSERT into `t_hero`
VALUES ('4', '令狐冲', '1', '独孤九剑', '0', '3');
INSERT into `t_hero`
VALUES ('5', '任盈盈', '0', '弹琴', '0', '3');


update books.t_book
set title='东游记'
where title = '西游记';