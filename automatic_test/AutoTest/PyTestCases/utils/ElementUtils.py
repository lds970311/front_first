# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  17:16
# TOOLS : Pycharm
# FILENAME : ElementUtils.py
# STATEMENT:
from selenium.webdriver.support.wait import WebDriverWait


def get_element_text(driver, find_type, value):
    wait = WebDriverWait(driver, 10, 0.6)
    element = wait.until(lambda x: x.find_element(find_type, value))
    return element
