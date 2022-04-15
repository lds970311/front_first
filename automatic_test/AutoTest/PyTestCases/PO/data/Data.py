# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-14  21:40
# TOOLS : Pycharm
# FILENAME : Data.py
# STATEMENT:
from PO.utils.MysqlUtil import MysqlUtil


def login_data(sql):
    cursor = MysqlUtil.get_cursor()
    data = MysqlUtil.exec_sql(sql, cursor)
    result = []
    for i in range(1, len(data)):
        temp = []
        for j in range(1, len(data[1])):
            temp.append(data[i][j])
        result.append(temp)
    return result


if __name__ == '__main__':
    res = login_data(MysqlUtil.get_cursor(), "select * from pytest_db.user_info")
    print(res)
