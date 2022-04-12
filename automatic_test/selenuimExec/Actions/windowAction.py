# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-07  23:21
# TOOLS : Pycharm
# FILENAME : windowAction.py
# STATEMENT:
import os
import time

from appium import webdriver
from selenium import webdriver


def get_path():
    return os.path.abspath("../pages/注册A.html")


def init_driver():
    return webdriver.Chrome()


def handle_window():
    driver = init_driver()
    driver.maximize_window()
    driver.get(get_path())
    driver.implicitly_wait(5)
    link = driver.find_element_by_id("fw")
    link.click()
    # 获取页签信息
    handle = driver.window_handles
    for i in handle:
        print(i)
    driver.switch_to.window(handle[0])
    driver.close()
    time.sleep(100)


if __name__ == '__main__':
    handle_window()
