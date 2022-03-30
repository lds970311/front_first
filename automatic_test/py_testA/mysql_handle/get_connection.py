# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-29  11:07
# TOOLS : Pycharm
# FILENAME : get_connection.py
# STATEMENT:

import pymysql

# 创建连接
connection = pymysql.connect(
    host="192.168.208.129",
    port=3307,
    user="root",
    password="19970311",
    database="books",
)

# 获取游标
cursor = connection.cursor()

# 执行sql
# cursor.execute("select id, title, `read`, `comment` from t_book")
# result = cursor.fetchone()
# print(result)

# 插入一条数据
sql = "update books.t_book set title='东游记' where title = '西游记'"
cursor.execute(sql)

if cursor.rowcount > 0:
    print(cursor.rowcount)
    print("修改成功")

# 关闭游标
cursor.close()
# 关闭连接
connection.close()
