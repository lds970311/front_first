# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-14  19:47
# TOOLS : Pycharm
# FILENAME : HomePage.py
# STATEMENT:
from selenium.webdriver.common.by import By

from PO.Page.BasePage import BasePage


class HomePage(BasePage):
    def __init__(self) -> None:
        super().__init__()
        self.login_btn = (By.LINK_TEXT, "登录")

    def get_login_btn(self):
        return self.find_element(self.login_btn)
