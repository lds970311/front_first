# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-30  9:00
# TOOLS : Pycharm
# FILENAME : runSuite.py
# STATEMENT:
import time
from unittest import TestLoader

from lib.HTMLTestRunner import HTMLTestRunner

suite = TestLoader().discover("script", "Test*.py")

# 指定报告路径
report = "./report/report-{}.html".format(time.strftime("%Y%m%d-%H%M%S"))

with open(report, "wb") as f:
    runner = HTMLTestRunner(f, title="登录模块测试报告")
    runner.run(suite)
