# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-03-29  20:33
# TOOLS : Pycharm
# FILENAME : Runner.py
# STATEMENT:

from unittest import TestLoader, TextTestRunner

suite = TestLoader().discover(".", "Main*.py")

runner = TextTestRunner()

runner.run(suite)
