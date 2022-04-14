# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-13  21:50
# TOOLS : Pycharm
# FILENAME : LoginProxy.py
# STATEMENT:
from PO.Handle.LoginHandle import LoginHandle


class LoginProxy:
    def __init__(self) -> None:
        self.login_handle = LoginHandle()

    def login(self, username, password, verify_code):
        self.login_handle.input_user_name(username)
        self.login_handle.input_password(password)
        self.login_handle.input_verify_code(verify_code)
        self.login_handle.click_login_btn()

    # 跳转到忘记密码页面
    def to_forget_pwd_page(self):
        self.login_handle.click_forget_pwd()
