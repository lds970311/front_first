# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-07  21:17
# TOOLS : Pycharm
# FILENAME : SelectAction.py
# STATEMENT:
import os
import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


def get_path():
    return os.path.abspath("../pages/注册A.html")


def init_driver():
    return webdriver.Chrome()


def handle_select():
    driver = init_driver()
    driver.get(get_path())
    driver.maximize_window()
    js = "window.scrollTo(0,1000)"
    result = driver.execute_script(js)
    if result is not None or result != "":
        print(result)
    select = driver.find_element_by_id("selectA")
    element = Select(select)
    element.select_by_value("gz")
    driver.find_element_by_id("gwA").click()
    driver.find_element(By.ID, "alerta").click()
    # 获取弹出框
    alert = driver.switch_to.alert
    print(alert.text)
    alert.dismiss()
    time.sleep(4)

    driver.quit()


if __name__ == '__main__':
    handle_select()
