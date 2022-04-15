# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  22:43
# TOOLS : Pycharm
# FILENAME : TestLogin.py
# STATEMENT:
import pytest
from selenium.webdriver.common.by import By

from proxy.HomeProxy import HomeProxy
from proxy.LoginPageProxy import LoginPageProxy
from proxy.MyPageProxy import MyPageProxy
from utils.DataUtil import get_login_data
from utils.Utils import DriverUtils


class TestLogin:
    def setup_class(self):
        self.home_proxy = HomeProxy()
        self.my_proxy = MyPageProxy()
        self.login_proxy = LoginPageProxy()
        self.home_proxy.click_my_btn()
        self.my_proxy.click_login()

    @pytest.mark.parametrize(argnames="username,password,msg", argvalues=get_login_data())
    def test_login(self, username, password, msg):
        self.login_proxy.login(username, password)
        result = self.login_proxy.get_tip_msg()
        assert result == msg

    def click(self):
        driver = DriverUtils.get_app_driver()
        element = driver.find_element(By.ID, "com.bjcsxq.chat.carfriend:id/check")
        element.click()
