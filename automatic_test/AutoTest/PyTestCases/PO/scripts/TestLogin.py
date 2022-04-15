# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  19:59
# TOOLS : Pycharm
# FILENAME : TestLogin.py
# STATEMENT:
import logging
import time

import pytest
from selenium.webdriver.common.by import By

from PO.Proxy.HomePageProxy import HomePageProxy
from PO.Proxy.LoginProxy import LoginProxy
from PO.data.Data import login_data
from PO.utils.UtilsDriver import UtilsDriver
from utils import ElementUtils


class TestLogin:
    def setup_class(self):
        self.driver = UtilsDriver.get_driver()
        self.login_proxy = LoginProxy()
        self.homepage_proxy = HomePageProxy()
        logging.basicConfig(level=logging.INFO,
                            format="%(asctime)s %(levelname)s [%(name)s] [%(filename)s(%(funcName)s:%(lineno)d)] - %(message)s")

    def setup(self):
        self.driver.get("http://192.168.208.129:92/index.php/home/Index/index.html")
        self.driver.maximize_window()
        self.driver.implicitly_wait(10)

    @pytest.mark.run(order=1)
    @pytest.mark.parametrize(argnames="username,password,verify_code,result",
                             argvalues=login_data("select * from pytest_db.user_info"))
    def test_login_username_is_error(self, username, password, verify_code, result):
        self.homepage_proxy.click_login()
        self.login_proxy.login(username, password, verify_code)
        time.sleep(3)
        msg = ElementUtils.get_element_text(self.driver, By.CLASS_NAME, "layui-layer-content")
        logging.info(f'msg={result}')

        msg == result
        self.driver.refresh()

    def teardown_class(self):
        UtilsDriver.quit_driver()
