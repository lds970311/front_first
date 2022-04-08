# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-07  19:18
# TOOLS : Pycharm
# FILENAME : KeyboardAction.py
# STATEMENT:
import os
import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys


def get_path():
    return os.path.abspath("../pages/注册A.html")


def init_driver():
    return webdriver.Chrome()


def handle():
    driver = init_driver()
    driver.maximize_window()
    driver.get(get_path())
    element = driver.find_element(by=By.CSS_SELECTOR, value="#userA")
    element.send_keys("admin")
    element.send_keys(Keys.BACK_SPACE)
    time.sleep(3)
    driver.quit()


if __name__ == '__main__':
    handle()
