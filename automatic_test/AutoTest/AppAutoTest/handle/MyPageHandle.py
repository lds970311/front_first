# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  18:55
# TOOLS : Pycharm
# FILENAME : MyPageHandle.py
# STATEMENT:
from base.BaseInfo import BaseHandle
from pages.MyPage import MyPage


class MyPageHandle(BaseHandle):
    def __init__(self) -> None:
        super().__init__()
        self.my_page = MyPage()

    def click_login_btn(self):
        self.my_page.get_login_btn().click()
