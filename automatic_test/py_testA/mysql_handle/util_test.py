# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-29  11:42
# TOOLS : Pycharm
# FILENAME : util_test.py
# STATEMENT:

from DBUtil import MysqlUtil

MysqlUtil.exec_sql("insert into t_book(title,`read`,`comment`,pub_date) values('小明的 哥哥叫大明',50,0,'2020-01-01')")

result = MysqlUtil.exec_sql("select * from books.t_book")

print(result)
