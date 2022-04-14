# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  17:09
# TOOLS : Pycharm
# FILENAME : Login.py
# STATEMENT:
import time

from selenium import webdriver
from selenium.webdriver.common.by import By

from utils import ElementUtils


class TestLogin:
    def setup(self):
        self.driver = webdriver.Chrome()
        self.addr = "http://192.168.208.129:92/index.php/home/Index/index.html"
        self.driver.get(self.addr)
        self.driver.maximize_window()
        self.driver.implicitly_wait(10)

    def test_login_success(self):
        login_ele = self.driver.find_element(By.LINK_TEXT, "登录")
        login_ele.click()
        info = {
            "userName": "2696612575@qq.com",
            "password": "19970311"
        }
        ElementUtils.get_element(self.driver, By.ID, "username").send_keys(info["userName"])
        ElementUtils.get_element(self.driver, By.ID, "password").send_keys(info["password"])
        ElementUtils.get_element(self.driver, By.ID, "verify_code").send_keys("8888")
        ElementUtils.get_element(self.driver, By.NAME, "sbtbutton").click()
        time.sleep(5)

    def teardown(self):
        self.driver.quit()
