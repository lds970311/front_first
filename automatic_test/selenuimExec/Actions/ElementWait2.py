# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-07  20:22
# TOOLS : Pycharm
# FILENAME : ElementWait2.py
# STATEMENT:

import os
import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait


def get_path():
    return os.path.abspath("../pages/注册A.html")


def init_driver():
    return webdriver.Chrome()


def handle_wait():
    driver = init_driver()
    driver.get(get_path())
    driver.maximize_window()
    element = WebDriverWait(driver, 5, 0.5).until(
        lambda x: x.find_element(By.XPATH, "/html/body/div/div[2]/div[1]/input[1]"))

    element.send_keys("admin123")
    element2 = WebDriverWait(driver, 6, 0.5).until(
        lambda x: x.find_element(By.XPATH, "/html/body/div/div[2]/div[1]/input[2]"))
    element2.send_keys("admin123111")
    time.sleep(4)

    driver.quit()


if __name__ == '__main__':
    handle_wait()
