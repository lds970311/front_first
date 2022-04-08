# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-07  14:27
# TOOLS : Pycharm
# FILENAME : OpsForNavigator.py
# STATEMENT:
import os
import time

from selenium import webdriver

driver = webdriver.Chrome()


def open_browser():
    driver.get("https://www.sohu.com")


def get_content():
    dest = os.path.abspath("../contents/content.txt")
    news = driver.find_elements_by_xpath("//div[@class='news']/p/a[@class='titleStyle']")
    with open(dest, "w", encoding="utf-8") as f:
        for new in news:
            f.writelines(new.text + '\n')


def ops_for_navigator():
    get_content()
    driver.set_window_size(800, 600)
    driver.set_window_position(0, 0)
    time.sleep(5)
    driver.quit()


if __name__ == '__main__':
    open_browser()
    ops_for_navigator()
