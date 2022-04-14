# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  22:18
# TOOLS : Pycharm
# FILENAME : BaseHandle.py
# STATEMENT:
from selenium.webdriver.remote.webelement import WebElement


class BaseHandle:
    def input_text(self, element: WebElement, text: str):
        element.clear()
        element.send_keys(text)
