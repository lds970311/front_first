# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  20:23
# TOOLS : Pycharm
# FILENAME : LoginHandle.py
# STATEMENT:
from PO.Handle.BaseHandle import BaseHandle
from PO.Page.LoginPage import LoginPage


class LoginHandle(BaseHandle):
    """
    登录操作层
    """

    def __init__(self) -> None:
        self.login_page = LoginPage()

    def input_user_name(self, user_name: str) -> None:
        element = self.login_page.find_user_name()
        self.input_text(element, user_name)

    def input_password(self, password: str) -> None:
        element = self.login_page.find_password()
        self.input_text(element, password)

    def input_verify_code(self, code: str) -> None:
        element = self.login_page.find_verify_code()
        self.input_text(element, code)

    def click_login_btn(self):
        self.login_page.find_login_btn().click()

    def click_forget_pwd(self):
        self.login_page.find_forget_pwd().click()
