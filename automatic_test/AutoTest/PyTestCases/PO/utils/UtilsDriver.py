# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  19:58
# TOOLS : Pycharm
# FILENAME : UtilsDriver.py
# STATEMENT:
import time

from selenium import webdriver
from selenium.webdriver.common.by import By


class UtilsDriver:
    _driver = None

    # 定义一个获取浏览器驱动对象的方法
    @classmethod  # 表示这个方法是一个类级别的方法
    def get_driver(cls):
        if cls._driver is None:  # 判断driver是否已创建，如果为None就需要去创建浏览器驱动对象，如果不为None，则直接返回driver
            cls._driver = webdriver.Chrome()
            cls._driver.maximize_window()
            cls._driver.implicitly_wait(10)
        return cls._driver

    # 定义一个退出浏览器驱动对象的方法  浏览器驱动对象退出之后，还有一串效的字符串存在
    @classmethod
    def quit_driver(cls):
        if cls._driver is not None:
            cls.get_driver().quit()
            cls._driver = None


# 定义一个获取弹出框消息的方法
def get_msg():
    time.sleep(1)
    # driver = UtilsDriver()
    return UtilsDriver.get_driver().find_element(By.CSS_SELECTOR, ".layui-layer-content").text
