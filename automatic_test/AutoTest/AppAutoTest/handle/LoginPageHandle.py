# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  22:21
# TOOLS : Pycharm
# FILENAME : LoginPageHandle.py
# STATEMENT:
from base.BaseInfo import BaseHandle
from pages.LoginPage import LoginPage


class LoginPageHandle(BaseHandle):
    def __init__(self) -> None:
        super().__init__()
        self.login_page = LoginPage()

    def input_tel(self, text: str):
        tel_no = self.login_page.get_tel_no()
        self.input_text(tel_no, text)

    def input_password(self, text: str):
        password = self.login_page.get_password()
        self.input_text(password, text)

    def click_checkbox(self):
        checkbox = self.login_page.get_read_checkbox()
        self.set_radio_checked(checkbox)

    def click_login(self):
        btn = self.login_page.get_login_btn()
        btn.click()

    def get_txt_msg(self):
        msg = self.login_page.get_txt_msg()
        return msg.text

    # 点击确定
    def click_confirm(self):
        self.login_page.find_confirm().click()
