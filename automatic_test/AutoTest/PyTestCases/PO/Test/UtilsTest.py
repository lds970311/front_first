# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-14  20:30
# TOOLS : Pycharm
# FILENAME : UtilsTest.py
# STATEMENT:
from PO.utils.MysqlUtil import MysqlUtil


def connection_test():
    cursor = MysqlUtil.get_cursor()
    result = MysqlUtil.exec_sql("select * from user_info", cursor)
    print(result)


if __name__ == '__main__':
    connection_test()
