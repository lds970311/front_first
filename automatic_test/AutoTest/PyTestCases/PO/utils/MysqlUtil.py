# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-14  20:26
# TOOLS : Pycharm
# FILENAME : MysqlUtil.py
# STATEMENT:
import pymysql


class MysqlUtil:
    # 初始化
    __connection = None
    __cursor = None

    # 创建连接
    @classmethod
    def __get_connection(cls):
        if cls.__connection is None:
            cls.__connection = pymysql.connect(
                host="192.168.208.129",
                port=3307,
                user="root",
                password="19970311",
                database="pytest_db"
            )

        return cls.__connection

    @classmethod
    def get_cursor(cls):
        if cls.__cursor is None:
            cls.__cursor = cls.__get_connection().cursor()

        return cls.__cursor

    @classmethod
    def exec_sql(cls, sql, cursor):
        try:

            cursor.execute(sql)

            # 如果是查询
            if sql.split()[0].lower() == "select":
                return cursor.fetchall()

            else:
                # 提交事务
                cls.__connection.commit()
                return cursor.rowcount
        except Exception as e:
            cls.__connection.rollback()
            print(e)
        # finally:
        #     cls.__close_cursor()
        #     cls.__close_connection()

    @classmethod
    def __close_cursor(cls):
        if cls.__cursor:
            cls.__cursor.close()
            cls.__cursor = None

    @classmethod
    def __close_connection(cls):
        if cls.__connection:
            cls.__connection.close()
            cls.__connection = None
