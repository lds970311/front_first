# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  20:20
# TOOLS : Pycharm
# FILENAME : LoginPage.py
# STATEMENT:
from selenium.webdriver.common.by import By
from selenium.webdriver.remote.webelement import WebElement

from PO.Page.BasePage import BasePage


class LoginPage(BasePage):
    def __init__(self) -> None:
        super().__init__()
        # 用户名输入框
        self.username = (By.ID, "username")
        self.password = (By.ID, "password")
        self.verify_code = (By.ID, "verify_code")
        self.login_btn = (By.NAME, "sbtbutton")
        self.forget_pwd = (By.PARTIAL_LINK_TEXT, "忘记密码")

    def find_user_name(self) -> WebElement:
        return self.find_element(self.username)

    def find_password(self) -> WebElement:
        return self.find_element(self.password)

    def find_verify_code(self) -> WebElement:
        return self.find_element(self.verify_code)

    def find_login_btn(self) -> WebElement:
        return self.find_element(self.login_btn)

    def find_forget_pwd(self) -> WebElement:
        return self.find_element(self.forget_pwd)
