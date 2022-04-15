# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  22:35
# TOOLS : Pycharm
# FILENAME : LoginPageProxy.py
# STATEMENT:
from handle.LoginPageHandle import LoginPageHandle


class LoginPageProxy:
    def __init__(self) -> None:
        super().__init__()
        self.login_page_handle = LoginPageHandle()

    # 实现登录功能
    def login(self, mobile, password):
        self.login_page_handle.input_tel(mobile)  # 输入手机号
        self.login_page_handle.input_password(password)  # 输入密码
        self.login_page_handle.click_checkbox()
        self.login_page_handle.click_login()  # 点击登录

    # 定义一个获取弹出框消息的业务操作
    def get_tip_msg(self):
        msg = self.login_page_handle.get_txt_msg()  # 获取弹出框信息
        # UtilsDriver.get_app_driver().refresh()
        self.login_page_handle.click_confirm()  # 点击确定按钮
        return msg
