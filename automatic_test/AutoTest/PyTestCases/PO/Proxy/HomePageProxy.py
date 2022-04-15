# _*_ coding : UTF-8 _*_
# Author : CSR丶WARRIOR
# Time ： 2022-04-14  19:53
# TOOLS : Pycharm
# FILENAME : HomePageProxy.py
# STATEMENT:
from PO.Handle.HomePageHandle import HomePageHandle


class HomePageProxy:
    def __init__(self) -> None:
        self.handle = HomePageHandle()

    def click_login(self):
        self.handle.click_login()
