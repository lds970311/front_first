# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-15  18:57
# TOOLS : Pycharm
# FILENAME : MyPageProxy.py
# STATEMENT:
from handle.MyPageHandle import MyPageHandle


class MyPageProxy():
    def __init__(self) -> None:
        super().__init__()
        self.my_page_handle = MyPageHandle()

    def click_login(self):
        self.my_page_handle.click_login_btn()
