# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  18:33
# TOOLS : Pycharm
# FILENAME : MyPage.py
# STATEMENT:
from appium.webdriver import WebElement
from selenium.webdriver.common.by import By

from base.BaseInfo import BasePage


class MyPage(BasePage):

    def __init__(self) -> None:
        super().__init__()
        self.login_btn = (By.XPATH, "//*[@text='登录/注册']")

    def get_login_btn(self) -> WebElement:
        return self.find_element(self.login_btn)
