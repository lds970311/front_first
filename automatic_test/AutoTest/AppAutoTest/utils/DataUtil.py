# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  22:58
# TOOLS : Pycharm
# FILENAME : DataUtil.py
# STATEMENT:
from utils.MysqlUtil import MysqlUtil


def get_login_data():
    cursor = MysqlUtil.get_cursor()
    data = MysqlUtil.exec_sql("select * from pytest_db.xuechebu_login", cursor)
    result = []
    for i in range(0, len(data)):
        temp = []
        for j in range(1, len(data[i])):
            temp.append(data[i][j])
        result.append(temp)
    print(result)
    return result


if __name__ == '__main__':
    get_login_data()
