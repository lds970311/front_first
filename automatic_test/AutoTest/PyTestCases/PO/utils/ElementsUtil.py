# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  21:58
# TOOLS : Pycharm
# FILENAME : ElementsUtil.py
# STATEMENT:
from selenium import webdriver
from selenium.webdriver.common.by import By


def get_element_text(driver: webdriver.Chrome, find_type: By, desc: str):
    return driver.find_element(find_type, desc).text
