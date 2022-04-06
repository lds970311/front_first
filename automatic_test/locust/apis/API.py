# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-04  22:46
# TOOLS : Pycharm
# FILENAME : API.py
# STATEMENT:
from locust import TaskSet, HttpUser


# 定义任务
# 登录
def login(l):
    l.client.post("/login", data={"username": "admin", "password": "123456"})


# 首页
def index(l):
    l.client.get("/index")


# 获取用户信息
def profile(l):
    l.client.get("/profile")


# 退出
def logout(l):
    l.client.post("/logout")


# 定义任务集
class UserBehaiver(TaskSet):
    tasks = {index: 4, profile: 1}

    def on_start(self):
        login(self)

    def on_stop(self):
        logout(self)


# 定义用户类
class UserWebsite(HttpUser):
    tasks = [UserBehaiver]
    min_wait = 1000
    max_wait = 1500
    host = "http://bms-test.itheima.net/bms"
    weight = 10
