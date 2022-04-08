# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-07  17:08
# TOOLS : Pycharm
# FILENAME : DragVerify.py
# STATEMENT:
import os
import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By


def get_path():
    return os.path.abspath("../pages/验证码/index.html")


def drag_element():
    path = get_path()
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get(path)
    element = driver.find_element(By.CSS_SELECTOR, ".handler_bg")
    # 拖动元素
    action = ActionChains(driver)
    action.drag_and_drop_by_offset(element, 261, 0)
    action.perform()
    time.sleep(2)
    driver.quit()


if __name__ == '__main__':
    drag_element()
