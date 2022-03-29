# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-28  11:20
# TOOLS : Pycharm
# FILENAME : testsuite_demo.py
# STATEMENT:

from unittest import TestLoader

from HTMLTestRunner import HTMLTestRunner

suite = TestLoader().discover(".", "testcase*.py")
file = open("test01.html", "wb")

# 执行测试用例,生成报告
# runner = TextTestRunner(stream=file, verbosity=2)
runner = HTMLTestRunner(stream=file, title="测试报告")
runner.run(suite)
file.close()
