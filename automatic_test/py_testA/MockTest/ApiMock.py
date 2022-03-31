# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-31  9:46
# TOOLS : Pycharm
# FILENAME : ApiMock.py
# STATEMENT:

import json

from flask import Flask, jsonify, request

app = Flask(__name__)

from mysql_handle.DBUtil import MysqlUtil


@app.route("/index")
def index():
    print("访问的index主页")
    return "hello mock"


@app.route("/api/sys/login", methods=["POST"])
def login():
    result = json.loads(request.get_data().decode("utf-8"))
    mobile = result.get("mobile")
    password = result.get("password")
    print(mobile, password)
    if mobile == "13800000002" and password == "123456":
        data = {
            "success": True,
            "code": 10000,
            "message": "操作成功！",
            "token": "ajsdfj-12312-szs-fd-dfs"
        }
    else:
        data = {
            "success": False,
            "code": 99999,
            "message": "抱歉，系统繁忙，请稍后重试",
            "token": None
        }
    return data


@app.route("/heros/list", methods=["GET"])
def get_all_heros():
    result = MysqlUtil.exec_sql("select * from t_hero")
    return jsonify(result)


if __name__ == '__main__':
    app.run()
