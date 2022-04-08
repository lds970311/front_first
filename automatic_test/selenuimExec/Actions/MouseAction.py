# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-07  15:42
# TOOLS : Pycharm
# FILENAME : MouseAction.py
# STATEMENT: selenium鼠标操作

import os
import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By


def get_path():
    return os.path.abspath("../pages/drag.html")


def init_driver():
    return webdriver.Chrome()


def handle():
    driver = init_driver()
    driver.maximize_window()
    driver.get(get_path())
    div1 = driver.find_element(by=By.CSS_SELECTOR, value="#div1")
    div1.get_attribute()
    div2 = driver.find_element(by=By.CSS_SELECTOR, value="#div2")
    action = ActionChains(driver)
    action.drag_and_drop_by_offset(div2, 300, 500)
    action.drag_and_drop(div1, div2)

    action.perform()
    time.sleep(3)
    driver.close()


if __name__ == '__main__':
    handle()
