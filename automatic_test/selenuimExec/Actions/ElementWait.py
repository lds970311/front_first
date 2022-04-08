# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-07  19:54
# TOOLS : Pycharm
# FILENAME : ElementWait.py
# STATEMENT:
import os
import time

from selenium import webdriver
from selenium.webdriver.common.by import By


def get_path():
    return os.path.abspath("../pages/注册A.html")


def init_driver():
    return webdriver.Chrome()


def handle_wait():
    driver = init_driver()
    driver.get(get_path())
    driver.maximize_window()
    driver.implicitly_wait(5)
    element = driver.find_element(By.XPATH, "/html/body/div/div[2]/div[1]/input[1]")
    element.send_keys("admin123")
    element2 = driver.find_element(By.XPATH, "/html/body/div/div[2]/div[1]/input[2]")
    element2.send_keys("admin123111")
    time.sleep(4)
    driver.quit()


if __name__ == '__main__':
    handle_wait()
