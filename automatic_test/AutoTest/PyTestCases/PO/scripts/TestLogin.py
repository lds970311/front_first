# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  19:59
# TOOLS : Pycharm
# FILENAME : TestLogin.py
# STATEMENT:
import time

from selenium.webdriver.common.by import By

from PO.Proxy.LoginProxy import LoginProxy
from PO.utils.UtilsDriver import UtilsDriver
from utils import ElementUtils


class TestLogin:
    def setup_class(self):
        self.driver = UtilsDriver.get_driver()
        self.login_proxy = LoginProxy()

    def setup(self):
        self.driver.get("http://192.168.208.129:92/index.php/home/Index/index.html")
        self.driver.maximize_window()
        self.driver.implicitly_wait(10)
        self.driver.find_element_by_link_text("登录").click()

    def test_login_username_is_error(self):
        self.login_proxy.login("13099999999", "123456", "8888")
        time.sleep(3)
        msg = ElementUtils.get_element_text(self.driver, By.CLASS_NAME, "layui-layer-content")
        print("msg=", msg)
        msg == "账号不存在"

    def teardown_class(self):
        UtilsDriver.quit_driver()
